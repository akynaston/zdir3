# How can I sort the lines in a text file, by the length of each line, in Notepad++?

 11  [favorite](http://superuser.com/questions/609028/how-can-i-sort-the-lines-in-a-text-file-by-the-length-of-each-line-in-notepad#)
**4**

How Can I sort a text file by line length in notepad++? Is there any plugin available for the mentioned task?
In case that there is no plugin, What is the first and maybe second tutorial to read, In order to write the plugin Myself?

[notepad++](http://superuser.com/questions/tagged/notepad%2b%2b)

|     |     |     |
| --- | --- | --- |
| [share](http://superuser.com/q/609028)\|[improve this question](http://superuser.com/posts/609028/edit) | [edited Jun 18 '13 at 17:27](http://superuser.com/posts/609028/revisions)<br>[![[./_resources/How_can_I_sort_the_lines_in_a_text_file,_by_the_length_of_each_line,_in_Notepad++.resources/480f7f998a2d4bdca2b2e86b685f367b.png]]](http://superuser.com/users/6887/breakthrough)<br>[Breakthrough](http://superuser.com/users/6887/breakthrough)<br>**28.6k**879127 | asked Jun 18 '13 at 11:35<br>[![[./_resources/How_can_I_sort_the_lines_in_a_text_file,_by_the_length_of_each_line,_in_Notepad++.resources/M862Q.jpg]]](http://superuser.com/users/219129/hpm)<br>[HPM](http://superuser.com/users/219129/hpm)<br>**225**2516 |

|     |     |
| --- | --- |
| 1   |     |

You know, sometimes it's best to just write some code and get it over with. – [Daniel R Hicks](http://superuser.com/users/84868/daniel-r-hicks) [Sep 16 '13 at 15:14](http://superuser.com/questions/609028/how-can-i-sort-the-lines-in-a-text-file-by-the-length-of-each-line-in-notepad#comment810811_609028)

|     |     |
| --- | --- |
|     |     |

Are you dealing with small or large files? – [ComFreek](http://superuser.com/users/137286/comfreek) [Sep 19 '13 at 19:58](http://superuser.com/questions/609028/how-can-i-sort-the-lines-in-a-text-file-by-the-length-of-each-line-in-notepad#comment813583_609028)

|     |     |
| --- | --- |
|     |     |

50 MB file with long lines, about 250 KB length. – [HPM](http://superuser.com/users/219129/hpm) [Sep 20 '13 at 11:35](http://superuser.com/questions/609028/how-can-i-sort-the-lines-in-a-text-file-by-the-length-of-each-line-in-notepad#comment813976_609028)

|     |     |
| --- | --- |
|     |     |

Is the data sensitive? Or could you share it on Dropbox/Google-Drive/etc.? If Notepad++ can open and handle that file, I would imagine that my solution would work, but I'd love to try it out myself. – [Dane](http://superuser.com/users/43613/dane) [Sep 20 '13 at 15:18](http://superuser.com/questions/609028/how-can-i-sort-the-lines-in-a-text-file-by-the-length-of-each-line-in-notepad#comment814200_609028)

|     |     |
| --- | --- |
|     |     |

Hey @HPM, any chance of getting to work on your data? – [Dane](http://superuser.com/users/43613/dane) [Sep 24 '13 at 20:17](http://superuser.com/questions/609028/how-can-i-sort-the-lines-in-a-text-file-by-the-length-of-each-line-in-notepad#comment817290_609028)

[show **1** more comment](http://superuser.com/questions/609028/how-can-i-sort-the-lines-in-a-text-file-by-the-length-of-each-line-in-notepad#)

## 4 Answers

[active](http://superuser.com/questions/609028/how-can-i-sort-the-lines-in-a-text-file-by-the-length-of-each-line-in-notepad?answertab=active#tab-top) [oldest](http://superuser.com/questions/609028/how-can-i-sort-the-lines-in-a-text-file-by-the-length-of-each-line-in-notepad?answertab=oldest#tab-top) [votes](http://superuser.com/questions/609028/how-can-i-sort-the-lines-in-a-text-file-by-the-length-of-each-line-in-notepad?answertab=votes#tab-top)

 4 

_This answer is inspired by a [YouTube video](http://www.youtube.com/watch?v=qIqM-ZPuK_g). Updated to maintain original sort order, if that is important._

Notepad++ has a built-in TextFX tool that sorts selected lines alphabetically. This tool can be hijacked to sort by the length of the lines by placing spaces on the left of each line, and making sure that all the lines are the same length.

"The Zoo" comes alphabetically before "Their House" because the space is treated as a character and comes before "i". `__X` (pretending the underscores are really spaces) will similarly come alphabetically before `_XX`. The idea in this answer is to add spaces and line numbers so that `__________092dog` will be sorted above `_003alligator`.

I'll use the following as example data:

    Lorem
    ipsum
    dolor
    sit
    amet
    consectetur
    adipisicing
    

**Step 1. Add line numbers.**

_(Note added by barlop- a note for the reader regarding this step, we will not be sorting according to these line numbers, we're sorting according to the length of the lines. But the reason for adding the line numbers, is so we know the natural order, so that when for example, two+ lines are of equal length we can sort those lines according to that natural order)_

Assuming your text file only has the data in it, place the text cursor (the vertical line) into the very first position of the file. Then in the `Edit` menu select `Column Editor...` (Alt+C). Choose "Number to Insert" and start with 1, increase by 1, and include leading zeros. Note that this will retain the original ordering when sorting from shortest string to longest string. [Reverse all lines first](http://superuser.com/questions/185667/reverse-line-order-in-notepad) if you want to sort longest to shortest.

    1Lorem
    2ipsum
    3dolor
    4sit
    5amet
    6consectetur
    7adipisicing
    

**Step 2. Pad all lines with leading spaces.**

Place the text cursor (the vertical line) into the very first position of the file. Then in the `Edit` menu select `Column Editor...` (Alt+C). Insert enough spaces so that the shortest line of data will be padded out to the length of the longest line of data. If your shortest line has 4 characters, and your longest 44, then make sure you insert at least 40 spaces.

    __________1Lorem
    __________2ipsum
    __________3dolor
    __________4sit
    __________5amet
    __________6consectetur
    __________7adipisicing
    

**Step 3. Trim lines to a uniform length.**

Use the following Regular Expression Find/Replace (Ctrl+H) to match the right-hand characters equalling or exceeding the length of your longest data line.

    ^.*(.{50})$
    

Replace all with `$1`. That will trim everything except the right-most 50 characters of every line. If your data is longer (or short) than 50, adjust the `{50}` in the Regular Expression.

_(Note added by barlop- the idea here is the shortest lines have the most spaces at the beginning_)

    _______1Lorem
    _______2ipsum
    _______3dolor
    _________4sit
    ________5amet
    _6consectetur
    _7adipisicing
    

**Step 4. Sort the lines.**

Select all of the text (Ctrl+A). Via the TextFX menu, go to `Text FX > TextFX Tools > Sort lines case sensitive (at column)`. Your data should now be in length order, from shortest to longest. If you want them in order from longest to shortest, uncheck the `Text FX > TextFX Tools > + Sort ascending` option before sorting. Note how line numbers are reversed as well.

    _________4sit
    ________5amet
    _______1Lorem
    _______2ipsum
    _______3dolor
    _6consectetur
    _7adipisicing
    

**Step 5. Remove leading spaces.**

Use another Regular Expression Find/Replace (Ctrl+H) to match the leading spaces.

    ^ *\d{4}
    

That's a space between the caret and asterisk. Replace all with nothing. That will remove all leading spaces and the inserted line numbers, if you had 4-digit line numbers. Replace the `{4}` with the correct number of digits in your line numbers.

    sit
    amet
    Lorem
    ipsum
    dolor
    consectetur
    adipisicing
    

**MACRO**

I recorded the above steps using Notepad++'s macro feature, and it doesn't work. I'm not sure which step fails, but I haven't diagnosed why. You could probably use AutoHotKey to automate this if you do it repeatedly.

|     |     |     |
| --- | --- | --- |
| [share](http://superuser.com/a/646084)\|[improve this answer](http://superuser.com/posts/646084/edit) | [edited Sep 20 '13 at 8:56](http://superuser.com/posts/646084/revisions)<br>[![[./_resources/How_can_I_sort_the_lines_in_a_text_file,_by_the_length_of_each_line,_in_Notepad++.resources/5e249e45a1849e387e324787d08ef738.png]]](http://superuser.com/users/42672/barlop)<br>[barlop](http://superuser.com/users/42672/barlop)<br>**12.1k**1457103 | answered Sep 16 '13 at 14:32<br>[![[./_resources/How_can_I_sort_the_lines_in_a_text_file,_by_the_length_of_each_line,_in_Notepad++.resources/9ae8d4f40957b4bb40f121e26bf97a71.png]]](http://superuser.com/users/43613/dane)<br>[Dane](http://superuser.com/users/43613/dane)<br>**1,380**613 |

|     |     |
| --- | --- |
| 1   |     |

Warning: this is not a stable sort. In other words, lines of the same length will not necessarily appear in the same order after sorting - instead, they will be sorted lexicographically. – [Bob](http://superuser.com/users/117590/bob) [Sep 16 '13 at 14:37](http://superuser.com/questions/609028/how-can-i-sort-the-lines-in-a-text-file-by-the-length-of-each-line-in-notepad#comment810789_646084)

|     |     |
| --- | --- |
|     |     |

@Bob is correct, if you have lines of a given length, such as 33 characters, that have a particular order to them, that will not be reflected in the results. We can add the line numbers with Alt+C prior to step 1 (including leading 0s to ensure that lengths remain equal). Then, when cleaning up in step 4, use `^ *\d{5}` or whatever number of digits were used for the line numbers. – [Dane](http://superuser.com/users/43613/dane) [Sep 16 '13 at 15:12](http://superuser.com/questions/609028/how-can-i-sort-the-lines-in-a-text-file-by-the-length-of-each-line-in-notepad#comment810809_646084)

|     |     |
| --- | --- |
| 1   |     |

The answer has been updated to retain the existing sort order, assuming that is important. – [Dane](http://superuser.com/users/43613/dane) [Sep 16 '13 at 15:25](http://superuser.com/questions/609028/how-can-i-sort-the-lines-in-a-text-file-by-the-length-of-each-line-in-notepad#comment810816_646084)

|     |     |
| --- | --- |
|     |     |

nice one dane for following what that guy in the youtube video was doing, where he also disabled comments. Can you include a link to text where you think it fails, on pastebin [pastebin.com](http://pastebin.com/) ? and did it fail only with the macro, or manually also? – [barlop](http://superuser.com/users/42672/barlop) [Sep 18 '13 at 14:33](http://superuser.com/questions/609028/how-can-i-sort-the-lines-in-a-text-file-by-the-length-of-each-line-in-notepad#comment812364_646084)

|     |     |
| --- | --- |
|     |     |

@barlop I'll see if I can do a little diagnosis on the N++ macro. The result from my simple attempt was terribly corrupted results with many unusual and non-printing characters added. Also, while I was inspired by the YouTube video, my steps are a bit different. – [Dane](http://superuser.com/users/43613/dane) [Sep 18 '13 at 14:44](http://superuser.com/questions/609028/how-can-i-sort-the-lines-in-a-text-file-by-the-length-of-each-line-in-notepad#comment812378_646084)

[show **2** more comments](http://superuser.com/questions/609028/how-can-i-sort-the-lines-in-a-text-file-by-the-length-of-each-line-in-notepad#)

 2 

No I don't think there is. The closest is TextFx plugin but that's an character based sort not line length based. Your best bet is to throw the text into a spreadsheet and sort it there (using a separate computed column using the `LEN()` function).

|     |     |
| --- | --- |
| [share](http://superuser.com/a/609122)\|[improve this answer](http://superuser.com/posts/609122/edit) | answered Jun 18 '13 at 15:49<br>[![[./_resources/How_can_I_sort_the_lines_in_a_text_file,_by_the_length_of_each_line,_in_Notepad++.resources/97f311aab240172132fcf4d7a8d73590.png]]](http://superuser.com/users/37681/snowdude)<br>[snowdude](http://superuser.com/users/37681/snowdude)<br>**2,112**914 |

|     |     |
| --- | --- |
|     |     |

Thanks, the text file has long lines and huge total size, so I put spreadsheet editors away. Let Me Update the Question. – [HPM](http://superuser.com/users/219129/hpm) [Jun 18 '13 at 16:58](http://superuser.com/questions/609028/how-can-i-sort-the-lines-in-a-text-file-by-the-length-of-each-line-in-notepad#comment753328_609122)

|     |     |
| --- | --- |
|     |     |

@HPM well if you're willing to look outside notepad++ then command line would do it. like use some commands to get the length of the line each the end of each line. then you'd at least be nearer to doing it. – [barlop](http://superuser.com/users/42672/barlop) [Sep 16 '13 at 15:34](http://superuser.com/questions/609028/how-can-i-sort-the-lines-in-a-text-file-by-the-length-of-each-line-in-notepad#comment810818_609122)

|     |     |
| --- | --- |
|     |     |

thanks, it's a good advice. What I am curious about is NP++ many plugins, why this one doesn't exist? – [HPM](http://superuser.com/users/219129/hpm) [Sep 17 '13 at 9:52](http://superuser.com/questions/609028/how-can-i-sort-the-lines-in-a-text-file-by-the-length-of-each-line-in-notepad#comment811392_609122)

 1 

You can use [SQL in N++](http://www.scout-soft.com/sql/) in CSV files ! For example if you have :

> col1;
> hgfhfghfhg;
> khjfhgfhfghfgh;
> kjhfhgfhfhgfghfhf;
> lkjgjghjhg;
> lkjgjg;

, you can execute command `select * from data order by length(col1) desc` to sort descending. "data" means current file. "col1" - name of first (and last) column.

Unfortunately there is probably bug that doesn't allow abandon delimiter after lines in one-column text.

|     |     |
| --- | --- |
| [share](http://superuser.com/a/610619)\|[improve this answer](http://superuser.com/posts/610619/edit) | answered Jun 21 '13 at 21:18<br>[![[./_resources/How_can_I_sort_the_lines_in_a_text_file,_by_the_length_of_each_line,_in_Notepad++.resources/5b6609aae28df2def3f59f6a79a67820.png]]](http://superuser.com/users/169762/greck)<br>[Greck](http://superuser.com/users/169762/greck)<br>**211**14 |

|     |     |
| --- | --- |
|     |     |

This is actually a great solution, if only SQL in N++ didn't mangle the data output. I just tested out your solution, and I added delimiters to the end of all lines with a quick regex replace, but the data output converts everything to lowercase, and replaced my dashes with question marks. – [Dane](http://superuser.com/users/43613/dane) [Sep 16 '13 at 13:56](http://superuser.com/questions/609028/how-can-i-sort-the-lines-in-a-text-file-by-the-length-of-each-line-in-notepad#comment810749_610619)

|     |     |
| --- | --- |
|     |     |

@Dane (I don't currently have access to Notepad++.) Perhaps try adding a single quote to the beginning and end of every line (and then the semicolon after that)? Maybe double quotes? – [Bob](http://superuser.com/users/117590/bob) [Sep 16 '13 at 14:39](http://superuser.com/questions/609028/how-can-i-sort-the-lines-in-a-text-file-by-the-length-of-each-line-in-notepad#comment810791_610619)

|     |     |
| --- | --- |
|     |     |

@Bob: no good. The lowercase thing is even mentioned in the release notes for the SQL in N++ plug-in. – [Dane](http://superuser.com/users/43613/dane) [Sep 16 '13 at 15:10](http://superuser.com/questions/609028/how-can-i-sort-the-lines-in-a-text-file-by-the-length-of-each-line-in-notepad#comment810808_610619)

 \-1 

Or if you happen to have linux and nedit:

    ctrl-a
    alt-r
    perl -e 'print sort { length($a) <=> length($b) } <>'
    

|     |     |
| --- | --- |
| [share](http://superuser.com/a/646054)\|[improve this answer](http://superuser.com/posts/646054/edit) | answered Sep 16 '13 at 13:15<br>[![[./_resources/How_can_I_sort_the_lines_in_a_text_file,_by_the_length_of_each_line,_in_Notepad++.resources/da1fdb8b6a76c530ec35ce36f959201a.png]]](http://superuser.com/users/254657/user254657)<br>[user254657](http://superuser.com/users/254657/user254657)<br>**1** |

## Your Answer

### Sign up or [log in](http://superuser.com/users/login?ssrc=question_page&returnurl=http%3a%2f%2fsuperuser.com%2fquestions%2f609028%2fhow-can-i-sort-the-lines-in-a-text-file-by-the-length-of-each-line-in-notepad%23new-answer)

Sign up using Google

Sign up using Facebook

Sign up using Email and Password

### Post as a guest

**Name**
**Email**

By posting your answer, you agree to the [privacy policy](http://stackexchange.com/legal/privacy-policy) and [terms of service](http://stackexchange.com/legal/terms-of-service).

## Not the answer you're looking for? Browse other questions tagged [notepad++](http://superuser.com/questions/tagged/notepad%2b%2b) or [ask your own question](http://superuser.com/questions/ask).
