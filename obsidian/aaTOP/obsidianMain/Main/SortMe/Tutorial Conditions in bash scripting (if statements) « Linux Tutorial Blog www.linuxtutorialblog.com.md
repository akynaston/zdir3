# Tutorial: Conditions in bash scripting (if statements) « Linux Tutorial Blog [www.linuxtutorialblog.com]

[RSS Feeds](http://www.linuxtutorialblog.com/feed)
[![[./_resources/Tutorial_Conditions_in_bash_scripting_(if_statements)_«_Linux_Tutorial_Blog_www.linuxtutorialblog.com.resources/unknown_filename.4.png]]](http://www.linuxtutorialblog.com/)

* [Tutorials](http://www.linuxtutorialblog.com/category/tutorials)

* [Solutions](http://www.linuxtutorialblog.com/category/solutions)
* [News](http://www.linuxtutorialblog.com/category/news)
* [Miscellaneous](http://www.linuxtutorialblog.com/category/miscellaneous)
* [Fun Stuff](http://www.linuxtutorialblog.com/category/fun-stuff)

	

Aug
2008
[34](http://www.linuxtutorialblog.com/post/tutorial-conditions-in-bash-scripting-if-statements#comments)

	

# [Tutorial: Conditions in bash scripting (if statements)](http://www.linuxtutorialblog.com/post/tutorial-conditions-in-bash-scripting-if-statements)

![[./_resources/Tutorial_Conditions_in_bash_scripting_(if_statements)_«_Linux_Tutorial_Blog_www.linuxtutorialblog.com.resources/unknown_filename.8.png]] [rechosen](http://www.linuxtutorialblog.com/)    ![[./_resources/Tutorial_Conditions_in_bash_scripting_(if_statements)_«_Linux_Tutorial_Blog_www.linuxtutorialblog.com.resources/unknown_filename.png]] [Tutorials](http://www.linuxtutorialblog.com/category/tutorials)     ![[./_resources/Tutorial_Conditions_in_bash_scripting_(if_statements)_«_Linux_Tutorial_Blog_www.linuxtutorialblog.com.resources/unknown_filename.5.png]] [bash](http://www.linuxtutorialblog.com/tag/bash), [conditions](http://www.linuxtutorialblog.com/tag/conditions), [scripting](http://www.linuxtutorialblog.com/tag/scripting)

If you use bash for scripting you will undoubtedly have to use conditions a lot, for example for an _if ... then_ construct or a _while_ loop. The syntax of these conditions can seem a bit daunting to learn and use. This tutorial aims to help the reader understanding conditions in bash, and provides a comprehensive list of the possibilities. A small amount of general shell knowledge is assumed.

Difficulty: _**Basic - Medium**_

## 

Bash features a lot of built-in checks and comparisons, coming in quite handy in many situations. You've probably seen if statements like the following before:

> if \[ $foo -ge 3 \]; then

The condition in this example is essentially a command. It may sound strange, but surrounding a comparison with square brackets is the same as using the built-in test command, like this:

> if test $foo -ge 3; then

If $foo is **G**reater then or **E**qual to 3, the block after 'then' will be executed. If you always wondered why bash tends to use -ge or -eq instead of >= or ==, it's because this condition type originates from a command, where -ge and -eq are options.
And that's what _if_ does essentially, checking the exit status of a command. I'll explain that in more detail further in the tutorial.
There also are built-in checks that are more specific to shells. What
about this one?

> if \[ -f regularfile \]; then

The above condition is true if the file 'regularfile' exists _and_
is a regular file. A regular file means that it's not a block or
character device, or a directory. This way, you can make sure a usable
file exists before doing something with it. You can even check if a
file is readable!

> if \[ -r readablefile\]; then

The above condition is true if the file 'readablefile' exists _and_ is readable. Easy, isn't it?

## 

The basic syntax of an _if ... then_ statement is like this:

> if _<condition>_; then
> _<commands>_
> fi

The condition is, depending on its type, surrounded by certain
brackets, eg. \[ \]. You can read about the different types further on
in the tutorial. You can add commands to be executed when the condition is false using the _else_ keyword, and use the _elif_ (elseif) keyword to execute commands on another condition if the primary condition is false. The _else_ keyword always comes last. Example:

> if \[ -r somefile \]; then
> content=$(cat somefile)
> elif \[ -f somefile \]; then
> echo "The file 'somefile' exists but is not readable to the script."
> else
> echo "The file 'somefile' does not exist."
> fi

A short explanation of the example: first we check if the file somefile is readable ("if \[ -r somefile \]"). If so, we read it into a variable. If not, we check if it actually exists ("elif \[ -f somefile \]"). If that's true, we report that it exists but isn't readable (if it was, we would have read the content). If the file doesn't exist, we report so, too. The condition at _elif_ is only executed if the condition at _if_ was false. The commands belonging to _else_ are only executed if both conditions are false.

## 

When you start writing and using your own conditions, there are some rules you should know to prevent getting errors that are hard to trace. Here follow three important ones:

1. **Always keep spaces between the brackets and the actual check/comparison**. The following won't work:
	
	> if \[$foo -ge 3\]; then
	
	Bash will complain about a "missing \`\]'".
	

* **Always terminate the line before putting a new keyword like "then"**. The words _if_, _then_, _else_, _elif_ and _fi_ are shell keywords, meaning that they cannot share the same line. Put a ";" between the previous statement and the keyword or place the keyword on the start of a new line. Bash will throw errors like "syntax error near unexpected token \`fi'" if you don't.
* _It is a good habit to quote string variables if you use them in conditions_, because otherwise they are likely to give trouble if they contain
	spaces and/or newlines. By quoting I mean:
	
	> if \[ "$stringvar" == "tux" \]; then
	
	There are a few cases in which you should not
	quote, but they are rare. You will see one of them further on in the tutorial.
	

Also, there are two things that may be useful to know:

1. _You can invert a condition_ by putting an "!" in front of it. Example:
	
	> if \[ ! -f regularfile \]; then
	
	Be sure to place the "!" inside the brackets!
	

* _You can combine conditions_ by using certain operators. For the single-bracket syntax that we've been using so far, you can use "-a" for _and_ and "-o" for _or_. Example:
	
	> if \[ $foo -ge 3 -a $foo -lt 10 \]; then
	
	The above condition will return true if $foo contains an integer greater than or equal to 3 and **L**ess **T**han 10. You can read more about these combining expressions at the respective condition syntaxes.
	

And, one more basic thing: don't forget that conditions can also be used in other statements, like _while_ and _until_. It is outside the scope of this tutorial to explain those, but you can read about them at the [Bash Guide for Beginners](http://www.tldp.org/LDP/Bash-Beginners-Guide/html/sect_09_02.html).

Anyway, I've only shown you conditions between single brackets so far. There are more syntaxes, however, as you will read in the next section.

## 

Bash features different syntaxes for conditions. I will list the three of them:

### 

This is the condition syntax you have already seen in the previous paragraphs; it's the oldest supported syntax. It supports three types of conditions:

* Allows different kinds of checks on a file. Example:
	
	> if \[ -L symboliclink \]; then
	
	The above condition is true if the file 'symboliclink' exists and is a symbolic link. For more file-based conditions see [the table](http://www.linuxtutorialblog.com/post/#file-based-conditions) below.
	

* Allows checks on a string and comparing of strings. Example one:
	
	> if \[ -z "$emptystring" \]; then
	
	The above condition is true if $emptystring is an empty string or an uninitialized variable. Example two:
	
	> if \[ "$stringvar1" == "cheese" \]; then
	
	The above condition is true if $stringvar1 contains just the string "cheese". For more string-based conditions see [the table](http://www.linuxtutorialblog.com/post/#string-based-conditions) below.
	

* Allows comparing integer numbers. Example:
	
	> if \[ $num -lt 1 \]; then
	
	The above condition returns true if $num is less than 1. For more arithmetic conditions see [the table](http://www.linuxtutorialblog.com/post/#arithmetic-conditions) below.
	

### 

You may have encountered conditions enclosed in double square brackets already, which look like this:

> if \[\[ "$stringvar" == \*string\* \]\]; then

The double-bracket syntax serves as an enhanced version of the single-bracket syntax; it mainly has the same features, but also some important differences with it. I will list them here:

* _The first difference_ can be seen in the above example; when comparing strings, the double-bracket syntax features shell globbing. This means that an asterisk ("\*") will expand to literally anything, just as you probably know from normal command-line usage. Therefore, if $stringvar contains the phrase "string" anywhere, the condition will return true. Other forms of shell globbing are allowed, too. If you'd like to match both "String" and "string", you could use the following syntax:
	
	> if \[\[ "$stringvar" == \*\[sS\]tring\* \]\]; then
	
	Note that only general shell globbing is allowed. Bash-specific things like {1..4} or {foo,bar} will not work. Also note that the **globbing will not work if you quote the right string**. In this case you should leave it unquoted.
	
* _The second difference_ is that word splitting is prevented. Therefore, you could omit placing quotes around string variables and use a condition like the following without problems:
	
	> if \[\[ $stringvarwithspaces != foo \]\]; then
	
	Nevertheless, the quoting string variables remains a good habit, so I recommend just to keep doing it.
	
* _The third difference_ consists of not expanding filenames. I will illustrate this difference using two examples, starting with the old single-bracket situation:
	
	> if \[ -a \*.sh \]; then
	
	The above condition will return true if there is one single file in the working directory that has a .sh extension. If there are none, it will return false. If there are several .sh files, bash will throw an error and stop executing the script. This is because \*.sh is expanded to the files in the working directory. Using double brackets prevents this:
	
	> if \[\[ -a \*.sh \]\]; then
	
	The above condition will return true only if there is a file in the working directory called "\*.sh", no matter what other .sh files exist. The asterisk is taken literally, because the double-bracket syntax does not expand filenames.
	
* _The fourth difference_ is the addition of more generally known combining expressions, or, more specific, the operators "&&" and "||". Example:
	
	> if \[\[ $num -eq 3 && "$stringvar" == foo \]\]; then
	
	The above condition returns true if $num is equal to 3 and $stringvar is equal to "foo". The -a and -o known from the single-bracket syntax is supported, too.
	
	Note that the _and_ operator has precedence over the _or_ operator, meaning that "&&" or "-a" will be evaluated before "||" or "-o".
	
* _The fifth difference_ is that the double-bracket syntax allows regex pattern matching using the "=~" operator. See [the table](http://www.linuxtutorialblog.com/post/#string-based-conditions) for more information.

### 

There also is another syntax for arithmetic (number-based) conditions, most likely adopted from the Korn shell:

> if (( $num <= 5 )); then

The above condition is true if $num is less than or equal to 5. This syntax may seem more familiar to programmers. It features all the 'normal' operators, like "==", "<" and ">=". It supports the "&&" and "||" combining expressions (but not the -a and -o ones!). It is equivalent to the built-in let command.

## 

The following table list the condition possibilities for both the single- and the double-bracket syntax. Save a single exception, the examples are given in single-bracket syntax, but are always compatible with double brackets.

|     |     |     |
| --- | --- | --- |
| ###  1. File-based conditions: |     |     |
| Condition | True if | Example/explanation |
| \[ -a existingfile \] | file 'existingfile' exists. | if \[ -a tmp.tmp \]; then<br>    rm -f tmp.tmp # _Make sure we're not bothered by an old temporary file<br>_fi |
| \[ -b blockspecialfile \] | file 'blockspecialfile' exists and is block special. | Block special files are special kernel files found in /dev, mainly used for ATA devices like hard disks, cd-roms and floppy disks.<br><br>if \[ -b /dev/fd0 \]; then<br>    dd if=floppy.img of=/dev/fd0 # _Write an image to a floppy_<br>fi |
| \[ -c characterspecialfile \] | file 'characterspecialfile' exists and is character special. | Character special files are special kernel files found in /dev, used for all kinds of purposes (audio hardware, tty's, but also /dev/null).<br><br>if \[ -c /dev/dsp \]; then<br>    cat raw.wav > /dev/dsp # _This actually works for certain raw wav files_<br>fi |
| \[ -d directory \] | file 'directory' exists and is a directory. | In UNIX-style, directories are a special kind of file.<br><br>if \[ -d ~/.kde \]; then<br>    echo "You seem to be a kde user."<br>fi |
| \[ -e existingfile \] | file 'existingfile' exists. | (same as -a, see that entry for an example) |
| \[ -f regularfile \] | file 'regularfile' exists and is a regular file. | A regular file is neither a block or character special file nor a directory.<br><br>if \[ -f ~/.bashrc \]; then<br>    source ~/.bashrc<br>fi |
| \[ -g sgidfile \] | file 'sgidfile' exists and is set-group-ID. | When the SGID-bit is set on a directory, all files created in that directory will inherit the group of the directory.<br><br>if \[ -g . \]; then<br>   echo "Created files are inheriting the group '$(ls -ld . \| awk '{ print $4 }')' from the working directory."<br>fi |
| \[ -G fileownedbyeffectivegroup \] | file 'fileownedbyeffectivegroup' exists and is owned by the effective group ID. | The effective group id is the primary group id of the executing user.<br><br>if \[ ! -G file \]; then # _An exclamation mark inverts the outcome of the condition following it_<br>   chgrp $(id -g) file # _Change the group if it's not the effective one_<br>fi |
| \[ -h symboliclink \] | file 'symboliclink' exists and is a symbolic link. | if \[ -h $pathtofile \]; then<br>    pathtofile=$(readlink -e $pathtofile) # _Make sure $pathtofile contains the actual file and not a symlink to it_<br>fi |
| \[ -k stickyfile \] | file 'stickyfile' exists and has its sticky bit set. | The sticky bit has got [quite a history](http://en.wikipedia.org/wiki/Sticky_bit), but is now used to prevent world-writable directories from having their contents deletable by anyone.<br><br>if \[ ! -k /tmp \]; then # _An exclamation mark inverts the outcome of the condition following it_<br>    echo "Warning! Anyone can delete and/or rename your files in /tmp!"<br>fi |
| \[ -L symboliclink \] | file 'symboliclink' exists and is a symbolic link. | (same as -h, see that entry for an example) |
| \[ -N modifiedsincelastread \] | file 'modifiedsincelastread' exists and was modified after the last read. | if \[ -N /etc/crontab \]; then<br>    killall -HUP crond # _SIGHUP makes crond reread all crontabs_fi |
| \[ -O fileownedbyeffectiveuser \] | file 'fileownedbyeffectiveuser' exists and is owned by the user executing the script. | if \[ -O file \]; then<br>    chmod 600 file # _Makes the file private, which is a bad idea if you don't own it_<br>fi |
| \[ -p namedpipe \] | file 'namedpipe' exists and is a named pipe. | A named pipe is a file in /dev/fd/ that can be read just once. See [my bash tutorial](http://www.linuxtutorialblog.com/post/tutorial-the-best-tips-tricks-for-bash#using-several-ways-of-substitution) for a case in which it's used.<br><br>if \[ -p $file \]; then<br>    cp $file tmp.tmp # _Make sure we'll be able to read_<br>    file="tmp.tmp"    # _the file as many times as we like_<br>fi |
| \[ -r readablefile \] | file 'readablefile' exists and is readable to the script. | if \[-r file \]; then<br>    content=$(cat file) # _Set $content to the content of the file_fi |
| \[ -s nonemptyfile \] | file 'nonemptyfile' exists and has a size of more than 0 bytes. | if \[ -s logfile \]; then<br>    gzip logfile    # _Backup the old logfile_<br>    touch logfile # _before creating a fresh one._<br>fi |
| \[ -S socket \] | file 'socket' exists and is a socket. | A socket file is used for inter-process communication, and features an interface similar to a network connection.<br><br>if \[ -S /var/lib/mysql/mysql.sock \]; then<br>    mysql --socket=/var/lib/mysql/mysql.sock # _See [this MySQL tip](http://www.tech-recipes.com/mysql_tips762.html)_fi |
| \[ -t openterminal \] | file descriptor 'openterminal' exists and refers to an open terminal. | Virtually everything is done using files on Linux/UNIX, and the terminal is no exception.<br><br>if \[ -t /dev/pts/3 \]; then<br>    echo -e "\\nHello there. Message from terminal $(tty) to you." > /dev/pts/3 # _Anyone using that terminal will actually see this message!_<br>fi |
| \[ -u suidfile \] | file 'suidfile' exists and is set-user-ID. | Setting the suid-bit on a file causes execution of that file to be done with the credentials of the owner of the file, not of the executing user.<br><br>if \[ -u executable \]; then<br>    echo "Running program executable as user $(ls -l executable \| awk '{ print $3 }')."<br>fi |
| \[ -w writeablefile \] | file 'writeablefile' exists and is writeable to the script. | if \[ -w /dev/hda \]; then<br>    grub-install /dev/hda<br>fi |
| \[ -x executablefile \] | file 'executablefile' exists and is executable for the script. | Note that the execute permission on a directory means that it's searchable (you can see which files it contains).<br><br>if \[ -x /root \]; then<br>    echo "You can view the contents of the /root directory."<br>fi |
| \[ newerfile -nt olderfile \] | file 'newerfile' was changed more recently than 'olderfile', or if 'newerfile' exists and 'olderfile' doesn't. | if \[ story.txt1 -nt story.txt \]; then<br>    echo "story.txt1 is newer than story.txt; I suggest continuing with the former."<br>fi |
| \[ olderfile -ot newerfile \] | file 'olderfile' was changed longer ago than 'newerfile', or if 'newerfile' exists and 'olderfile' doesn't. | if \[ /mnt/remote/remotefile -ot localfile \]; then<br>    cp -f localfile /mnt/remote/remotefile # _Make sure the remote location has the newest version of the file, too_<br>fi |
| \[ same -ef file \] | file 'same' and file 'file' refer to the same device/inode number. | if \[ /dev/cdrom -ef /dev/dvd \]; then<br>    echo "Your primary cd drive appears to read dvd's, too."<br>fi |
| ###  2. String-based conditions: |     |     |
| Condition | True if | Example/explanation |
| \[ STRING1 == STRING2 \] | STRING1 is equal to STRING2. | if \[ "$1" == "moo" \]; then<br>    echo $cow # _Ever tried executing 'apt-get moo'?_fi<br><br>Note: you can also use a single "=" instead of a double one. |
| \[ STRING1 != STRING2 \] | STRING1 is not equal to STRING2. | if \[ "$userinput" != "$password" \]; then<br>    echo "Access denied! Wrong password!"<br>    exit 1 # _Stops script execution right here_<br>fi |
| \[ STRING1 \\> STRING2 \] | STRING1 sorts after STRING2 in the current locale (lexographically). | The backslash before the angle bracket is there because the bracket needs to be escaped to be interpreted correctly. As an example we have a basic [bubble sort](http://en.wikipedia.org/wiki/Sorting_algorithm#Bubble_sort):<br><br>_(Don't feel ashamed if you don't understand this, it is a more complex example)_<br> <br>array=( linux tutorial blog )<br>swaps=1<br>while (( swaps > 0 )); do<br>   <br>swaps=0<br>    for (( i=0; i < (( ${#array\[@\]} - 1 )) ; i++ )); do<br>        if \[ "${array\[$i\]}" \\> "${array\[$(( i + 1 ))\]}" \]; then # _Here is the sorting condition_<br>            tempstring=${array\[$i\]}<br>            array\[$i\]=${array\[$(( i + 1 ))\]}<br>            array\[$(( i + 1 ))\]=$tempstring<br>            (( swaps=swaps + 1 ))<br>        fi<br>    done<br>done<br>echo ${array\[@\]} # _Returns "blog linux tutorial"_ |
| \[ STRING1 \\< STRING2 \] | STRING1 sorts before STRING2 in the current locale (lexographically). |
| \[ -n NONEMPTYSTRING \] | NONEMPTYSTRING has a length of more than zero. | This condition only accepts valid strings, so be sure to quote anything you give to it.<br><br>if \[ -n "$userinput" \]; then<br>    userinput=parse($userinput) # _Only parse if the user actually gave some input._<br>fi<br><br>Note that you can also omit the "-n", as brackets with just a string in it behave the same. |
| \[ -z EMPTYSTRING \] | EMPTYSTRING is an empty string. | This condition also accepts non-string input, like an uninitialized variable:<br><br>if \[ -z $uninitializedvar \]; then<br>    uninitializedvar="initialized" # _-z returns true on an uninitialized variable, so we initialize it here._<br>fi |
| _Double-bracket syntax only:<br>_\[\[ STRING1 =~ REGEXPATTERN \]\] | STRING1 matches REGEXPATTERN. | If you are familiar with Regular Expressions, you can use this conditions to perform a regex match.<br><br>if \[\[ "$email" =~ "\\b\[A-Za-z0-9.\_%+-\]+@\[A-Za-z0-9.-\]+\\.\[A-Za-z\]{2,4}\\b" \]\]; then<br>    echo "\\$email contains a valid e-mail address."<br>fi |
| ###  3. Arithmetic (number-based) conditions: |     |     |
| Condition | True if | Example/explanation |
| \[ NUM1 -eq NUM2 \] | NUM1 is **EQ**ual to NUM2. | These conditions only accept integer numbers. Strings will be converted to integer numbers, if possible. Some random examples:<br><br>if \[ $? -eq 0 \]; then # _$? returns the exit status of the previous command_<br>    echo "Previous command ran succesfully."<br>fi<br><br>if \[ $(ps -p $pid -o ni=) -ne $(nice) \]; then<br>    echo "Process $pid is running with a non-default nice value"<br>fi<br><br>if \[ $num -lt 0 \]; then<br>    echo "Negative numbers not allowed; exiting..."<br>    exit 1<br>fi |
| \[ NUM1 -ne NUM2 \] | NUM1 is **N**ot **E**qual to NUM2. |
| \[ NUM1 -gt NUM2 \] | NUM1 is **G**reater **T**han NUM2. |
| \[ NUM1 -ge NUM2 \] | NUM1 is **G**reater than or **E**qual to NUM2. |
| \[ NUM1 -lt NUM2 \] | NUM1 is **L**ess **T**han NUM2. |
| \[ NUM1 -le NUM2 \] | NUM1 is **L**ess than or **E**qual to NUM2. |
| ### 4\. Miscellaneous conditions: |     |     |
| Condition | True if | Example/explanation |
| \[ -o shelloption \] | shell option 'shelloption' is enabled. | Shell options modify the behaviour of bash, except a few unmodifiable ones that indicate the shell status.<br><br>if \[ ! -o checkwinsize \] # _An exclamation mark inverts the outcome of the condition following it_<br>    echo "Shell option checkwinsize is disabled; enabling it so you can resize you terminal window without problems."<br>    shopt -s checkwinsize # _This shell option is modifiable_<br>fi<br><br>if \[ -o login\_shell \]; then<br>    echo "This a a login shell." # _This shell option is not modifiable_<br>fi |

With the double-parenthesis syntax, you can use the following conditions:

|     |     |     |
| --- | --- | --- |
| ### 5\. Double-parenthesis syntax conditions: |     |     |
| Condition | True if | Example/explanation |
| (( NUM1 == NUM2 )) | NUM1 is equal to NUM2. | These conditions only accept integer numbers. Strings will be converted to integer numbers, if possible. Some random examples:<br><br>if (( $? == 0 )); then # _$? returns the exit status of the previous command_<br>    echo "Previous command ran succesfully."<br>fi<br><br>if (( $(ps -p $pid -o ni=) != $(nice) )); then<br>    echo "Process $pid is running with a non-default nice value"<br>fi<br><br>if (( $num < 0 )); then<br>    echo "Negative numbers not allowed; exiting..."<br>    exit 1<br>fi |
| (( NUM1 != NUM2 )) | NUM1 is not equal to NUM2. |
| (( NUM1 > NUM2 )) | NUM1 is greater than NUM2. |
| (( NUM1 >= NUM2 )) | NUM1 is greater than or equal to NUM2. |
| (( NUM1 < NUM2 )) | NUM1 is less than NUM2. |
| (( NUM1 <= NUM2 )) | NUM1 is less than or equal to NUM2. |

After this dry information load, here's a bit of explanation for those who want to know more...

## 

I said I'd tell more about the fact that _if_ essentially checks the exit status of commands. And so I will. The basic rule of bash when it comes to conditions is _0 equals true, >0 equals false_.
That's pretty much the opposite of many programming languages where 0 equals false and 1 (or more) equals true. The reason behind this is that shells like bash deal with programs a lot. By UNIX convention, programs use an exit status for indicating whether execution went alright or an error occured. As a succesful execution doesn't require any explanation, it needs only one exit status. If there was a problem, however, it is useful to know what went wrong. Therefore, 0 is used for a succesful execution, and 1-255 to indicate what kind of error occured. The meaning of the numbers 1-255 differs depending on the program returning them.

Anyway, _if_ executes the block after _then_ when the command returns 0. Yes, conditions are commands. The phrase \[ $foo -ge 3 \] returns an exit status, and the other two syntaxes as well! Therefore, there's a neat trick you can use to quickly test a condition:

> \[ $foo -ge 3 \] && echo true

In this example, "echo true" is only executed if "\[ $foo -ge 3 \]" returns 0 (true). Why is that, you might ask. It's because bash only evaluates a condition when needed. When using the _and_ combining expression, both conditions need to be true to make the combining expression return true. If the first condition returns false, it doesn't matter what the second one returns; the result will be false. Therefore, bash doesn't evaluate the second condition, and that's the reason why "echo true" is not executed in the example. This is the same for the _or_ operator ("||"), where the second condition is not evaluated if the first one is true.

Well, so much for the diving. If you want to know even more, I'd like to point you to the [Advanced Bash-Scripting Guide](http://www.tldp.org/LDP/abs/html/tests.html) and maybe the [Bash Reference Manual](http://www.gnu.org/software/bash/manual/bashref.html#Conditional-Constructs).

## 

In this tutorial, you've been able to make a start at understanding the many possibilities of conditions in bash scripting. You've been able to read about the basic rules of writing and using conditions, about the three syntaxes and their properties, and maybe you took the opportunity to dive a little deeper. I hope you enjoyed the reading as much as I enjoyed the writing. You can always return here to look up conditions in [the table](http://www.linuxtutorialblog.com/post/#table-of-conditions) (bookmark that link to see the table directly), or to refresh your knowledge. If you have any suggestions, additions or other feedback, feel free to comment. Thanks for reading and happy scripting!

If you enjoyed this article please consider **sharing it!** [![[./_resources/Tutorial_Conditions_in_bash_scripting_(if_statements)_«_Linux_Tutorial_Blog_www.linuxtutorialblog.com.resources/unknown_filename.2.png]]](http://twitter.com/home/?status=Tutorial: Conditions in bash scripting (if statements) : http://www.linuxtutorialblog.com/post/tutorial-conditions-in-bash-scripting-if-statements)[![[./_resources/Tutorial_Conditions_in_bash_scripting_(if_statements)_«_Linux_Tutorial_Blog_www.linuxtutorialblog.com.resources/unknown_filename.7.png]]](http://www.stumbleupon.com/submit?url=http://www.linuxtutorialblog.com/post/tutorial-conditions-in-bash-scripting-if-statements&amp;title=Tutorial: Conditions in bash scripting (if statements))[![[./_resources/Tutorial_Conditions_in_bash_scripting_(if_statements)_«_Linux_Tutorial_Blog_www.linuxtutorialblog.com.resources/unknown_filename.14.png]]](http://www.reddit.com/submit?url=http://www.linuxtutorialblog.com/post/tutorial-conditions-in-bash-scripting-if-statements&amp;title=Tutorial: Conditions in bash scripting (if statements))[![[./_resources/Tutorial_Conditions_in_bash_scripting_(if_statements)_«_Linux_Tutorial_Blog_www.linuxtutorialblog.com.resources/unknown_filename.1.png]]](http://digg.com/submit?phase=2&amp;url=http://www.linuxtutorialblog.com/post/tutorial-conditions-in-bash-scripting-if-statements&amp;title=Tutorial: Conditions in bash scripting (if statements))[![[./_resources/Tutorial_Conditions_in_bash_scripting_(if_statements)_«_Linux_Tutorial_Blog_www.linuxtutorialblog.com.resources/unknown_filename.12.png]]](http://del.icio.us/post?url=http://www.linuxtutorialblog.com/post/tutorial-conditions-in-bash-scripting-if-statements&amp;title=Tutorial: Conditions in bash scripting (if statements))[![[./_resources/Tutorial_Conditions_in_bash_scripting_(if_statements)_«_Linux_Tutorial_Blog_www.linuxtutorialblog.com.resources/unknown_filename.9.png]]](http://www.facebook.com/sharer.php?u=http://www.linuxtutorialblog.com/post/tutorial-conditions-in-bash-scripting-if-statements&amp;t=Tutorial: Conditions in bash scripting (if statements))

## 34 Comments to “Tutorial: Conditions in bash scripting (if statements)”

	![986d77a1f198088c8649e7e78331b289?s=40&d=http%3A%2F%2Fwww.gravatar.com%2Favatar%2F61a58ec1c1fba116f8424035089b7c71%3Fs%3D40&r=G](http://1.gravatar.com/avatar/986d77a1f198088c8649e7e78331b289?s=40&d=http%3A%2F%2Fwww.gravatar.com%2Favatar%2F61a58ec1c1fba116f8424035089b7c71%3Fs%3D40&r=G)
		
	
	**[morvin](http://morvinis.blogspot.com)** February 22, 2009 at 17:31
	
	Topic:
	
	thanx info..
	
	[Reply](http://www.linuxtutorialblog.com/post/tutorial-conditions-in-bash-scripting-if-statements?replytocom=231#respond)
	
	![[./_resources/Tutorial_Conditions_in_bash_scripting_(if_statements)_«_Linux_Tutorial_Blog_www.linuxtutorialblog.com.resources/unknown_filename.13.jpeg]]
		
	
	**[Mastro](http://natonelbronx.wordpress.com)** March 4, 2009 at 10:27
	
	Topic: Nice one
	
	I think this is a great tutorial!
	
	:)
	my thanks to the author!
	
	[Reply](http://www.linuxtutorialblog.com/post/tutorial-conditions-in-bash-scripting-if-statements?replytocom=241#respond)
	
	![61a58ec1c1fba116f8424035089b7c71&s=40](http://0.gravatar.com/avatar/?d=http://www.gravatar.com/avatar/61a58ec1c1fba116f8424035089b7c71&s=40)
		
	
	**josh** March 25, 2009 at 05:02
	
	Topic:
	
	wow, this tutorial's a lifesaver. It shows a lot of those subtle bash scripting syntaxes as well
	
	[Reply](http://www.linuxtutorialblog.com/post/tutorial-conditions-in-bash-scripting-if-statements?replytocom=238#respond)
	
	![61a58ec1c1fba116f8424035089b7c71&s=40](http://0.gravatar.com/avatar/?d=http://www.gravatar.com/avatar/61a58ec1c1fba116f8424035089b7c71&s=40)
		
	
	**ben** April 10, 2009 at 11:57
	
	Topic: Great
	
	This is by far the most in depth tutorial I've found so far, if you could cover cmp as a condition in the if statement, it would be superb
	
	[Reply](http://www.linuxtutorialblog.com/post/tutorial-conditions-in-bash-scripting-if-statements?replytocom=239#respond)
	
	![97ec371f59ad4537533a51abe8540863?s=40&d=http%3A%2F%2Fwww.gravatar.com%2Favatar%2F61a58ec1c1fba116f8424035089b7c71%3Fs%3D40&r=G](http://1.gravatar.com/avatar/97ec371f59ad4537533a51abe8540863?s=40&d=http%3A%2F%2Fwww.gravatar.com%2Favatar%2F61a58ec1c1fba116f8424035089b7c71%3Fs%3D40&r=G)
		
	
	**vijay** April 24, 2009 at 14:33
	
	Topic:
	
	linux if while
	
	[Reply](http://www.linuxtutorialblog.com/post/tutorial-conditions-in-bash-scripting-if-statements?replytocom=240#respond)
	
	![ff5a5f64e62a4b16cd9b6e15b3766adb?s=40&d=http%3A%2F%2Fwww.gravatar.com%2Favatar%2F61a58ec1c1fba116f8424035089b7c71%3Fs%3D40&r=G](http://1.gravatar.com/avatar/ff5a5f64e62a4b16cd9b6e15b3766adb?s=40&d=http%3A%2F%2Fwww.gravatar.com%2Favatar%2F61a58ec1c1fba116f8424035089b7c71%3Fs%3D40&r=G)
		
	
	**ateelia** June 10, 2009 at 05:30
	
	Topic: superb
	
	This is great for me, a beginner in bash. A great compliments to the author, wishing you all the best
	
	[Reply](http://www.linuxtutorialblog.com/post/tutorial-conditions-in-bash-scripting-if-statements?replytocom=237#respond)
	
	![61a58ec1c1fba116f8424035089b7c71&s=40](http://0.gravatar.com/avatar/?d=http://www.gravatar.com/avatar/61a58ec1c1fba116f8424035089b7c71&s=40)
		
	
	**liz** July 2, 2009 at 05:59
	
	Topic: very comprehensive
	
	This helped me a lot, as most tutorials don't go into the syntax.
	
	How do I compare to a string plus wildcard? I tried:
	
	if \[ "$bval" == "b1000"\* \]
	
	which is wrong (I want the next command to execute whether $bval is b1000 or b1000\_othertext)
	
	[Reply](http://www.linuxtutorialblog.com/post/tutorial-conditions-in-bash-scripting-if-statements?replytocom=236#respond)
	
	![61a58ec1c1fba116f8424035089b7c71&s=40](http://0.gravatar.com/avatar/?d=http://www.gravatar.com/avatar/61a58ec1c1fba116f8424035089b7c71&s=40)
		
	
	**liz** July 2, 2009 at 06:04
	
	Topic: \*headdesk\*
	
	Sorry for my idiocy; I reread the tutorial and got my answer - double brackets!
	
	This tutorial really is complete and comprehensive. Kudos to the author.
	
	[Reply](http://www.linuxtutorialblog.com/post/tutorial-conditions-in-bash-scripting-if-statements?replytocom=234#respond)
	
	![34d78b29d6ef785dec072d8acef96ef0?s=40&d=http%3A%2F%2Fwww.gravatar.com%2Favatar%2F61a58ec1c1fba116f8424035089b7c71%3Fs%3D40&r=G](http://1.gravatar.com/avatar/34d78b29d6ef785dec072d8acef96ef0?s=40&d=http%3A%2F%2Fwww.gravatar.com%2Favatar%2F61a58ec1c1fba116f8424035089b7c71%3Fs%3D40&r=G)
		
	
	**Kenneth E. David II** July 7, 2009 at 00:15
	
	Topic: Question 5 (school)
	
	HELP.. I am very new to linux and I need help.
	
	You work for a company that collects billing data and manages the billing for several customers. Last week, a customer sent you a number of files that were not intended for you. The customer just discovered the problem and is not sure about the files that were sent to you. The customer knows that all files end with .cvs and the files that customers send end with .dat.
	
	Write a script that will use a loop to generate a list of files to be deleted so that the customer can see what you received, and delete the files one at a time in the loop.
	
	[Reply](http://www.linuxtutorialblog.com/post/tutorial-conditions-in-bash-scripting-if-statements?replytocom=235#respond)
	
	![61a58ec1c1fba116f8424035089b7c71&s=40](http://0.gravatar.com/avatar/?d=http://www.gravatar.com/avatar/61a58ec1c1fba116f8424035089b7c71&s=40)
		
	
	**Noble Bhaskar** July 24, 2009 at 08:18
	
	Topic: Conditions in bash scripting (if statements)
	
	This tutorial is good.
	
	[Reply](http://www.linuxtutorialblog.com/post/tutorial-conditions-in-bash-scripting-if-statements?replytocom=233#respond)
	
	![61a58ec1c1fba116f8424035089b7c71&s=40](http://0.gravatar.com/avatar/?d=http://www.gravatar.com/avatar/61a58ec1c1fba116f8424035089b7c71&s=40)
		
	
	**[Jadu Saikia](http://unstableme.blogspot.com/)** August 29, 2009 at 20:29
	
	Topic: Thanks
	
	Nice page for all these commands, really well written. I maintain this unix bash scripting blog <http://unstableme.blogspot.com/> , people might find it useful. Thanks.
	
	[Reply](http://www.linuxtutorialblog.com/post/tutorial-conditions-in-bash-scripting-if-statements?replytocom=232#respond)
	
	![61a58ec1c1fba116f8424035089b7c71&s=40](http://0.gravatar.com/avatar/?d=http://www.gravatar.com/avatar/61a58ec1c1fba116f8424035089b7c71&s=40)
		
	
	**| | |** October 16, 2009 at 18:20
	
	Topic: Double-bracket syntax
	
	Um, so does "if \[\[ ... \]\];" glob or not? Under the "first difference", you say that it expands \* to anything. Then under "third difference" you say it only matches a filename called \*. So which one is it?
	
	[Reply](http://www.linuxtutorialblog.com/post/tutorial-conditions-in-bash-scripting-if-statements?replytocom=242#respond)
	
	![61a58ec1c1fba116f8424035089b7c71&s=40](http://0.gravatar.com/avatar/?d=http://www.gravatar.com/avatar/61a58ec1c1fba116f8424035089b7c71&s=40)
		
	
	**[Beginner](http://www.pricetrooper.com)** October 31, 2009 at 16:44
	
	Topic: Good tutorial!
	
	This tutorial is very well thought out and written, which makes it easy to understand.Great for beginners like me.Best I found online so far on the topic. Once again good work...and thanks!
	
	[Reply](http://www.linuxtutorialblog.com/post/tutorial-conditions-in-bash-scripting-if-statements?replytocom=243#respond)
	
	![fd960d3d23d910797dfce9d899190150?s=40&d=http%3A%2F%2Fwww.gravatar.com%2Favatar%2F61a58ec1c1fba116f8424035089b7c71%3Fs%3D40&r=G](http://1.gravatar.com/avatar/fd960d3d23d910797dfce9d899190150?s=40&d=http%3A%2F%2Fwww.gravatar.com%2Favatar%2F61a58ec1c1fba116f8424035089b7c71%3Fs%3D40&r=G)
		
	
	**ukrishna** November 3, 2009 at 11:44
	
	Topic: Beginner
	
	Really Really amasing tutorial....Contains even the minutest detail about if statement.....
	
	Thanks a million to the author..:-)
	
	Expect many more...
	
	[Reply](http://www.linuxtutorialblog.com/post/tutorial-conditions-in-bash-scripting-if-statements?replytocom=244#respond)
	
	![65d93f5611f6a41f2ee52c055a758941?s=40&d=http%3A%2F%2Fwww.gravatar.com%2Favatar%2F61a58ec1c1fba116f8424035089b7c71%3Fs%3D40&r=G](http://0.gravatar.com/avatar/65d93f5611f6a41f2ee52c055a758941?s=40&d=http%3A%2F%2Fwww.gravatar.com%2Favatar%2F61a58ec1c1fba116f8424035089b7c71%3Fs%3D40&r=G)
		
	
	**pradeep d rajmane** January 12, 2010 at 19:24
	
	Topic: basic
	
	all writen in well and precise manner good for even layman and can start scripting from scratch.
	
	[Reply](http://www.linuxtutorialblog.com/post/tutorial-conditions-in-bash-scripting-if-statements?replytocom=245#respond)
	
	![61a58ec1c1fba116f8424035089b7c71&s=40](http://0.gravatar.com/avatar/?d=http://www.gravatar.com/avatar/61a58ec1c1fba116f8424035089b7c71&s=40)
		
	
	**ahmed** February 9, 2010 at 12:57
	
	Topic: pls solve this
	
	file\_date="hello"
	cur\_date="hello"
	echo "hi"
	
	if \["$file\_date" == "$cur\_date"\];
	then
	echo "good, its working"
	else
	echo "hmm, need to learn still"
	fi
	
	[Reply](http://www.linuxtutorialblog.com/post/tutorial-conditions-in-bash-scripting-if-statements?replytocom=246#respond)
	
		![6fc300ec960f8edaa418921a3efc7d0a?s=40&d=http%3A%2F%2Fwww.gravatar.com%2Favatar%2F61a58ec1c1fba116f8424035089b7c71%3Fs%3D40&r=G](http://0.gravatar.com/avatar/6fc300ec960f8edaa418921a3efc7d0a?s=40&d=http%3A%2F%2Fwww.gravatar.com%2Favatar%2F61a58ec1c1fba116f8424035089b7c71%3Fs%3D40&r=G)
				
		
		**someguy** March 17, 2010 at 17:24
		
		ahmed: you didn't even post a) an error message or b) what you want to accomplish.
		
		nevertheless.. try to use this here: if \[ "$file\_date" == "$cur\_date" \];
		
		spaces are important.
		
		[Reply](http://www.linuxtutorialblog.com/post/tutorial-conditions-in-bash-scripting-if-statements?replytocom=590#respond)
		
	
		![[./_resources/Tutorial_Conditions_in_bash_scripting_(if_statements)_«_Linux_Tutorial_Blog_www.linuxtutorialblog.com.resources/unknown_filename.3.png]]
				
		
		**[rechosen](http://www.linuxtutorialblog.com/)** March 26, 2010 at 08:01
		
		I think df would do the job here. If you run df
		
		, it will detect whether the specified folder is a mount or just a directory inside an other mount. Try this:
		
		if ! df /foo/tmp | grep -q /foo/tmp; then
		\# Nothing is currently specifically mounted to /foo/tmp (not including subdirectories)
		mount -t tmpfs none /foo/tmp
		fi
		
		[Reply](http://www.linuxtutorialblog.com/post/tutorial-conditions-in-bash-scripting-if-statements?replytocom=647#respond)
		
	
		![[./_resources/Tutorial_Conditions_in_bash_scripting_(if_statements)_«_Linux_Tutorial_Blog_www.linuxtutorialblog.com.resources/unknown_filename.3.png]]
				
		
		**[rechosen](http://www.linuxtutorialblog.com/)** April 11, 2010 at 07:55
		
		Thanks! I hope to publish a similar tutorial on bash arithmetics soon.
		
		[Reply](http://www.linuxtutorialblog.com/post/tutorial-conditions-in-bash-scripting-if-statements?replytocom=757#respond)
		
			
	
	**[17 Amazing Tutorials for Creating Bash Scripts | Tech Remedy](http://www.techremedy.net/blog/?p=192)** June 20, 2010 at 05:23
	
	\[...\] 14.  Conditions in Bash Scripting \[...\]
	
	[Reply](http://www.linuxtutorialblog.com/post/tutorial-conditions-in-bash-scripting-if-statements?replytocom=1691#respond)
	
			
	
	**[Ultimate tutorials to Create BASH scripts | IT OPERATIONZ](http://www.itoperationz.com/2010/07/ultimate-tutorials-to-create-bash-scripts/)** July 8, 2010 at 06:57
	
	\[...\] a Simple Bash Script HypeXR’s Getting Started With Bash SiteGround – Advanced Bash Loops Conditions in Bash Scripting Lutus’ Bash Shell Programming in Linux Advanced Bash Environment Variables GNU Universal Bash \[...\]
	
	[Reply](http://www.linuxtutorialblog.com/post/tutorial-conditions-in-bash-scripting-if-statements?replytocom=1905#respond)
	
	![0d2f9c34f3c462ffce88031c4f169b95?s=40&d=http%3A%2F%2Fwww.gravatar.com%2Favatar%2F61a58ec1c1fba116f8424035089b7c71%3Fs%3D40&r=G](http://0.gravatar.com/avatar/0d2f9c34f3c462ffce88031c4f169b95?s=40&d=http%3A%2F%2Fwww.gravatar.com%2Favatar%2F61a58ec1c1fba116f8424035089b7c71%3Fs%3D40&r=G)
		
	
	**Chris** July 8, 2010 at 12:36
	
	Great stuff, handy quick reference.
	
	[Reply](http://www.linuxtutorialblog.com/post/tutorial-conditions-in-bash-scripting-if-statements?replytocom=1910#respond)
	
	![f5ba0843f620ab1dff7b8f86e381f7f6?s=40&d=http%3A%2F%2Fwww.gravatar.com%2Favatar%2F61a58ec1c1fba116f8424035089b7c71%3Fs%3D40&r=G](http://1.gravatar.com/avatar/f5ba0843f620ab1dff7b8f86e381f7f6?s=40&d=http%3A%2F%2Fwww.gravatar.com%2Favatar%2F61a58ec1c1fba116f8424035089b7c71%3Fs%3D40&r=G)
		
	
	**MadKat** July 8, 2010 at 20:14
	
	Simply: Thank You :)
	
	[Reply](http://www.linuxtutorialblog.com/post/tutorial-conditions-in-bash-scripting-if-statements?replytocom=1915#respond)
	
			
	
	**[A question on inverting a bash script statement...](http://www.linuxquestions.org/questions/linux-newbie-8/a-question-on-inverting-a-bash-script-statement-819222/#post4029952)** July 11, 2010 at 16:29
	
	\[...\] something is worth taking a look at. I think you need some bash tutorials. Here are some links: <http://www.linuxtutorialblog.com/pos...-if-statements> <http://tldp.org/LDP/abs/html/> <http://tldp.org/HOWTO/Bash-Prog-Intro-HOWTO.html> \[...\]
	
	[Reply](http://www.linuxtutorialblog.com/post/tutorial-conditions-in-bash-scripting-if-statements?replytocom=1958#respond)
	
	![eda7feb7f0d2cdddbf5a315f6c10bba7?s=40&d=http%3A%2F%2Fwww.gravatar.com%2Favatar%2F61a58ec1c1fba116f8424035089b7c71%3Fs%3D40&r=G](http://0.gravatar.com/avatar/eda7feb7f0d2cdddbf5a315f6c10bba7?s=40&d=http%3A%2F%2Fwww.gravatar.com%2Favatar%2F61a58ec1c1fba116f8424035089b7c71%3Fs%3D40&r=G)
		
	
	**macdental** November 30, 2010 at 09:30
	
	this is a very nice tutorial!
	
	[Reply](http://www.linuxtutorialblog.com/post/tutorial-conditions-in-bash-scripting-if-statements?replytocom=5299#respond)
	
	![525565d0ec86f99b80585abcb81f2411?s=40&d=http%3A%2F%2Fwww.gravatar.com%2Favatar%2F61a58ec1c1fba116f8424035089b7c71%3Fs%3D40&r=G](http://1.gravatar.com/avatar/525565d0ec86f99b80585abcb81f2411?s=40&d=http%3A%2F%2Fwww.gravatar.com%2Favatar%2F61a58ec1c1fba116f8424035089b7c71%3Fs%3D40&r=G)
		
	
	**Mansoor Ali** January 20, 2011 at 15:20
	
	its a real great tutorial... Thank You
	
	[Reply](http://www.linuxtutorialblog.com/post/tutorial-conditions-in-bash-scripting-if-statements?replytocom=9118#respond)
	
			
	
	**[Bash script: comparison with sequence of numbers?](http://www.linuxquestions.org/questions/programming-9/bash-script-comparison-with-sequence-of-numbers-870069/#post4299375)** March 22, 2011 at 17:13
	
	\[...\] what he's getting at. There's a really good explanation of the different uses of parenthesis here. I'd normally just use it as you have it only with the correct operator i.e. -gt and -lt rather \[...\]
	
	[Reply](http://www.linuxtutorialblog.com/post/tutorial-conditions-in-bash-scripting-if-statements?replytocom=14134#respond)
	
	![d7699f063274406de5898dcde49d1c86?s=40&d=http%3A%2F%2Fwww.gravatar.com%2Favatar%2F61a58ec1c1fba116f8424035089b7c71%3Fs%3D40&r=G](http://1.gravatar.com/avatar/d7699f063274406de5898dcde49d1c86?s=40&d=http%3A%2F%2Fwww.gravatar.com%2Favatar%2F61a58ec1c1fba116f8424035089b7c71%3Fs%3D40&r=G)
		
	
	**m\*** March 31, 2011 at 19:16
	
	Must say "Brilliant". Your effort is very much appreciated.
	Thanks.
	
	[Reply](http://www.linuxtutorialblog.com/post/tutorial-conditions-in-bash-scripting-if-statements?replytocom=14805#respond)
	
		![[./_resources/Tutorial_Conditions_in_bash_scripting_(if_statements)_«_Linux_Tutorial_Blog_www.linuxtutorialblog.com.resources/unknown_filename.3.png]]
				
		
		**[rechosen](http://www.linuxtutorialblog.com/)** April 11, 2011 at 09:40
		
		Thanks! Though if you don't mind my asking, which one is even better? I might learn from it :).
		
		Rechosen
		
		[Reply](http://www.linuxtutorialblog.com/post/tutorial-conditions-in-bash-scripting-if-statements?replytocom=15648#respond)
		
	![598819c85539d270b2d966f6aabbd306?s=40&d=http%3A%2F%2Fwww.gravatar.com%2Favatar%2F61a58ec1c1fba116f8424035089b7c71%3Fs%3D40&r=G](http://1.gravatar.com/avatar/598819c85539d270b2d966f6aabbd306?s=40&d=http%3A%2F%2Fwww.gravatar.com%2Favatar%2F61a58ec1c1fba116f8424035089b7c71%3Fs%3D40&r=G)
		
	
	**rabindra** April 27, 2011 at 09:23
	
	what are the errors in this code? can anyone comment?
	
	Part B
	1 #!/bin/bash
	2 # Process each file and link it if it is okay.
	3
	processfile()
	4 {
	5 lnopts="$1"
	6 filename="$2"
	7
	8 # file must be "normal file"
	9 if \[ ! -f "$filename" \]
	10 then
	11 echo "Not a normal file: $filename"
	12 retval=1
	13 # must have "read perms"
	14 elif \[ ! -r "$filename" \]
	15 then
	16 echo "No read permissions: $filename"
	17 retval=1
	18 # user must either effective owner the file or effective group owner of the file
	19 elif \[ ! -O "$filename" -o ! -G "$filename" \]
	20 then
	21 echo "No effective ownership or effective group ownership of file: $filename"
	22 retval=1
	23 # Otherwise all is well, link the file to current directory using existing name
	24 else
	25 ln $lnopts $filename
	26 retval=$?
	27 fi
	28 # Return the exit status code > 0 if a problem occured
	29 return $retval
	30 }
	31 # Initialise variables
	32 cont='N'
	33 lnopts='' "
	34
	35 # Process switches
	36 while test "$1" = '-c' '-o' "$1" = '-s'
	37 do
	38 if \[ "$1" = '-c' \]
	39 then
	40 cont='Y'
	41 shift
	42 fi
	43 if \[ "$1" = '-s' \]
	44 then
	45 lnopts='-s'
	46 shift
	47 fi
	48 done
	49
	50 echo "Commencing generation of files”
	51
	52 if \[ $# -lt 1 \]
	53 while read filename
	54 do
	55 processfile "$lnopts" "$filename"
	56 result=$?
	57 test $result -ne 0 -a "$cont" != 'Y' -a "$cont" != 'y' || exit 1
	58 done
	59 else
	60 for filename in $\*
	61 do
	62 processfile "$lnopts" "$filename"
	63 result=$?
	64 if \[ $result -ne 0 -a "$cont" != 'Y' \]
	65 then
	66 echo -n "Error occurred. Continue (y/n/a)? "
	67 read $cont
	68 test "$cont" = 'n' -o "$cont" = 'N' && exit 1
	69 \[ "$cont" = 'a' || "$cont" = 'A' \] && cont='Y'
	70 fi
	71 done
	72 fi
	73 echo "All files processed"
	
	[Reply](http://www.linuxtutorialblog.com/post/tutorial-conditions-in-bash-scripting-if-statements?replytocom=16576#respond)
	

## Post comment

Name (required)

Mail (will not be published) (required)

Website

Comment

 [![[./_resources/Tutorial_Conditions_in_bash_scripting_(if_statements)_«_Linux_Tutorial_Blog_www.linuxtutorialblog.com.resources/unknown_filename.11.png]] **Follow us on Twitter!**
See and influence what's coming up!](http://twitter.com/LinuxTutBlog)

## Contact

Got a question? You can e-mail the author using the [contact form](http://www.linuxtutorialblog.com/contact-me).

	© 2010 **Rechosen**. All Right Reserved.

* [Home](http://www.linuxtutorialblog.com/)

* [Contact me](http://www.linuxtutorialblog.com/contact-me)

Based on the Colorbold theme by [![[./_resources/Tutorial_Conditions_in_bash_scripting_(if_statements)_«_Linux_Tutorial_Blog_www.linuxtutorialblog.com.resources/unknown_filename.10.png]]](http://www.site5.com/reseller).
Kudos to them for such a great free theme!
