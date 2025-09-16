# ---Set Java Home in your bashrc---


Edit the bashrc:
vi /home/forgerock/.bashrc
  
Add these lines after the comment in the middle:
# Set JAVA_HOME and update PATH
```
export JAVA_HOME=/usr/lib/jvm/java-17-zulu-openjdk-jdk
export PATH=$JAVA_HOME/bin:$PATH
Run this command to source the bashrc and have those params now.
source ~/.bashrc
```