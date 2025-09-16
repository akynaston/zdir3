# Manipulating node sets in IDM via Set Operations - Cool Solutions | NetIQ

## Manipulating node sets in IDM via Set Operations

## Merging, Subtracting and Intersecting

Thanks to the power and simplicity of DirXML-Script tokens in Identity Manager, one can implement even quite complex policies, whilst only rarely needing to dig directly into the underlying XML. This was not always the case, especially in the first few versions of Identity Manager, which relied on XPath and XSLT stylesheets. These days, with the latest version of Identity Manager (4.5 at the time of writing) XSLT is largely gone.

XPath can be challenging to debug within Identity Manager. It is somewhat of a black box, there is no easy ability to trace the inner workings of an XPath expression in IDM. A compounding factor is the challenge of combining fragments of smaller XPath statements to achieve the desired result.

I have observed in particular, several newcomers to XPath daisy chain multiple if-statements one after the other or construct variables piecemeal based on fragments of XML.

When asked, it generally turns out that they did this because they were unable to construct a single expression that concisely achieved the same effect.

In maybe half of these cases, the union operator and some grouping via brackets is all that was missing.

Regardless, XPath still finds a place in many more advanced policies where it offers the most concise and efficient approach. Sometimes even, XPath turns out to be the only solution.

One area where I strongly believe XPath is the right choice is when working with input that involves more than one set of multi-valued data (i.e. multiple node sets).

The usual approach is to for-each over one set and compare each node against the nodes in the other node set.

Based on the comparison result, the code then performs actions on each compared node as required, which is often another nested do-for-each. You very quickly end up with four or more levels of do-for-each, and likely also nested if-then-else within each loop.

This is a design pattern I have observed many times in both my own and others’ DirXML-Script code. It is generally quick to develop and it can be easier for a novice to read/follow the logic.

The problem is that it is hard to maintain and is rarely ideal as a long-term solution.

In particular, the technique has many significant limitations:

* It can be slow and tedious to debug.

* The verbosity of the trace that a “do-for-each” loop generates is overwhelming, you get lost in the details.
* Designer is extremely clunky when working with nested do-for-each and if-then structures, requiring a lot of clicking to make a simple change.

An alternative approach is to use XPath to perform the relevant arithmetic to compute a resultant node set, which contains only the desired elements based on the two input node sets. This eliminates the requirement for one (or possibly more) for-each-loops and can greatly simplify future troubleshooting.

I will present this approach within this article.

The remainder of the article assumes a passing familiarity with XPath.

* * *

### Set theory

Set theory is a mathematical concept, which applies to XPath as several ways to combine disparate groups of nodes into a derived set based on the properties of said nodes.

This article will cover only three set operations that are either built-in or easily implemented in XPath. It will also outline real-world use cases for each.

These set operations, which are covered in this article, are:

* Union

* Difference
* Intersection

In XPath 1.0, node identity union is the only native built in set-operation. This does not mean that the other set operations are not possible. They can all be implemented by utilizing the existing functions and operators offered by XPath 1.0. This requires careful attention to detail when constructing the correct expression. XPath 2.0 corrects this unfortunate deficiency. Unfortunately, XPath 2.0 is neither supported, nor likely to ever be compatible with NetIQ Identity Manager.

Before we delve into the actual set operations, we must clarify several important distinctions.

### Node Identity versus Value Identity

Most common examples of set theory as applied to XPath refer to Node Identity. This identity is more than just a node’s value. In essence, this means that each node in a node-set is considered unique and not identical to any other node within the node set (even if several nodes happen to have the same value). This uniqueness is maintained even when you combine two distinct node sets. One of the factors by which this uniqueness is enforced is via the internal ordering of each node within the XML document or node set.

### Value Identity

It is unfortunate that most generic XPath set operation examples do not refer to value identity. This oversight will be addressed here as value identity set operations are very relevant in the IDM/DirXML context. In fact, it is this category that I personally use most often.

With value identity, only the value of the node is considered. It excludes other factors like a node’s type or order within the node set.

### Node References

As a vital pre-requisite to the remaining concepts of this article, I must expand upon Father Ramon’s excellent explanation of the internals of IDM node sets from the IAM product forums.

I suggest you start by reading his post (linked below) and then continue with my expanded version.
[https://forums.netiq.com/showthread.php?12157-strip-XPath-on-local-variable-why-doesn-t-it-work&p=59124#post59124](https://forums.netiq.com/showthread.php?12157-strip-xpath-on-local-variable-why-doesn-t-it-work&amp;p=59102)

Essentially each node set (regardless of whether it is a local variable or otherwise) in IDM contains a set of zero or more references to nodes. These aforementioned nodes actually refer to nodes in a specific document. Thanks to this design, the same node can be (and often is) referenced from multiple node sets, but this specific node can only exist in one document (which may or may not be the current-op).

In addition, a node can only have single parent node.

This is a very confusing and contradictory behaviour, which is in not in any way obvious. Yet when properly understood and correctly harnessed it can be extremely powerful.

One of these confusing behaviours occurs when you use the do-strip-xpath token against a node set. On the surface, it appears to remove matching nodes from that node set. However what it actually does is to each matching node is to revoke the parent child relationship within the document from which the node originated. Performing a strip XPath on nodes referred to by a node set does not directly change the node set indicated as the target of the strip XPath expression. Instead, what changes is the nodes’ relationship to their parent node, which is never a node set.

## XPath Set Operations

### Union

#### Node Identity Union

Concerning creating composite or combined expressions, one of the more overlooked operators in XPath is the Union operator (|). To calculate the Union of two node sets one simply places a pipe character | between two (or more) expressions that return a node set. This instructs XPath to construct the node identity Union of the node sets.

Being completely honest, when I first started using XPath – I really did not understand the power of this operator and rarely used it. This has changed as I have dug further into XPath.

As we are dealing with node identity, rather than value identity – the result of the Union operation creates a node set which contains references to the distinct nodes from the source node sets. The union preserves the order of nodes as per the source documents or result fragments whilst filtering out any node identity duplicates.

A trap for young players is that quite often this will produce a result that often appears identical to simply appending the source node sets (set addition). This will only occur when the two source node sets are not derived from the same document. This is only a perception, however as this is an exception to the rule. In addition, there are several important distinctions when contrasted against the regular append of nodes using DirXML-Script.

1. With union operator, an undefined variable combined with a populated node set will return only the populated node set. In contrast set addition using the local-variable token, results in an empty, but present node combined with the populated node set. This has tripped me up several times. Such a combination is rarely desirable. Using the resulting node set in later policy often requires additional logic to either strip or handle such empty nodes.

* If the two source node sets arise from the same document, then the union will include common nodes only once in the result.

#### Value Identity Union

The value-identity Union, better known as distinct values as in the SQL statement “select distinct x from y” Given an expression that selects values from one or more node sets, value identity union can be calculated using built-in XPATH functions and operators. This relies on either the preceding-sibling or preceding axis. However, this is not efficient and scales poorly.

Thus, it generally is far better to handle this in ECMAScript.

Father Ramon first mentioned this EXCMAScript function in the following forum post: <https://forums.netiq.com/showthread.php?7638-Finding-duplicates-within-a-nodeset&amp;p=35483#post35483>.

As with other useful ECMAScripts, this function is collected/published in the following Cool Solutions article. <https://www.netiq.com/communities/cool-solutions/open-call-useful-ecma-functions-use-identity-manager/>

I highly recommend that both the unique and duplicates functions are utilized in every IDM project as required.

* * *

### Intersection

#### Node Identity Intersection

This identifies nodes that are common between two node sets. Whilst there is no built in operator for intersection in XPath 1.0, one can implement this by using a combination of the count function and the union operator.
`<token-xpath expression="$set1[count(string(.) | $set2) = count($set2)]"/>`

The logic being that the for each node from set1, the count will only be equal if the node is also present in set2. Thus, it can be included in the intersection of nodes.
Remember this is node identity so it takes into account the node as it appears in the source document, not the position of the node in set 1 or 2.

#### Value Identity Intersection

Value-identity intersection is also possible, it is even simpler, simply checks each and every value exists in the other set.

`<token-xpath expression="$set1[string(.) = $set2]"/>`

### Difference

#### Node Identity difference

Again, somewhat self-explanatory, identifies nodes that are different between two source node sets.
The expression for node-identity difference is:

`<token-xpath expression="$set1[count(string(.) | $set2) != count($set2)]"/>`

#### Value Identity difference

The expression for value-identity difference. It simply checks each value and returns those that do not exist in the other set

`<token-xpath expression="$set1[not(. = $set2)] )"/>`

This gives the values in set1 that are not in set2

if you want the values in set2 that are not in set1 invert the expression.
`<token-xpath expression="$set2[not(. = $set1)] )"/>`

Note that both value-identity intersection and value-identity difference can potentially return duplicate values. If that is not desirable then wrap the expression with a value-identity unique ECMAScript function.

## Set operations in everyday DirXML-Script

One of the most useful places for value intersection/difference is when you have a list of attributes you want to do something special with when they appear in current operation.

Rather than hard code each attribute within each policy as required, maybe you have placed this list a GCV and perform a do-for-each over this list.
If so, then the following policy is for you. Note how in one line, it calculates the intersection between your GCV list and the current-op attrs, finally it proceeds to loop over this.
Also, note how the GCV is referenced via the local-variable style dollar prefix within XPath.
You might be tempted to use the tilde ~my.gcv.name~ syntax. That will not work as that substitutes the plain text from the GCV (and will fail unless you wrap the GCV reference in single quotes), rather than a node set that represents the list.

<do-for-each>
    <arg-node-set>
        <token-xpath expression="\*/@attr-name\[string(.) = $myListGCVofAttrs\]"/>
    </arg-node-set>
    <arg-actions>
        <do-trace-message>
            <arg-string>
                <token-local-variable name="current-node"/>
                <token-text xml:space="preserve"> is present in the current-op, do something with it!</token-text>
            </arg-string>
        </do-trace-message>
    </arg-actions>
</do-for-each>
<

As I mentioned earlier, this makes for a very verbose trace that is sometimes hard to troubleshoot.

Instead, via set operations, one can first cut down the list to those items that actually appear in the current op. Then only for-each over that list.

If you want only attributes that do not appear in your GCV list (difference) instead, use the following instead:

<do-for-each>
    <arg-node-set>
        <token-xpath expression="\*/@attr-name\[not(string(.) = $myListGCVofAttrs)\]"/>
    </arg-node-set>
    <arg-actions>
        <do-trace-message>
            <arg-string>
                <token-local-variable name="current-node"/>
                <token-text xml:space="preserve"> is present in the current-op, do something with it!</token-text>
            </arg-string>
        </do-trace-message>
    </arg-actions>
</do-for-each>    

You can also fine-tune the selection of op-attrs. For example, you might want to only do something when an attribute is added not removed or cleared.

Also, keep in mind that these results might have duplicates and that if distinct values are required, the expressions above should be wrapped in an es:unique call.

Another example is a simplified version of something that a forum user asked about.
This loops through and finds the first un-used series-attribute on a related object,
The logic to find the first un-used attribute makes use of value-identity difference. This would have been extremely complicated code if that was not used (the code still has three nested for-each loops).

In this example, rather than use a GCV, the split token is used to generate the node sets of attribute lists.</p

<rule>
    <description>Match related object and find first free ID.</description>
    <conditions/>
    <actions>
        <do-set-local-variable name="personIDs" scope="policy">
            <arg-node-set>
                <token-split delimiter=",">
                    <token-text xml:space="preserve">personID1,personID2,personID3,personID4</token-text>
                </token-split>
            </arg-node-set>
        </do-set-local-variable>
        <do-set-local-variable name="relationshipIDs" scope="policy">
            <arg-node-set>
                <token-split delimiter=",">
                    <token-text xml:space="preserve">relationshpID1,relationshpID2,relationshpID3 ,relationshpID4</token-text>
                </token-split>
            </arg-node-set>
        </do-set-local-variable>
        <do-for-each>
            <arg-node-set>
                <token-local-variable name="relationshipIDs"/>
            </arg-node-set>
            <arg-actions>
                <do-set-local-variable name="currentRelationshpIDX" scope="policy">
                    <arg-string>
                        <token-local-variable name="current-node"/>
                    </arg-string>
                </do-set-local-variable>
                <do-for-each>
                    <arg-node-set>
                        <token-attr name="$currentRelationshpIDX$"/>
                    </arg-node-set>
                    <arg-actions>
                        <do-set-local-variable name="currentRelationshpID-value" scope="policy">
                            <arg-string>
                                <token-local-variable name="current-node"/>
                            </arg-string>
                        </do-set-local-variable>
                        <do-for-each>
                            <arg-node-set>
                                <token-query class-name="User" datastore="src">
                                    <arg-match-attr name="ID">
                                        <arg-value type="string">
                                            <token-local-variable name="currentRelationshpID-value"/>
                                        </arg-value>
                                    </arg-match-attr>
                                    <arg-string>
                                        <token-text xml:space="preserve">personID1</token-text>
                                    </arg-string>
                                    <arg-string>
                                        <token-text xml:space="preserve">personID2</token-text>
                                    </arg-string>
                                    <arg-string>
                                        <token-text xml:space="preserve">personID3</token-text>
                                    </arg-string>
                                    <arg-string>
                                        <token-text xml:space="preserve">personID4</token-text>
                                    </arg-string>
                                </token-query>
                            </arg-node-set>
                            <arg-actions>
                                <do-set-local-variable name="usedIDs" scope="policy">
                                    <arg-node-set>
                                        <token-xpath expression="$current-node//\*\[@attr-name=$personIDs\]/@attr-name"/>
                                    </arg-node-set>
                                </do-set-local-variable>
                                <do-set-local-variable name="firstFreeID" scope="policy">
                                    <arg-string>
                                        <token-xpath expression="$personIDs\[not(string(.)=$usedIDs)\]\[1\]"/>
                                    </arg-string>
                                </do-set-local-variable>
                                <do-if>
                                    <arg-conditions>
                                        <and>
                                            <if-local-variable mode="regex" name="firstFreeID" op="equal">.+</if-local-variable>
                                        </and>
                                    </arg-conditions>
                                    <arg-actions>
                                        <do-trace-message>
                                            <arg-string>
                                                <token-text xml:space="preserve">Do something with the first free ID on the current relationship ID</token-text>
                                            </arg-string>
                                        </do-trace-message>
                                    </arg-actions>
                                    <arg-actions/>
                                </do-if>
                            </arg-actions>
                        </do-for-each>
                    </arg-actions>
                </do-for-each>
            </arg-actions>
        </do-for-each>
    </actions>
</rule>

One final note, up until now, I’ve neglected node identity examples. This isn’t because they are less useful. Just that the value identity is easier to comprehend first.

There are plenty of use cases for node identity intersection and difference.

A perfect example is where you process a series of nodes from the current document, mark those that are required by cloning them to a local variable. Then once the processing is completed, use node identity difference to strip all the unwanted nodes (the ones that did not match).

The following rules demonstrate an example of this logic to thin query responses from an app which had no built-in filtering capabilities for search.

The code consists of two rules, the first just saves some useful details for the second rule.

<rule>
    <description>Save search criteria for later use</description>
    <comment xml:space="preserve">adjust conditions and then place this in the output transform</comment>
    <conditions>
        <and>
            <if-operation mode="regex" op="equal">query|query-ex</if-operation>
        </and>
    </conditions>
    <actions>
        <do-set-op-property name="search-attr-b64">
            <arg-string>
                <token-base64-encode>
                    <token-xml-serialize>
                        <token-xpath expression="search-attr"/>
                    </token-xml-serialize>
                </token-base64-encode>
            </arg-string>
        </do-set-op-property>
    </actions>
</rule>

It is in the second rule where all the hard work is done and which demonstrates practical usage of node identity intersection.

<rule>
    <description>Strip unwanted instances</description>
    <comment xml:space="preserve">Place this in the input transform. 
    Query returns all objects, identify correct objects as based on the original search criteria.
    This only works reliably when the status is the last node under output.
    </comment>
    <conditions>
        <and>
            <if-operation mode="case" op="equal">status</if-operation>
            <if-xml-attr mode="nocase" name="level" op="equal">success</if-xml-attr>
            <if-op-property mode="regex" name="search-attr-b64" op="equal">.+</if-op-property>
            <if-xpath op="true">count(//instance)>0</if-xpath>
        </and>
    </conditions>
    <actions>
        <do-set-local-variable name="search-attrs" scope="policy">
            <arg-node-set>
                <token-xml-parse>
                    <token-base64-decode charset="UTF-8">
                        <token-op-property name="search-attr-b64"/>
                    </token-base64-decode>
                </token-xml-parse>
            </arg-node-set>
        </do-set-local-variable>
        <do-set-local-variable name="retInstances" notrace="true" scope="policy">
            <arg-node-set>
                <token-xpath expression="//instance" notrace="true"/>
            </arg-node-set>
        </do-set-local-variable>
        <do-for-each>
            <arg-node-set>
                <token-xpath expression="$search-attrs/search-attr"/>
            </arg-node-set>
            <arg-actions>
                <do-set-local-variable name="retInstances" scope="policy">
                    <arg-node-set>
                        <token-xpath expression="$retInstances\[attr\[@attr-name=$current-node/@attr-name\]/value = $current-node/value\[1\]\]"/>
                    </arg-node-set>
                </do-set-local-variable>
            </arg-actions>
        </do-for-each>
        <do-strip-xpath expression="//instance\[count(. | $retInstances) != count($retInstances)\]"/>
    </actions>
</rule>

![[./_resources/Manipulating_node_sets_in_IDM_via_Set_Operations_-_Cool_Solutions__NetIQ.resources/rating_on.gif]]![[./_resources/Manipulating_node_sets_in_IDM_via_Set_Operations_-_Cool_Solutions__NetIQ.resources/rating_on.gif]]![[./_resources/Manipulating_node_sets_in_IDM_via_Set_Operations_-_Cool_Solutions__NetIQ.resources/rating_on.gif]]![[./_resources/Manipulating_node_sets_in_IDM_via_Set_Operations_-_Cool_Solutions__NetIQ.resources/rating_on.gif]]![[./_resources/Manipulating_node_sets_in_IDM_via_Set_Operations_-_Cool_Solutions__NetIQ.resources/rating_on.gif]] (_**1** votes, average: **5.00** out of 5_)
_You need to be a registered member to rate this post._

Tags: [DirXMLScript](https://www.netiq.com/communities/cool-solutions/tag/dirxmlscript/), [Identity Manager](https://www.netiq.com/communities/cool-solutions/tag/identity-manager/), [XPATH](https://www.netiq.com/communities/cool-solutions/tag/xpath/)
Categories: [Identity & Access Management](https://www.netiq.com/communities/cool-solutions/category/identity-access-management-2/), [Identity Manager](https://www.netiq.com/communities/cool-solutions/category/identity-manager/), [Technical Solutions](https://www.netiq.com/communities/cool-solutions/category/technical-solutions/)

* [____](https://www.netiq.com/communities/cool-solutions/manipulating-node-sets-idm-via-set-operations/#)

* [____](https://www.netiq.com/communities/cool-solutions/manipulating-node-sets-idm-via-set-operations/#)
* [____](https://www.netiq.com/communities/cool-solutions/manipulating-node-sets-idm-via-set-operations/#)
* [____](https://www.netiq.com/communities/cool-solutions/manipulating-node-sets-idm-via-set-operations/#)
* [____](https://www.netiq.com/communities/cool-solutions/manipulating-node-sets-idm-via-set-operations/#)
* [2 ](https://www.netiq.com/communities/cool-solutions/manipulating-node-sets-idm-via-set-operations/#comments)

* * *

__**Disclaimer:** As with everything else at NetIQ Cool Solutions, this content is definitely not supported by NetIQ, so Customer Support will not be able to help you if it has any adverse effect on your environment.  It just worked for at least one person, and perhaps it will be useful for you too.  Be sure to test in a non-production environment.__

### Leave a Reply

You must be [logged in](https://www.netiq.com/communities/cool-solutions/wp-login.php?redirect_to=https%3A%2F%2Fwww.netiq.com%2Fcommunities%2Fcool-solutions%2Fmanipulating-node-sets-idm-via-set-operations%2F) to post a comment.

#### 2 Comments

* ![[./_resources/Manipulating_node_sets_in_IDM_via_Set_Operations_-_Cool_Solutions__NetIQ.resources/unknown_filename.png]] [geoffc](http://wiki.novell.com/index.php/Geoffrey_Carman%27s_personal_collection) says:
	[November 13, 2015 at 9:59 am](https://www.netiq.com/communities/cool-solutions/manipulating-node-sets-idm-via-set-operations/#comment-24682)
	
	In the section “Set operations in everyday DirXML-Script” the second example uses the XPATH of:
	\*/@attr-name\[not(string(.) = $myListGCVofAttrs)\]
	
	This returns the attributes in the XDS document that are NOT in the GCV list. This is good for filtering stuff.
	
	But you might have an app where on modify, you need to send ALL attributes every time. (I suppose ditching Matching, and always forcing a merge would make the filter do it).
	
	IIn that case you might wish to have a test for attrs in a list that the XDS document is missing. In which case, the for-each XPATH expression should be more like:
	$REQUIRED-ATTRS\[not(string(.) = \*/@attr-name)\]
	
	[Log in to Reply](https://www.netiq.com/communities/cool-solutions/wp-login.php?redirect_to=https%3A%2F%2Fwww.netiq.com%2Fcommunities%2Fcool-solutions%2Fmanipulating-node-sets-idm-via-set-operations%2F)
	* ![[./_resources/Manipulating_node_sets_in_IDM_via_Set_Operations_-_Cool_Solutions__NetIQ.resources/unknown_filename.1.png]] Alexander McHugh says:
		[December 1, 2015 at 5:49 am](https://www.netiq.com/communities/cool-solutions/manipulating-node-sets-idm-via-set-operations/#comment-24693)
		
		I went down that rabbit hole (detecting which attributes are missing from the document and adding them). Wrote code to do this, but there is a far easier way (as you alluded to).
		
		The best practices approach is to let the filter do the work by stripping association and dest-dn in the subscriber event transform as the last sub-etp policy.
		
		`<rule> <description>Force all attributes to be included in modify</description> <conditions> <or> <if-operation mode="case" op="equal">modify</if-operation> <if-class-name mode="regex" op="equal">User</if-class-name> <if-association notrace="true" op="associated"/> </or> </conditions> <actions> <do-strip-xpath expression="@dest-dn | association"/> </actions> </rule>`
		
		Downsides: Does not exclude future values (which is rarely a real-world problem)
		
		[Log in to Reply](https://www.netiq.com/communities/cool-solutions/wp-login.php?redirect_to=https%3A%2F%2Fwww.netiq.com%2Fcommunities%2Fcool-solutions%2Fmanipulating-node-sets-idm-via-set-operations%2F)
		

By: [Alexander McHugh](https://www.netiq.com/communities/cool-solutions/author/alexmchugh/)

October 1, 2015
12:11 pm

Reads:
764
Score:
5

[![[./_resources/Manipulating_node_sets_in_IDM_via_Set_Operations_-_Cool_Solutions__NetIQ.resources/pf-print-icon.gif]]Print ![[./_resources/Manipulating_node_sets_in_IDM_via_Set_Operations_-_Cool_Solutions__NetIQ.resources/pf-pdf-icon.gif]]PDF](https://www.netiq.com/communities/cool-solutions/manipulating-node-sets-idm-via-set-operations/#)
