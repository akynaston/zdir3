4/12/2024 5:07:03 PM
HOw to fix username in WorkdayHCM:

send this

```


<nds dtdversion="4.0" ndsversion="8.x">
  <source>
    <product edition="Advanced" version="4.8.6.0000">DirXML</product>
    <contact>NetIQ Corporation</contact>
  </source>
  <input>
    <rename class-name="User" dest-dn="Employee_ID-44517" src-dn="swaiddev\Users\e44517">
      <association>Employee_ID-44517</association>
      <new-name>e44517</new-name>
    </rename>
  </input>
</nds>

```

to number 9:

![[Pasted image 20240412170707.png]]

output:
![[Pasted image 20240412170823.png]]



```
dev:
<nds dtdversion="4.0" ndsversion="8.x">
  <source>
    <product edition="Advanced" version="4.8.6.0000">DirXML</product>
    <contact>NetIQ Corporation</contact>
  </source>
  <input>
    <rename class-name="User" dest-dn="Employee_ID-61057" src-dn="swaiddev\Users\r61057">
      <association>Employee_ID-r61057</association>
      <new-name>abc61057</new-name>
    </rename>
  </input>
</nds>


PROD:


<nds dtdversion="4.0" ndsversion="8.x">
  <source>
    <product edition="Advanced" version="4.8.6.0000">DirXML</product>
    <contact>NetIQ Corporation</contact>
  </source>
  <input>
    <rename class-name="User" dest-dn="Employee_ID-44517" src-dn="swa-id\Users\e44517">
      <association>Employee_ID-44517</association>
      <new-name>e44517</new-name>
    </rename>
  </input>
</nds>

```

6/7/2024 2:54:49 PM
Created rename support story for Kyle, per the rename thing Kyel and I chatted about:
WorkdayHCM | IDM - Feature: Rename Support
https://southwest.atlassian.net/browse/CSIGA-6343