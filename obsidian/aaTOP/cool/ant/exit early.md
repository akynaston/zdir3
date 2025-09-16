See: 
https://ant.apache.org/manual/Tasks/fail.html

```

 <target name="bob">

        <loadfile property="turtle" srcfile="version.txt">
          <filterchain>
            <linecontainsregexp>
              <regexp pattern="cow"/>
            </linecontainsregexp>
          </filterchain>
        </loadfile>

        <echo>hi, value is </echo>
        <echo message="${turtle}"/>

        <fail>
            <condition>
                <not>
                    <isset property="turtle"/>
                </not>
            </condition>
        </fail>

        <echo> didnt fail</echo>

    </target>
```