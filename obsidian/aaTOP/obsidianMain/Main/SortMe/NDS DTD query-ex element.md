# NDS DTD: query-ex element

# query-ex

**<query-ex>** is a [<query>](http://developer.novell.com/documentation/dirxml/dirxmlbk/ref/ndsdtd/query.html) variant used to limit the number of search results returned at one time. See [<query>](http://developer.novell.com/documentation/dirxml/dirxmlbk/ref/ndsdtd/query.html) for general information on searches and queries.

The results of a query-ex command may include a [<query-token>](http://developer.novell.com/documentation/dirxml/dirxmlbk/ref/ndsdtd/query-token.html) element. The query-token element is used in subsequent query-ex commands to retrieve additional results. If query-ex results do not contain a query-token element then all of the available results for that query-ex command have been returned. Note that a different query-token may be returned with each result set. It is not sufficient to use only the query-token returned with the first result set.

The query-ex command has additional attributes that the query command does not:

* The [max-result-count](http://developer.novell.com/documentation/dirxml/dirxmlbk/ref/ndsdtd/query-ex.html#max-result-count) attribute which specifies the maximum number of [<instance>](http://developer.novell.com/documentation/dirxml/dirxmlbk/ref/ndsdtd/instance.html) elements to return as the result of a single query-ex command.
* The [cancel](http://developer.novell.com/documentation/dirxml/dirxmlbk/ref/ndsdtd/query-ex.html#cancel) attribute which is used to cancel a query-ex sequence, thereby freeing any resources associated with the search.

A query-ex command sequence may consist of multiple query-ex commands issued sequentially. The first query-ex command establishes the parameters of the search, returns the initial result set, and, if there are more results than can be returned with the initial result set, also returns a [<query-token>](http://developer.novell.com/documentation/dirxml/dirxmlbk/ref/ndsdtd/query-token.html) to be used with subsequent query-ex commands. Subsequent query-ex commands contain the query-token element and are issued repeatedly to obtain additional result sets from the initial search. This process continues until no query-token element appears in the result set.

Note that subsequent query-ex commands using a token returned from a previous query-ex do not change the parameters of a search, regardless of any attributes or child elements.

A query-ex sequence may be abandoned before all results have been returned by setting the [cancel](http://developer.novell.com/documentation/dirxml/dirxmlbk/ref/ndsdtd/query-ex.html#cancel) attribute equal to "true" on a query-ex command.

Not all application shims support query-ex. Those that do report their support to the DirXML Engine at shim start up time by returning the following as a child of the [<instance>](http://developer.novell.com/documentation/dirxml/dirxmlbk/ref/ndsdtd/instance.html) element that is returned as the response to the driver identification query:

> <attr attr-name="query-ex-supported">
>  <value type="state">true</value>
> </attr> 

> 

## 

> [**association**](http://developer.novell.com/documentation/dirxml/dirxmlbk/ref/ndsdtd/association.html)
> Unique key of the application object.
> [**query-token**](http://developer.novell.com/documentation/dirxml/dirxmlbk/ref/ndsdtd/query-token.html)
> Opaque handle for query-ex commands.
> [**search-class**](http://developer.novell.com/documentation/dirxml/dirxmlbk/ref/ndsdtd/search-class.html)
> Query search class filter.
> [**search-attr**](http://developer.novell.com/documentation/dirxml/dirxmlbk/ref/ndsdtd/search-attr.html)
> Query search attribute value filter.
> [**read-attr**](http://developer.novell.com/documentation/dirxml/dirxmlbk/ref/ndsdtd/read-attr.html)
> Return specified object attribute value(s).
> [**read-parent**](http://developer.novell.com/documentation/dirxml/dirxmlbk/ref/ndsdtd/read-parent.html)
> Return object parent/container.
> [**operation-data**](http://developer.novell.com/documentation/dirxml/dirxmlbk/ref/ndsdtd/operation-data.html)
> Operation additional custom data.
> 
> * * *

## 2\. Attributes

> | Attribute | Value(s) | Default Value |
> | --- | --- | --- |
> |     | true   \|  false<br>If set to "true" on a query-ex command containing a [<query-token>](http://developer.novell.com/documentation/dirxml/dirxmlbk/ref/ndsdtd/query-token.html) element then the search is abandoned and all associated resources are freed by the search target. | #IMPLIED |
> |     | **CDATA**<br>The name of the base class of the object.<br>The class name is mapped between the application and eDirectory name spaces by the schema mapping rule so that DirXML will see the name in the eDirectory namespace and a driver will see the name in the application name space.<br>_This is required for proper schema mapping of any attribute names specified in the search. It should not be used to limit the search._ | #IMPLIED |
> |     | **CDATA**<br>The distinguished name of the target object in the namespace of the receiver. | #IMPLIED |
> |     | **CDATA**<br>The entry id of the target object in the namespace of the receiver.<br>_(Reserved) Should be ignored by the driver._ | #IMPLIED |
> |     | **CDATA**<br>An identifier used to tag the results of an event or command. | #IMPLIED |
> |     | **CDATA**<br>Specifies the maximum number of [<instance>](http://developer.novell.com/documentation/dirxml/dirxmlbk/ref/ndsdtd/instance.html) elements to return as a result of a query-ex command. Valid values are positive, decimal integers. | #IMPLIED |
> |     | entry   \|  subordinates   \|  subtree<br>The scope of the query. Note that "entry" scope makes little sense with query-ex, but is supported | subtree |
> 
> * * *

## 3\. Content Rule

> ( [association](http://developer.novell.com/documentation/dirxml/dirxmlbk/ref/ndsdtd/association.html) ? , [query-token](http://developer.novell.com/documentation/dirxml/dirxmlbk/ref/ndsdtd/query-token.html) ? , ( [search-class](http://developer.novell.com/documentation/dirxml/dirxmlbk/ref/ndsdtd/search-class.html) | [search-attr](http://developer.novell.com/documentation/dirxml/dirxmlbk/ref/ndsdtd/search-attr.html) | [read-attr](http://developer.novell.com/documentation/dirxml/dirxmlbk/ref/ndsdtd/read-attr.html) | [read-parent](http://developer.novell.com/documentation/dirxml/dirxmlbk/ref/ndsdtd/read-parent.html) ) \* , [operation-data](http://developer.novell.com/documentation/dirxml/dirxmlbk/ref/ndsdtd/operation-data.html) ? )
> 
> * * *

## 4\. Parent Elements

> [**input**](http://developer.novell.com/documentation/dirxml/dirxmlbk/ref/ndsdtd/input.html)
>   Input events or commands.

* * *

[**Top Elements**](http://developer.novell.com/documentation/dirxml/dirxmlbk/ref/ndsdtd/TOP-ELEM.html) || [**All Elements**](http://developer.novell.com/documentation/dirxml/dirxmlbk/ref/ndsdtd/ALL-ELEM.html) || [**Tree**](http://developer.novell.com/documentation/dirxml/dirxmlbk/ref/ndsdtd/DTD-TREE.html#query-ex)

* * *

[NDS DTD](http://developer.novell.com/documentation/dirxml/dirxmlbk/ref/ndsdtd/index.html)
