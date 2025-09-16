<?xml version="1.0" encoding="UTF-8"?><driver-configuration dn="cn=VANILLA Rest Driver,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=SWA-IDALPHA" driver-set-dn="cn=Driver Set AEv1,ou=DirXML,ou=Services,o=SWA-IDALPHA" name="VANILLA Rest Driver" package-id="W09TP5WD_201504031512190264">
	<packages>
		<package id="W09TP5WD_201504031512190264" symbolic-name="com.netiqcorporation.netqrestbase" version="1.1.3.20240509105030"/>
		<package id="DQ3ZPHXF_201505121302320165" symbolic-name="com.netiqcorporation.netqrestdcfg" version="1.0.1.20180613142919"/>
		<package id="CP32RFWU_201505121250070695" symbolic-name="com.netiqcorporation.netqrestjson" version="1.1.0.20200528134627"/>
		<package id="XTEF1YO3_201006231733410161" symbolic-name="com.novellinc.novlpwdsync" version="2.1.2.20190806140123"/>
		<package id="3V750MRQ_201504031637130312" symbolic-name="com.netiqcorporation.netqrestpwd" version="1.0.0.20171211151747"/>
	</packages>
	<attributes package-id="W09TP5WD_201504031512190264" package-version="1.1.3.20240509105030">
		<configuration-manifest>
			<manifest name="REST">
				<capability name="password-sync"/>
				<capability name="password-subscribe"/>
				<capability name="processNewXsl"/>
			</manifest>
		</configuration-manifest>
		<driver-filter-xml>
			<filter>
				<filter-class class-name="Group" publisher="sync" subscriber="sync">
					<filter-attr attr-name="CN" publisher="sync" subscriber="sync"/>
					<filter-attr attr-name="Description" publisher="sync" subscriber="sync"/>
					<filter-attr attr-name="L" publisher="sync" subscriber="sync"/>
					<filter-attr attr-name="Member" publisher="sync" subscriber="sync"/>
					<filter-attr attr-name="OU" publisher="sync" subscriber="sync"/>
				</filter-class>
				<filter-class class-name="User" publisher="sync" publisher-create-homedir="false" publisher-track-template-member="true" subscriber="sync">
					<filter-attr attr-name="CN" publisher="sync" subscriber="sync"/>
					<filter-attr attr-name="Description" publisher="sync" subscriber="sync"/>
					<filter-attr attr-name="Facsimile Telephone Number" publisher="sync" subscriber="sync"/>
					<filter-attr attr-name="Full Name" publisher="sync" subscriber="sync"/>
					<filter-attr attr-name="Given Name" publisher="sync" subscriber="sync"/>
					<filter-attr attr-name="Initials" publisher="sync" subscriber="sync"/>
					<filter-attr attr-name="Internet EMail Address" publisher="sync" subscriber="sync"/>
					<filter-attr attr-name="L" publisher="sync" subscriber="sync"/>
					<filter-attr attr-name="OU" publisher="sync" subscriber="sync"/>
					<filter-attr attr-name="Surname" publisher="sync" subscriber="sync"/>
					<filter-attr attr-name="Telephone Number" publisher="sync" subscriber="sync"/>
					<filter-attr attr-name="Title" publisher="sync" subscriber="sync"/>
					<filter-attr attr-name="nspmDistributionPassword" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify"/>
				</filter-class>
			</filter>
		</driver-filter-xml>
		<reciprocal-links>
			<reciprocal-links/>
		</reciprocal-links>
		<driver-image>R0lGODlhYgBPAOZ/AP/rpP/1sf/hlfr6+tTU1P/xxM3Nze7u7tra2vz8/LW1td3d3f/ttNvXw56enubm5si7i6ioqOnp6SuIxrGldf/ekMHBwAFxu+Li4jEwLvX19V1dXdHR0P/zr2+u1vLy8nh4eEhISG6msxERD//nntHEjpmQbv/kmv/nopPD4r6wf+fZrYSEg+Pv+P/wqv/up+bUl7PU69Hl8//2tFmh0WhoaEaXzIC43Im0s8bDunJrUVBLOt3b1JKSkf/vu/LjotnTvv3xv//10v/jmNbOuf/54O7s2ispIrXNxK/Hsvvqr1VUTv/qqM7LxNrPr9TYrP3xtsjTsfb6/b22oPTtyGBbR/HdotLPyYyCX3BwcPnhn+fjq/rmp/XlqRx/vj88MfTsvPvoqv/trvTntPvsqE5OTe/2+v7+/v/xrP/yrf/fkv/rrNjVzsjHx9fX1+Lizt3ax/rgnYd9X/nkofvusfvwtPz0uPnppB0dHfPx3f39/dDGo/Tpqf///wAAAP///yH/C1hNUCBEYXRhWE1QPD94cGFja2V0IGJlZ2luPSLvu78iIGlkPSJXNU0wTXBDZWhpSHpyZVN6TlRjemtjOWQiPz4gPHg6eG1wbWV0YSB4bWxuczp4PSJhZG9iZTpuczptZXRhLyIgeDp4bXB0az0iQWRvYmUgWE1QIENvcmUgNS42LWMwMTQgNzkuMTU2Nzk3LCAyMDE0LzA4LzIwLTA5OjUzOjAyICAgICAgICAiPiA8cmRmOlJERiB4bWxuczpyZGY9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkvMDIvMjItcmRmLXN5bnRheC1ucyMiPiA8cmRmOkRlc2NyaXB0aW9uIHJkZjphYm91dD0iIiB4bWxuczp4bXA9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC8iIHhtbG5zOnhtcE1NPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvbW0vIiB4bWxuczpzdFJlZj0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL3NUeXBlL1Jlc291cmNlUmVmIyIgeG1wOkNyZWF0b3JUb29sPSJBZG9iZSBQaG90b3Nob3AgQ0MgMjAxNCAoTWFjaW50b3NoKSIgeG1wTU06SW5zdGFuY2VJRD0ieG1wLmlpZDpDQ0EwMTE1RUNFQzExMUU0QkJDQjg3QTVCNDMzRDQ0QyIgeG1wTU06RG9jdW1lbnRJRD0ieG1wLmRpZDpDQ0EwMTE1RkNFQzExMUU0QkJDQjg3QTVCNDMzRDQ0QyI+IDx4bXBNTTpEZXJpdmVkRnJvbSBzdFJlZjppbnN0YW5jZUlEPSJ4bXAuaWlkOkNDQTAxMTVDQ0VDMTExRTRCQkNCODdBNUI0MzNENDRDIiBzdFJlZjpkb2N1bWVudElEPSJ4bXAuZGlkOkNDQTAxMTVEQ0VDMTExRTRCQkNCODdBNUI0MzNENDRDIi8+IDwvcmRmOkRlc2NyaXB0aW9uPiA8L3JkZjpSREY+IDwveDp4bXBtZXRhPiA8P3hwYWNrZXQgZW5kPSJyIj8+Af/+/fz7+vn49/b19PPy8fDv7u3s6+rp6Ofm5eTj4uHg397d3Nva2djX1tXU09LR0M/OzczLysnIx8bFxMPCwcC/vr28u7q5uLe2tbSzsrGwr66trKuqqainpqWko6KhoJ+enZybmpmYl5aVlJOSkZCPjo2Mi4qJiIeGhYSDgoGAf359fHt6eXh3dnV0c3JxcG9ubWxramloZ2ZlZGNiYWBfXl1cW1pZWFdWVVRTUlFQT05NTEtKSUhHRkVEQ0JBQD8+PTw7Ojk4NzY1NDMyMTAvLi0sKyopKCcmJSQjIiEgHx4dHBsaGRgXFhUUExIREA8ODQwLCgkIBwYFBAMCAQAAIfkEAQAAfwAsAAAAAGIATwAAB/+Af4KDhIWGh4iJiouMjY6PkJGSgw8OS0cjfn4jGRsRA5OhoqOCBmWaqKmaIywHpK+wiAcbqEc1PQoWbQo9G5mbEbHCsG54mmUKbspuBM3OLMZ+WQnD1ZIEmXgRCMvKzs0cBAa0fhvU1uiLB8YZbQjcbm0RDj0OERYc+fksmlnp/4ho4XH3TkGNMiB6KOzBooYDA/r4+VEAsKKgNpq2cWNRhoWDjx/rKQSBD+ISP3g+WAR4asmCBW5AOLSnoE0bA20szHPAog0HnMZYLFqgAKTRo0iTKl3K9KgmBe96zFTAAQGGBw8wLOBgIaSBr/xGgDKkgcURVWjTql3Ltm2qIwv/EFjY8NGCmwcHPmjYe0ACgjYgf7bJRLGQhWicQpRZzLixY8aKI5cJEZmy5cuYM2umzOIli3p2JXwYQLr0hwMLuj78erJGoR6a8PQ4oEdPgtK4B+zdvfuD798HggsPLqGvhOPHsSrPiqF585fQ38XNEiEChwejE+g5w/22BgkEiloA6ycDoQiaNnzoUzvB7dy6dfPe+xv48OHI8y/H6tz5Aq3QvcQBC7kscMAA2/WhYB9n3PYBBvKMxwF6IwziRiY1cHdGe+/BN19v9Z12H3HG6bdff/4F+JIBDtSEHYJnLKigHro9MOF4BligySAh+PFFAgxuaFuHuGkg33whijhi/4kmLoeiVgBGdyMHEmiQQIwyMqjHd27k8pWOfpSiCQEKcschfKR9SF+IS/bFZHInPqmigLkQUOUAWMrYoAYHdHmTAQrs+EcWfiyxoJlDoqlmkkri96YEJzKH4pwvdWmAG3cmeOieErihy1ewHSFIBn5EsOmZNSrDw6qstsoDG6+yIeustF7Bhq1X5Kqrrk306quvORkQHVWYZpcng96B96cBNZQjiCYInJroADDBUMG12Gar7bbcduvttSuMF50FCCyAnZG1aUjjAAfY6NNXZznwrB8HSOseu26soMa+/Pbr778ABywwv1boEp1ckB5g5ADa2ZbmARggABGLmkgwb/+9ZQp5LwZuWDHwxyCHzG9OB1/n28K5aXDaAxNz8IWzF9t7G0xxiGzzzf0SYQEBL70jMW3uBd0hnxDtA+0gmmAc5Jk0C+D001BHLfXUVFcNdcFt9OxzM3pkuSDL+RgQQSZCIU2vzNS6EYfVbLftNtQ68+zzO26E88DCEmylDwcOZBLCWDFnzLQbWrxt+OFRx5EDuXPDs8w3BITTRrPluUJI0mjDVDjinBuOdePdMPONQb8sIYUhmAs+ZAKaD+H667DHLvvstNc+e7gE0d1NMw58EQ1KwRyS+tKJxjWH7cgnr/ztixOg++MEgIBKCA4AjvrZqgdt/Ancd+/99+CHL37/+MhbsXgboYsufRkqLTI8ohsjMMf49Ndv//1DOGHBp82oD7P72CNe/LhAggIa8IAITKACF8jABhZQC/rbHwf8t4FGvE9jt4kYAR3IwQ56kIE6m2AzpFdBRlzwTBELAwpWyMIWuvCFMIwhC0kAAxjMQYYxDCEFLRhA+GVwAWFgAhZ2kIEM4OEIGdgBFmAAABQwoYlPdGIT77CCKDzhB1HMIhRVUAU8jAAPeKiC7/DwhTKa8YxlBIAOR/g/RZwwUVpRwgvGCMY6HpECTMijHvP4BBFMwAuA9IINcNCFPeZRDnYE4w4SyUg7MgEI+NihCXuIwQHEcQ07OMIOrMCFMMDA/wQZOMIRSrCGUpayCzjwwgT+uMpWTiAKplwDBY4QRlKuoQsqUAEWsECBXGJBlCbIpTDDAEkRRq+NiXjjxhbAACUsIQNVUIIYmimGPRRRBwyYJgO6QINW3kAGZpBCC2LQzQkkYZpiKEMGlqAEBmTTne2EJwNUUEQIKOGe92RAMSUJQKX50JILkKYYa+DOgjJAB18ogw8K6gEbTIAGLWjBDWjgARmwJwU2sEEUfDCGMppgoQs1qDsXOoUy7kGk+owkG0vYT7RpJQwkyMAIqsAAH9h0oT0IwRJuioSMQtQMNMhoRi2qB4zSAAxjUMxHb8pUpkKAMntoqg/2uVIe+rOSD/8AIgDO8gUAAEAMPghCAeSwBBCINQgeoAENYqAHcqpVrTdQEFBpgIQC1GADG1hBAQpwVr76NQh7WMIG9vDXAkxVpcdkqRspeaashmGrPvJqEwEAgQyEYAp7fQNFPSCFtqbgs6BdUAo8cIMCTKEGNcgCZvfK2tbuAbVOaK0YAEDVxFoVbVlVAmS/QAKvwgALmeAtExiABIqmQK5mSK5ylRuDG9xACEKYAgimy4IpUAG62IUuEabbgL3O1quQJAA/F3vVxmLgsWfZxC80oYM5SFYEF7hAXPvg3BuA9r6gzQN0G0CPheQAu0WALhBqEAIISFayQGiDeKs6yfImKiu6Ta//KvCgggPDV74KokF8LzABn5I2v0UIcRHeoJMI9CACQtgrFMRAAU1U+MC03dl4k8nYB2Mgwj56AQDmMEtNlECyOIivBxSUgg0b+chdgDFl04uFA7fYDy8+cIIXbNsG4/bGL+AqAF7AZRhkYgdbfkES4msDuR55wzaIwQW8wOU2cxkAXkaJjrn8ZBW4mctTnjEilHkbCGc5x28GgA40YQUdd8EL8W0Bkc/shRZoWAR3dnMVNHGHN9c50nlmcEuz12csa9nNT6ZAmy9MA9EiOr4QVfMFfhDpNg/aD5Wms4sj3QCf6Fl4Nb5XVujw5y+42QU/YG+byXDq+fZBCjKIgRn0/yADROOg1W8+yxFAPes715rKJLwtpwew615HmlQZcPMTTm2DFsQoRlK4QXxFQIYX3GEHKnBBm38waT9gwQXyfkGd893ma9/6eg6+lwQwQAcXcPUF+Eb4C15tBXzL+wkT2PAEPJDWDbNb3ipYxRfE+IsdINzh+3Y4vv2tafKiDVIFP7jIXQABTZhg5WRI5Zk1+nEXlOBlqhgBFmqO75CLnORV3rQA+/wAOqChBCWAwcrxjXSlL90FT8CB1JOwBZ7jGw1WUIEJsGACCJDh6T9A+g+WDvRsW3nbkKoDGtZ+9bW73eFuj/va05AGkcsdDXavO97vjncX8L3syNxzrm+Tdv++G/7wiE+84t0OBwX/uxB8HgCkoED3ylv+8pjPvOY3z3nMA16xNA444R9A+c6b/vSo33zjsR14XIte8qRPvexnb3o4GID1oBe86BMw+Q74/vfAD77wh0/84hs/+LbHvbaHLnkJQOH40I++9I2f/MdfbvC8l4AdAsD97nv/++APv/jHT/7vV7/koUdbu7Zf/va7//3jP3/QTb7tvrAf/vjPP/nlb3ah/7MvQaB/AjiA3ccGt2d9ZvN6HyABVDADDviAEBiBEjiBFFiBFviAAQAGX+ENBEAorjFJZLJt32EEF1iCJniCFAgGPyFeokMLINAIpOIAaMMuEmAEdoCCOJj2gxFoB2AAB/oAPfHSCNLzBTNIg/mBHPvhJE/yHFESII3zPBwIOXsTDruDHn5gMYyAAE+xbabxKEnIH5LSH/8xhiryhI6zO5DjDOlDAKRSBo8gEA/AfIqyKGyyJMVxhJASJ5MyJ6DTDYTiBwTwCBLADhLwTx5yJLyRJG3yKHmohGLYhFrjM90gPX5QNo8wGChhAQ1zL3P4IYpoh16oh2LIh3OjDG1wCq3HCG0QDSEQAQZyh3gIJ04ShkxIin0IPd8whT/xFbwoD77QD+cgCRJADm5RjMZ4jMiIB4UxCh1IKsj4jNBojHiwBBEQjCtxjdiYjdoICYEAADs=</driver-image>
		<log-events inherit="true"/>
		<trace-file inherit="true"/>
		<trace-size-limit inherit="true"/>
		<trace-level inherit="true"/>
		<driver-trace-level inherit="true"/>
		<log-limit inherit="true"/>
		<log-events-type inherit="true"/>
		<java-module value="com.novell.nds.dirxml.driver.rest.RESTDriverShim"/>
		<policy-linkage>
			<linkage-item dn="cn=NETQRESTJSON-itp-CheckRetries,cn=VANILLA Rest Driver,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=SWA-IDALPHA" order="0" policy-set="1" policy-set-name="Input"/>
			<linkage-item dn="cn=NETQRESTJSON-itp-JSONtoXDS,cn=Publisher,cn=VANILLA Rest Driver,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=SWA-IDALPHA" order="1" policy-set="1" policy-set-name="Input"/>
			<linkage-item dn="cn=NETQRESTDCFG-itp-AddAssociation,cn=VANILLA Rest Driver,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=SWA-IDALPHA" order="2" policy-set="1" policy-set-name="Input"/>
			<linkage-item dn="cn=NOVLPWDSYNC-itp-EmailOnFailedPwdSub,cn=VANILLA Rest Driver,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=SWA-IDALPHA" order="3" policy-set="1" policy-set-name="Input"/>
			<linkage-item dn="cn=NETQPWDSYNC-itp-TransformPassword,cn=Publisher,cn=VANILLA Rest Driver,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=SWA-IDALPHA" order="4" policy-set="1" policy-set-name="Input"/>
			<linkage-item dn="cn=NETQRESTDCFG-otp-AddAssociation,cn=VANILLA Rest Driver,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=SWA-IDALPHA" order="0" policy-set="2" policy-set-name="Output"/>
			<linkage-item dn="cn=NOVLPWDSYNC-otp-EmailOnFailedPwdPub,cn=VANILLA Rest Driver,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=SWA-IDALPHA" order="1" policy-set="2" policy-set-name="Output"/>
			<linkage-item dn="cn=NETQRESTDCFG-otp-ConvertQueryExToQuery,cn=VANILLA Rest Driver,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=SWA-IDALPHA" order="2" policy-set="2" policy-set-name="Output"/>
			<linkage-item dn="cn=NETQRESTJSON-otp-XDStoJSON,cn=Subscriber,cn=VANILLA Rest Driver,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=SWA-IDALPHA" order="3" policy-set="2" policy-set-name="Output"/>
			<linkage-item dn="cn=NETQRESTDCFG-otp-AddFromCprsFlag,cn=VANILLA Rest Driver,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=SWA-IDALPHA" order="4" policy-set="2" policy-set-name="Output"/>
			<linkage-item dn="cn=NETQRESTDCFG-sub-mp,cn=Subscriber,cn=VANILLA Rest Driver,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=SWA-IDALPHA" order="0" policy-set="6" policy-set-name="Subscriber Matching"/>
			<linkage-item dn="cn=NETQRESTDCFG-pub-mp,cn=Publisher,cn=VANILLA Rest Driver,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=SWA-IDALPHA" order="0" policy-set="7" policy-set-name="Publisher Matching"/>
			<linkage-item dn="cn=NETQPWDSYNC-sub-cp-UserPwdCheck,cn=Subscriber,cn=VANILLA Rest Driver,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=SWA-IDALPHA" order="0" policy-set="8" policy-set-name="Subscriber Create"/>
			<linkage-item dn="cn=NETQRESTDCFG-pub-cp,cn=Publisher,cn=VANILLA Rest Driver,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=SWA-IDALPHA" order="0" policy-set="9" policy-set-name="Publisher Create"/>
			<linkage-item dn="cn=NETQRESTDCFG-sub-ctp-Associate,cn=Subscriber,cn=VANILLA Rest Driver,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=SWA-IDALPHA" order="0" policy-set="10" policy-set-name="Subscriber Command"/>
			<linkage-item dn="cn=NETQRESTDCFG-sub-ctp-RenameToModify,cn=Subscriber,cn=VANILLA Rest Driver,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=SWA-IDALPHA" order="1" policy-set="10" policy-set-name="Subscriber Command"/>
			<linkage-item dn="cn=NOVLPWDSYNC-sub-ctp-TransformDistPwd,cn=Subscriber,cn=VANILLA Rest Driver,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=SWA-IDALPHA" order="2" policy-set="10" policy-set-name="Subscriber Command"/>
			<linkage-item dn="cn=NOVLPWDSYNC-sub-cp-DefaultPwd,cn=Subscriber,cn=VANILLA Rest Driver,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=SWA-IDALPHA" order="3" policy-set="10" policy-set-name="Subscriber Command"/>
			<linkage-item dn="cn=NOVLPWDSYNC-sub-ctp-CheckPwdGCV,cn=Subscriber,cn=VANILLA Rest Driver,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=SWA-IDALPHA" order="4" policy-set="10" policy-set-name="Subscriber Command"/>
			<linkage-item dn="cn=NOVLPWDSYNC-sub-ctp-AddPwdPayload,cn=Subscriber,cn=VANILLA Rest Driver,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=SWA-IDALPHA" order="5" policy-set="10" policy-set-name="Subscriber Command"/>
			<linkage-item dn="cn=NETQRESTDCFG-pub-ctp-ModifytoRename,cn=Publisher,cn=VANILLA Rest Driver,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=SWA-IDALPHA" order="0" policy-set="11" policy-set-name="Publisher Command"/>
			<linkage-item dn="cn=NOVLPWDSYNC-pub-cp-DefaultPwd,cn=Publisher,cn=VANILLA Rest Driver,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=SWA-IDALPHA" order="1" policy-set="11" policy-set-name="Publisher Command"/>
			<linkage-item dn="cn=NOVLPWDSYNC-pub-ctp-CheckPwdGCV,cn=Publisher,cn=VANILLA Rest Driver,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=SWA-IDALPHA" order="2" policy-set="11" policy-set-name="Publisher Command"/>
			<linkage-item dn="cn=NOVLPWDSYNC-pub-ctp-PublishDistPwd,cn=Publisher,cn=VANILLA Rest Driver,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=SWA-IDALPHA" order="3" policy-set="11" policy-set-name="Publisher Command"/>
			<linkage-item dn="cn=NOVLPWDSYNC-pub-ctp-PublishNDSPwd,cn=Publisher,cn=VANILLA Rest Driver,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=SWA-IDALPHA" order="4" policy-set="11" policy-set-name="Publisher Command"/>
			<linkage-item dn="cn=NOVLPWDSYNC-pub-ctp-AddPwdPayload,cn=Publisher,cn=VANILLA Rest Driver,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=SWA-IDALPHA" order="5" policy-set="11" policy-set-name="Publisher Command"/>
			<linkage-item dn="cn=NETQRESTDCFG-pub-pp,cn=Publisher,cn=VANILLA Rest Driver,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=SWA-IDALPHA" order="0" policy-set="13" policy-set-name="Publisher Placement"/>
			<linkage-item dn="cn=NETQRESTPWD-GCV,cn=VANILLA Rest Driver,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=SWA-IDALPHA" order="0" policy-set="14" policy-set-name="Global Configs"/>
			<linkage-item dn="cn=NOVLPWDSYNC-GCVs,cn=VANILLA Rest Driver,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=SWA-IDALPHA" order="1" policy-set="14" policy-set-name="Global Configs"/>
		</policy-linkage>
		<driver-cache-limit value="0"/>
		<shim-auth-password-query/>
		<driver-password-query/>
		<driver-start-option no-resync="" value="2"/>
		<shim-config-info-xml>
			<driver-config name="REST Driver">
				<driver-options>
					<configuration-values>
						<definitions>
							<group>
								<definition display-name="Custom Java Extensions" id="100" name="viewJavaGroup" type="enum">
									<description>Select Show if you have developed custom Java classes to extend the driver shim's functionality.</description>
									<enum-choice display-name="Show">show</enum-choice>
									<enum-choice display-name="Hide">hide</enum-choice>
									<value>show</value>
								</definition>
								<subordinates active-value="show">
									<group>
										<definition display-name="Document Handling" id="101" name="documentJavaGroup" type="enum">
											<description>Select Implemented if you have developed a custom Java class to process data as XML documents.</description>
											<enum-choice display-name="Implemented">yes</enum-choice>
											<enum-choice display-name="None">no</enum-choice>
											<value>no</value>
										</definition>
										<subordinates active-value="yes">
											<definition display-name="Class" id="102" name="documentClass" type="string">
												<description>Specify the class using a full package identifier. For example: com.novell.MyNewClass</description>
												<value/>
											</definition>
											<definition display-name="Init Parameter" id="103" name="documentParam" type="string">
												<description>Specify the parameter you want passed to the init() method of your class. The init method of your class is responsible for parsing the information contained in this string. Leave this field blank if your class doesn't require a configuration string to be passed to the init method.</description>
												<value/>
											</definition>
										</subordinates>
									</group>
									<group>
										<definition display-name="Schema" id="104" name="schemaJavaGroup" type="enum">
											<description>Select Implemented if you have developed a custom Java class to provide the application schema to the driver.</description>
											<enum-choice display-name="Implemented">yes</enum-choice>
											<enum-choice display-name="None">no</enum-choice>
											<value>no</value>
										</definition>
										<subordinates active-value="yes">
											<definition display-name="Class" id="105" name="schemaClass" type="string">
												<description>Specify the class using a full package identifier. For example: com.novell.MyNewClass</description>
												<value/>
											</definition>
											<definition display-name="Init Parameter" id="106" name="schemaParam" type="string">
												<description>Specify the parameter you want passed to the init() method of your class. The init method of your class is responsible for parsing the information contained in this string. Leave this field blank if your class doesn't require a configuration string to be passed to the init method.</description>
												<value/>
											</definition>
										</subordinates>
									</group>
								</subordinates>
							</group>
						</definitions>
					</configuration-values>
				</driver-options>
				<subscriber-options>
					<configuration-values>
						<definitions>
							<group>
								<definition display-name="Authentication Method" hide="false" id="107" name="subAuthMethod" type="enum">
									<description>Specify the authentication ID and password for the REST server or Web Service. Also specify the required headers and supported values for the selected authentication method.</description>
									<enum-choice display-name="Anonymous">Anonymous</enum-choice>
									<enum-choice display-name="Basic">Basic</enum-choice>
									<enum-choice display-name="OAuth2.0">OAuth</enum-choice>
									<value>OAuth</value>
								</definition>
								<subordinates active-value="Basic">
									<definition display-name="Authentication ID" hide="false" id="108" name="subAuthBasicID" type="string">
										<description>Specify the authentication ID for Basic Authorization (on the HTTP header).</description>
										<value xml:space="preserve"/>
									</definition>
									<definition display-name="Authentication Password" hide="false" id="109" is-sensitive="true" name="subAuthBasicPwd" type="password-ref">
										<description>Specify the authentication password for Basic Authorization (on the HTTP header).</description>
										<value xml:space="preserve">sub-password</value>
										<pwd-value removePwd="false"/>
									</definition>
								</subordinates>
								<subordinates active-value="OAuth">
									<!--  Support Bearer Token -->
									<group>
										<definition critical-change="true" display-name="OAuth2.0 Token Management" hide="false" id="301" name="bearerToken" type="enum">
											<description>Generate Bearer Token or JWT Token or Enter the Bearer Token for OAuth</description>
											<value>generateBearer</value>
											<enum-choice display-name="Generate Bearer Token">generateBearer</enum-choice>
											<enum-choice display-name="Generate JWT Token">generateJWT</enum-choice>
											<enum-choice display-name="Enter Bearer Token">enterBearerToken</enum-choice>
										</definition>
										<subordinates active-value="enterBearerToken">
											<definition display-name="Bearer Token ID" hide="false" id="303" name="bearerTokenID" type="string">
												<description>Specify the Bearer Token ID</description>
												<value xml:space="preserve"/>
											</definition>
											<definition display-name="Authorization Query Options" id="113" instance-separator=" " name="http-queryBearer" type="structured" value-separator=";">
												<value>
													<instance>
														<definition display-name="Query Name" name="query-nameBearer" type="string">
															<description>The name of the authentication query type parameter.</description>
															<value xml:space="preserve">client_id</value>
														</definition>
														<definition display-name="Query Value" name="query-valueBearer" type="string">
															<description>The supported value of authentication query type parameter.</description>
															<value xml:space="preserve"/>
														</definition>
													</instance>
													<instance>
														<definition display-name="Query Name" name="query-nameBearer" type="string">
															<description>The name of the authentication query type parameter.</description>
															<value xml:space="preserve">issuer</value>
														</definition>
														<definition display-name="Query Value" name="query-valueBearer" type="string">
															<description>The supported value of authentication query type parameter.</description>
															<value xml:space="preserve"/>
														</definition>
													</instance>
												</value>
												<description>Specify the required  header query parameter and values supported by the connected server for the OAuth 2.0 authentication method.

Example:
Query Name: grant_type
Query Value: client_credentials</description>
												<template max-count="10" min-count="0">
													<definition display-name="Query Name" id="122" multiline="false" name="query-nameBearer" type="string">
														<description>The name of the authentication query type parameter.</description>
													</definition>
													<definition display-name="Query Value" id="123" multiline="false" name="query-valueBearer" type="string">
														<description>The supported value of authentication query type parameter.</description>
													</definition>
												</template>
											</definition>
											<definition display-name="Secret Authorization Query Options" id="113" instance-separator=" " name="http-query-passwordBearer" type="structured" value-separator=";">
												<value>
													<instance>
														<definition display-name="Query Name" name="query-name-passwordBearer" type="string">
															<description>The name of the authentication query type parameter.</description>
															<value xml:space="preserve">refresh_token</value>
														</definition>
														<definition display-name="Query Value" name="query-value-passwordBearer" type="password-ref">
															<description>The supported value of authentication query type parameter.</description>
															<value xml:space="preserve">query-value-passwordBearer-0</value>
														</definition>
													</instance>
													<instance>
														<definition display-name="Query Name" name="query-name-passwordBearer" type="string">
															<description>The name of the authentication query type parameter.</description>
															<value xml:space="preserve">client_secret</value>
														</definition>
														<definition display-name="Query Value" name="query-value-passwordBearer" type="password-ref">
															<description>The supported value of authentication query type parameter.</description>
															<value xml:space="preserve">query-value-passwordBearer-1</value>
														</definition>
													</instance>
												</value>
												<description>Specify the encrypted required  header query parameter and values supported by the connected server for the OAuth 2.0 authentication method.

</description>
												<template max-count="10" min-count="0">
													<definition display-name="Query Name" id="122" multiline="false" name="query-name-passwordBearer" type="string">
														<description>The name of the authentication query type parameter.</description>
													</definition>
													<definition display-name="Query Value" id="123" is-sensitive="true" name="query-value-passwordBearer" type="password-ref">
														<description>The supported value of authentication query type parameter.</description>
														<value xml:space="preserve">query-value-passwordBearer</value>
														<value xml:space="preserve">query-value-passwordBearer-0</value>
														<value xml:space="preserve">query-value-passwordBearer-1</value>
													</definition>
												</template>
											</definition>
										</subordinates>
										<!--  Bearer Token End -->
										<!--  Start Generate JWT Token -->
										<subordinates active-value="generateJWT">
											<!-- <definition display-name="xlfid(NETQRESTBASE.initial.settings.param.subOAuthURLJWT)Access Token URL" hide="false" id="110" name="subOAuthURLJWT" type="string">
												<description>xlfid(NETQRESTBASE.initial.settings.param.dscr.subOAuthURLJWT) Specify the URL of the server used for requesting token access.</description>
												<value/>
											</definition>
											<definition display-name="xlfid(NETQRESTBASE.initial.settings.param.subOAuthIDJWT)User Name" hide="false" id="111" name="subOAuthIDJWT" type="string">
												<description>xlfid(NETQRESTBASE.initial.settings.param.dscr.subOAuthIDJWT)Specify the authentication ID for OAuth2.0 Authorization (on the HTTP header) is used.</description>
												<value/>
											</definition>
											<definition display-name="xlfid(NETQRESTBASE.initial.settings.param.subOAuthPwdJWT)User Password" hide="false" id="112" is-sensitive="true" name="subOAuthPwdJWT" type="password-ref">
												<description>xlfid(NETQRESTBASE.initial.settings.param.dscr.subOAuthPwdJWT)Specify the authentication password for OAuth2.0 Authorization (on the HTTP header) is used.</description>
												<value>subOAuthPwdJWT</value>
												<pwd-value removePwd="false"/>
											</definition>-->
											<definition display-name="Authorization Query Options" id="113" instance-separator=" " name="http-queryJWT" type="structured" value-separator=";">
												<value>
													<instance>
														<definition display-name="Query Name" name="query-nameJWT" type="string">
															<description>The name of the authentication query type parameter.</description>
															<value xml:space="preserve">client_id</value>
														</definition>
														<definition display-name="Query Value" name="query-valueJWT" type="string">
															<description>The supported value of authentication query type parameter.</description>
															<value xml:space="preserve"/>
														</definition>
													</instance>
													<instance>
														<definition display-name="Query Name" name="query-nameJWT" type="string">
															<description>The name of the authentication query type parameter.</description>
															<value xml:space="preserve">subject</value>
														</definition>
														<definition display-name="Query Value" name="query-valueJWT" type="string">
															<description>The supported value of authentication query type parameter.</description>
															<value xml:space="preserve"/>
														</definition>
													</instance>
													<instance>
														<definition display-name="Query Name" name="query-nameJWT" type="string">
															<description>The name of the authentication query type parameter.</description>
															<value xml:space="preserve">issuer</value>
														</definition>
														<definition display-name="Query Value" name="query-valueJWT" type="string">
															<description>The supported value of authentication query type parameter.</description>
															<value xml:space="preserve"/>
														</definition>
													</instance>
													<instance>
														<definition display-name="Query Name" name="query-nameJWT" type="string">
															<description>The name of the authentication query type parameter.</description>
															<value xml:space="preserve">client_auth_type</value>
														</definition>
														<definition display-name="Query Value" name="query-valueJWT" type="string">
															<description>The supported value of authentication query type parameter.</description>
															<value xml:space="preserve"/>
														</definition>
													</instance>
													<instance>
														<definition display-name="Query Name" name="query-nameJWT" type="string">
															<description>The name of the authentication query type parameter.</description>
															<value xml:space="preserve">recipient_keystore</value>
														</definition>
														<definition display-name="Query Value" name="query-valueJWT" type="string">
															<description>The supported value of authentication query type parameter.</description>
															<value xml:space="preserve"/>
														</definition>
													</instance>
												</value>
												<description>Specify the required  header query parameter and values supported by the connected server for the OAuth 2.0 authentication method.

Example:
Query Name: grant_type
Query Value: client_credentials</description>
												<template max-count="10" min-count="0">
													<definition display-name="Query Name" id="122" multiline="false" name="query-nameJWT" type="string">
														<description>The name of the authentication query type parameter.</description>
													</definition>
													<definition display-name="Query Value" id="123" multiline="false" name="query-valueJWT" type="string">
														<description>The supported value of authentication query type parameter.</description>
													</definition>
												</template>
											</definition>
											<definition display-name="Secret Authorization Query Options" id="113" instance-separator=" " name="http-query-passwordJWT" type="structured" value-separator=";">
												<value>
													<instance>
														<definition display-name="Query Name" name="query-name-passwordJWT" type="string">
															<description>The name of the authentication query type parameter.</description>
															<value xml:space="preserve">recipient_storepass</value>
														</definition>
														<definition display-name="Query Value" name="query-value-passwordJWT" type="password-ref">
															<description>The supported value of authentication query type parameter.</description>
															<value xml:space="preserve">query-value-passwordJWT-0</value>
														</definition>
													</instance>
													<instance>
														<definition display-name="Query Name" name="query-name-passwordJWT" type="string">
															<description>The name of the authentication query type parameter.</description>
															<value xml:space="preserve">recipient_keypass</value>
														</definition>
														<definition display-name="Query Value" name="query-value-passwordJWT" type="password-ref">
															<description>The supported value of authentication query type parameter.</description>
															<value xml:space="preserve">query-value-passwordJWT-1</value>
														</definition>
													</instance>
													<instance>
														<definition display-name="Query Name" name="query-name-passwordJWT" type="string">
															<description>The name of the authentication query type parameter.</description>
															<value xml:space="preserve">refresh_token</value>
														</definition>
														<definition display-name="Query Value" name="query-value-passwordJWT" type="password-ref">
															<description>The supported value of authentication query type parameter.</description>
															<value xml:space="preserve">query-value-passwordJWT-2</value>
														</definition>
													</instance>
													<instance>
														<definition display-name="Query Name" name="query-name-passwordJWT" type="string">
															<description>The name of the authentication query type parameter.</description>
															<value xml:space="preserve">client_secret</value>
														</definition>
														<definition display-name="Query Value" name="query-value-passwordJWT" type="password-ref">
															<description>The supported value of authentication query type parameter.</description>
															<value xml:space="preserve">query-value-passwordJWT-3</value>
														</definition>
													</instance>
												</value>
												<description>Specify the required encrypted header query parameter and values supported by the connected server for the OAuth 2.0 authentication method.
</description>
												<template max-count="10" min-count="0">
													<definition display-name="Query Name" id="122" multiline="false" name="query-name-passwordJWT" type="string">
														<description>The name of the authentication query type parameter.</description>
													</definition>
													<definition display-name="Query Value" id="123" is-sensitive="true" name="query-value-passwordJWT" type="password-ref">
														<description>The supported value of authentication query type parameter.</description>
														<value xml:space="preserve">query-value-passwordJWT</value>
														<value xml:space="preserve">query-value-passwordJWT-0</value>
														<value xml:space="preserve">query-value-passwordJWT-1</value>
														<value xml:space="preserve">query-value-passwordJWT-2</value>
														<value xml:space="preserve">query-value-passwordJWT-3</value>
													</definition>
												</template>
											</definition>
											<definition display-name="Claim Set" instance-separator=" " name="claim-set" type="structured" value-separator=";">
												<value/>
												<description>Enter the required claims set to be passed
Example:
claim name: scope
claim value:  read</description>
												<template max-count="10" min-count="0">
													<definition display-name="Claim Name" id="" multiline="false" name="claimset-name" type="string">
														<description>The name of claimset field.Example: scope</description>
														<value xml:space="preserve"/>
													</definition>
													<definition display-name="Claim Value" id="" multiline="false" name="claimset-value" type="string">
														<description>The supported value for the above specified claimset field.Example: admin_read</description>
														<value xml:space="preserve"/>
													</definition>
												</template>
											</definition>
										</subordinates>
										<!--  End Generate JWT Token -->
										<!--  Start Generate Bearer Token -->
										<subordinates active-value="generateBearer">
											<definition display-name="Access Token URL" hide="false" id="110" name="subOAuthURL" type="string">
												<description> Specify the URL of the server used for requesting token access.</description>
												<value xml:space="preserve"/>
											</definition>
											<definition display-name="User Name" hide="false" id="111" name="subOAuthID" type="string">
												<description>Specify the authentication ID for OAuth2.0 Authorization (on the HTTP header) is used.</description>
												<value xml:space="preserve"/>
											</definition>
											<definition display-name="User Password" hide="false" id="112" is-sensitive="true" name="subOAuthPwd" type="password-ref">
												<description>Specify the authentication password for OAuth2.0 Authorization (on the HTTP header) is used.</description>
												<value xml:space="preserve">subOAuthPwd</value>
												<pwd-value removePwd="false"/>
											</definition>
											<definition display-name="Encode Authorization Query Options" hide="false" id="110" name="subAuthEncode" type="enum">
												<description> Specify 'Yes' to URL Encode Authorization Query options and Secret Authorization Query option, Else specify 'No'.</description>
												<value>yes</value>
												<enum-choice display-name="Yes">yes</enum-choice>
												<enum-choice display-name="No">no</enum-choice>
											</definition>
											<definition display-name="Authorization Query Options" id="113" instance-separator=" " name="http-query" type="structured" value-separator=";">
												<value>
													<instance>
														<definition display-name="Query Name" name="query-name" type="string">
															<description>The name of the authentication query type parameter.</description>
															<value xml:space="preserve">grant_type</value>
														</definition>
														<definition display-name="Query Value" name="query-value" type="string">
															<description>The supported value of authentication query type parameter.</description>
															<value xml:space="preserve"/>
														</definition>
													</instance>
													<instance>
														<definition display-name="Query Name" name="query-name" type="string">
															<description>The name of the authentication query type parameter.</description>
															<value xml:space="preserve">client_id</value>
														</definition>
														<definition display-name="Query Value" name="query-value" type="string">
															<description>The supported value of authentication query type parameter.</description>
															<value xml:space="preserve"/>
														</definition>
													</instance>
													<instance>
														<definition display-name="Query Name" name="query-name" type="string">
															<description>The name of the authentication query type parameter.</description>
															<value xml:space="preserve">issuer</value>
														</definition>
														<definition display-name="Query Value" name="query-value" type="string">
															<description>The supported value of authentication query type parameter.</description>
															<value xml:space="preserve"/>
														</definition>
													</instance>
												</value>
												<description>Specify the required  header query parameter and values supported by the connected server for the OAuth 2.0 authentication method.

Example:
Query Name: grant_type
Query Value: client_credentials</description>
												<template max-count="10" min-count="0">
													<definition display-name="Query Name" id="122" multiline="false" name="query-name" type="string">
														<description>The name of the authentication query type parameter.</description>
													</definition>
													<definition display-name="Query Value" id="123" multiline="false" name="query-value" type="string">
														<description>The supported value of authentication query type parameter.</description>
													</definition>
												</template>
											</definition>
											<definition display-name="Secret Authorization Query Options" id="113" instance-separator=" " name="http-query-password" type="structured" value-separator=";">
												<value>
													<instance>
														<definition display-name="Query Name" name="query-name-password" type="string">
															<description>The name of the authentication query type parameter.</description>
															<value xml:space="preserve">refresh_token</value>
														</definition>
														<definition display-name="Query Value" name="query-value-password" type="password-ref">
															<description>The supported value of authentication query type parameter.</description>
															<value xml:space="preserve">query-value-password-0</value>
														</definition>
													</instance>
													<instance>
														<definition display-name="Query Name" name="query-name-password" type="string">
															<description>The name of the authentication query type parameter.</description>
															<value xml:space="preserve">client_secret</value>
														</definition>
														<definition display-name="Query Value" name="query-value-password" type="password-ref">
															<description>The supported value of authentication query type parameter.</description>
															<value xml:space="preserve">query-value-password-1</value>
														</definition>
													</instance>
												</value>
												<description>Specify the required encrypted header query parameter and values supported by the connected server for the OAuth 2.0 authentication method.
</description>
												<template max-count="10" min-count="0">
													<definition display-name="Query Name" id="122" multiline="false" name="query-name-password" type="string">
														<description>The name of the authentication query type parameter.</description>
													</definition>
													<definition display-name="Query Value" id="123" is-sensitive="true" name="query-value-password" type="password-ref">
														<description>The supported value of authentication query type parameter.</description>
														<value xml:space="preserve">query-value-password</value>
														<value xml:space="preserve">query-value-password-0</value>
														<value xml:space="preserve">query-value-password-1</value>
													</definition>
												</template>
											</definition>
										</subordinates>
										<!--  End Generate JWT Token -->
									</group>
								</subordinates>
							</group>
							<definition display-name="Authorization Header Fields" id="124" instance-separator=" " name="http-header" type="structured" value-separator=";">
								<value/>
								<description>Enter the required authentication header fields and supported values for the selected authentication method.
Example:
header-name: Content-Type
header-value:  application/json</description>
								<template max-count="10" min-count="0">
									<definition display-name="Header Name" id="125" multiline="false" name="header-name" type="string">
										<description>The name of header field name.</description>
									</definition>
									<definition display-name="Header Value" id="126" multiline="false" name="header-value" type="string">
										<description>The supported value for the above specified header field name.</description>
									</definition>
								</template>
							</definition>
							<definition display-name="Truststore file" id="127" name="subTrustStoreFile" type="string">
								<description>When the remote server is configured to provide server authentication, this is the path and the name of the keystore file which contains trusted certificates. For example: c:\security\truststore. Leave this field blank when server authentication is not used.</description>
								<value xml:space="preserve"/>
							</definition>
							<group>
								<definition display-name="Set mutual authentication parameters" hide="false" id="128" name="mutualFields" type="enum">
									<description>Select Show if you want to set mutual authentication information.</description>
									<enum-choice display-name="Show">show</enum-choice>
									<enum-choice display-name="Hide">hide</enum-choice>
									<value>hide</value>
								</definition>
								<subordinates active-value="show">
									<definition display-name="Keystore file" id="129" name="subKeystoreFile" type="string">
										<description>When the remote server is configured to provide mutual authentication, this is the path and the name of the keystore file. For example: C:\security\keystore. Leave this field blank when mutual authentication is not used.</description>
										<value xml:space="preserve"/>
									</definition>
									<definition display-name="Keystore password" id="130" name="subKeystorePassword" type="password-ref">
										<description>When the remote server is configured to provide mutual authentication, this is the keystore file password. Leave this field blank when mutual authentication is not used.</description>
										<value xml:space="preserve">sub-password</value>
									</definition>
								</subordinates>
							</group>
							<definition display-name="Http Connection Timeout" id="131" name="connTimeOut" type="string">
								<description>Time in minutes for the driver to wait for a REST response.</description>
								<value xml:space="preserve">1</value>
							</definition>
							<definition display-name="Proxy host and port" id="132" name="proxy" type="string">
								<description>When a proxy host and port are used, specify the host address and the host port. For example: 192.10.1.3:18180. Choose an unused port number on your server. Otherwise, leave this field blank.</description>
								<value xml:space="preserve"/>
							</definition>
							<group>
								<definition display-name="Set proxy authentication parameters" hide="false" id="128" name="proxyFields" type="enum">
									<description>Select Show if you want to set proxy authentication information.</description>
									<enum-choice display-name="Show">show</enum-choice>
									<enum-choice display-name="Hide">hide</enum-choice>
									<value>hide</value>
								</definition>
								<subordinates active-value="show">
									<definition display-name="User name" id="129" name="proxyUserName" type="string">
										<description>User name for authentication based proxy settings.</description>
										<value xml:space="preserve"/>
									</definition>
									<definition display-name="Password" id="130" name="proxyPassword" type="password-ref">
										<description>Password for authentication based proxy settings.</description>
										<value xml:space="preserve">proxyPassword</value>
									</definition>
								</subordinates>
							</group>
							<definition display-name="HTTP errors to retry" id="134" name="subHttpErrorsToRetry" type="string">
								<description>List the HTTP error codes that should return a retry status. Must be a list of integers separated by spaces.</description>
								<value xml:space="preserve">307 408 503 504</value>
							</definition>
							<definition display-name="Base URL for REST Resources" id="135" name="subHttpRESTBASEURL" type="string">
								<description>Enter the base url for the rest endpoints.Any REST resource, method, and parameters will be appended to this base URL to form a request.
Example: http://164.99.162.47:7075</description>
								<value xml:space="preserve"/>
							</definition>
							<header display-name="Resources" id="179"/>
							<definition display-name="Configure Resources to synchronize" id="136" instance-separator=" " name="subHttpResources" type="structured" value-separator=";">
								<value/>
								<description>Mention appropriate REST URLs for operations on respective resources.</description>
								<template max-count="10" min-count="0">
									<definition display-name="Schema name" id="146" multiline="false" name="resrc-schemaName" type="string">
										<description>Specify the class name of the user resource returned present in application schema.</description>
										<value xml:space="preserve"/>
									</definition>
									<group>
										<definition display-name="Configure Handlers" id="147" instance-separator=" " name="resrc-operationMode" type="enum">
											<description>Mention appropriate REST URLs for operations on respective resources.</description>
											<enum-choice display-name="default">STANDARD</enum-choice>
											<enum-choice display-name="custom">CUSTOM</enum-choice>
											<value>STANDARD</value>
										</definition>
										<subordinates active-value="CUSTOM">
											<definition display-name="Rest Handler Details" id="148" instance-separator=" " name="resrc-handlerConf" type="structured" value-separator="#">
												<description>Mention appropriate REST URLs for operations on respective resources.</description>
												<template max-count="10" min-count="0">
													<definition display-name="URL extension" id="149" multiline="false" name="user-url" type="string">
														<description>Specify the REST URLs for the resource. Mention queriable strings within arrow-brackets.</description>
													</definition>
													<definition display-name="Operation" id="150" name="resrc-operation" type="enum">
														<description>Select operation</description>
														<enum-choice display-name="Add">0</enum-choice>
														<enum-choice display-name="Modify">1</enum-choice>
														<enum-choice display-name="Query">2</enum-choice>
														<enum-choice display-name="Delete">3</enum-choice>
													</definition>
													<definition display-name="Method" id="151" multiline="false" name="resrc-methodCall" type="enum">
														<description>HTTP method to be used.</description>
														<enum-choice display-name="GET">0</enum-choice>
														<enum-choice display-name="POST">1</enum-choice>
														<enum-choice display-name="PATCH">2</enum-choice>
														<enum-choice display-name="PUT">3</enum-choice>
														<enum-choice display-name="DELETE">4</enum-choice>
													</definition>
													<definition display-name="Optional Header Fields" id="152" instance-separator=" " name="resrc-header" type="structured" value-separator=";">
														<description/>
														<template max-count="10" min-count="0">
															<definition display-name="Header Name" id="153" multiline="false" name="resrc-headerName" type="string">
																<description>Header Name.</description>
															</definition>
															<definition display-name="Header Value" id="154" multiline="false" name="resrc-headerValue" type="string">
																<description>Header value.</description>
															</definition>
														</template>
														<value/>
													</definition>
												</template>
												<value/>
											</definition>
										</subordinates>
									</group>
								</template>
							</definition>
						</definitions>
					</configuration-values>
				</subscriber-options>
				<publisher-options>
					<configuration-values>
						<definitions>
							<header display-name="Publisher Options"/>
							<group>
								<definition display-name="Publisher Setting" hide="false" id="155" name="pubSetting" type="enum">
									<description>Specify the Publisher Setting.</description>
									<enum-choice display-name="Poll Mode">Poll</enum-choice>
									<enum-choice display-name="Publish Mode">Publish</enum-choice>
									<value>Poll</value>
								</definition>
								<subordinates active-value="Poll">
									<definition display-name="Configure Resource for poll" id="156" instance-separator=" " name="resrc-Poll" type="structured" value-separator="#">
										<value/>
										<description/>
										<template max-count="10" min-count="0">
											<definition display-name="Schema name" id="157" multiline="false" name="resrc-schemaName" type="string">
												<description>Specify the class name of the user resource returned present in application schema.</description>
												<value xml:space="preserve"/>
											</definition>
											<definition display-name="Service Endpoints" id="158" multiline="false" name="resrc-pollurl" type="string">
												<description>Specify the REST URLs for the resource. Mention queriable strings as %s.</description>
												<value xml:space="preserve"/>
											</definition>
											<definition display-name="Method" id="159" multiline="false" name="resrc-pollMethodCall" type="enum">
												<description>HTTP method to be used.</description>
												<enum-choice display-name="GET">0</enum-choice>
												<enum-choice display-name="POST">1</enum-choice>
												<enum-choice display-name="PATCH">2</enum-choice>
												<enum-choice display-name="PUT">3</enum-choice>
												<enum-choice display-name="DELETE">4</enum-choice>
											</definition>
											<definition display-name="Optional Header Fields" id="160" instance-separator=" " name="resrc-PollHeader" type="structured" value-separator=";">
												<description/>
												<template max-count="10" min-count="0">
													<definition display-name="Header Name" id="161" multiline="true" name="resrc-pollHeaderName" type="string">
														<description>Header Name.</description>
													</definition>
													<definition display-name="Header Value" id="162" multiline="true" name="resrc-pollHeaderValue" type="string">
														<description>Header value.</description>
													</definition>
												</template>
												<value/>
											</definition>
											<group>
												<definition display-name="Enable Pagination" hide="false" id="163" name="enablle-pagination" type="enum">
													<description>Enable or disable pagination for a resource.</description>
													<value>paginationDisabled</value>
													<enum-choice display-name="Yes">paginationEnabled</enum-choice>
													<enum-choice display-name="No">paginationDisabled</enum-choice>
												</definition>
												<subordinates active-value="paginationEnabled">
													<group>
														<definition display-name="Pagination Type" hide="false" id="164" name="pagination-type" type="enum">
															<description>Specify pagination method for the resource.</description>
															<value>offset</value>
															<enum-choice display-name="Offset Pagination">offset</enum-choice>
															<enum-choice display-name="Cursor Pagination">curser</enum-choice>
															<enum-choice display-name="Custom">custom</enum-choice>
														</definition>
														<subordinates active-value="offset">
															<definition display-name="Offset" hide="false" id="165" name="resrc-Poll-offset" type="string">
																<description>Specify the start index for the resource</description>
																<value xml:space="preserve">0</value>
															</definition>
															<definition display-name="Page Size" hide="false" id="166" name="resrc-Poll-limit" type="string">
																<description>Specify page size</description>
																<value xml:space="preserve">100</value>
															</definition>
															<definition display-name="Total Count" hide="false" id="167" mandatory="true" name="resrc-Poll-total" type="string">
																<description>Specify the attribute that contains the resource's total count, or enter the total count.</description>
																<value xml:space="preserve"/>
															</definition>
														</subordinates>
														<subordinates active-value="curser">
															<group>
																<definition display-name="Cursor location" hide="false" id="169" name="resrc-Poll-courser-location" type="enum">
																	<description>Location of the cursor</description>
																	<value>header</value>
																	<enum-choice display-name="Response Header">header</enum-choice>
																	<enum-choice display-name="Response Payload">payload</enum-choice>
																</definition>
																<subordinates active-value="header">
																	<definition display-name="Link Header Relation" hide="false" id="170" name="resrc-Poll-courser-link-rel" type="string">
																		<description>Relation in link header</description>
																		<value xml:space="preserve"/>
																	</definition>
																	<definition display-name="Link Header Value" hide="false" id="171" name="resrc-Poll-courser-link-val" type="string">
																		<description>Value of the link header relation</description>
																		<value xml:space="preserve"/>
																	</definition>
																</subordinates>
																<subordinates active-value="payload">
																	<definition display-name="Cursor key" hide="false" id="175" mandatory="true" name="resrc-Poll-curser-nextPageKey" type="string">
																		<description>Attribute in response that contains the cursor.</description>
																		<value xml:space="preserve"/>
																	</definition>
																	<definition display-name="Terminating key" hide="false" id="177" name="resrc-Poll-curser-terminatingKey" type="string">
																		<description>Specify the terminating key.Attribute in response that determines whether or not the next page exists.</description>
																		<value xml:space="preserve"/>
																	</definition>
																	<definition display-name="Terminating value" hide="false" id="178" name="resrc-Poll-curser-terminatingValue" type="string">
																		<description>Specify the terminating value.When terminating key value matches this value, pagination is terminated.</description>
																		<value xml:space="preserve"/>
																	</definition>
																</subordinates>
																<group>
																	<definition display-name="Absolute URL" hide="false" id="168" name="resrc-Poll-absolute-url" type="enum">
																		<description>Is the cursor a complete url?</description>
																		<value>yes</value>
																		<enum-choice display-name="Yes">yes</enum-choice>
																		<enum-choice display-name="No">no</enum-choice>
																	</definition>
																	<subordinates active-value="no">
																		<definition display-name="first Page URL" hide="false" id="168" name="resrc-Poll-firstPageUrl" type="string">
																			<description>First Page URL</description>
																			<value xml:space="preserve"/>
																		</definition>
																	</subordinates>
																</group>
																<definition display-name="Page Size" hide="false" id="173" name="resrc-Poll-courser-page-size" type="string">
																	<description>Page size.</description>
																	<value xml:space="preserve">100</value>
																</definition>
															</group>
														</subordinates>
														<subordinates active-value="custom">
															<definition display-name="Java Class" hide="false" id="165" mandatory="true" name="resrc-Poll-custom-class" type="string">
																<description>Custom java class implementing Paginator interface</description>
															</definition>
															<definition display-name="Init Parameters" hide="false" id="166" name="resrc-Poll-custom-init" type="string">
																<description>Provide init parameters as string</description>
															</definition>
														</subordinates>
													</group>
												</subordinates>
												<subordinates active-value="paginationDisabled"/>
											</group>
										</template>
									</definition>
									<!--definition display-name="Search Results to Synchronize on First Startup" id="163" name="pollBegin" type="enum"><description>The first time this driver starts, it performs the defined search on the application. This setting defines whether the initial search results are synchronized, or only subsequent changes are synchronized.</description><enum-choice display-name="Synchronize only subsequent changes">1</enum-choice><enum-choice display-name="Synchronize everything">2</enum-choice><value>1</value></definition-->
									<definition display-name="Polling interval in minutes" id="164" name="pollingInterval" type="string">
										<description>Specify the polling interval in minutes. </description>
										<value xml:space="preserve">1</value>
									</definition>
								</subordinates>
								<subordinates active-value="Publish">
									<definition display-name="Listening IP address and port" hide="false" id="165" name="pubHostPort" type="string">
										<description>Specify the IP address of the server where this driver is installed and the port that this driver listens on. You can specify 127.0.0.1 if there is only one network card installed in the server. Choose an unused port number on your server. For example: 127.0.0.1:18180. The driver listens on this address for incoming requests, processes the requests, and returns a result.</description>
										<value xml:space="preserve"/>
									</definition>
									<group>
										<definition display-name="Authentication Method" hide="false" id="166" name="pubAuthMethod" type="enum">
											<description>Specify the authentication ID for the REST server or Web Service if Basic Authorization (on the HTTP header) is used.</description>
											<enum-choice display-name="Anonymous">Anonymous</enum-choice>
											<enum-choice display-name="Basic">Basic</enum-choice>
											<value>Basic</value>
										</definition>
										<subordinates active-value="Basic">
											<definition display-name="Authentication ID" hide="false" id="167" name="pubAuthBasicID" type="string">
												<description>Specify the authentication ID for Basic Authorization (on the HTTP header) is used.</description>
												<value xml:space="preserve"/>
											</definition>
											<definition display-name="Authentication Password" hide="false" id="168" is-sensitive="true" name="pubAuthBasicPwd" type="password-ref">
												<description>Specify the authentication password for Basic Authorization (on the HTTP header) is used.</description>
												<value xml:space="preserve">subAuthPwd-1</value>
												<pwd-value removePwd="false"/>
											</definition>
										</subordinates>
									</group>
									<header display-name="Other Options" id="180"/>
									<definition display-name="KMO name" id="172" name="KMOName" type="string">
										<description>When this server is configured to accept HTTPS connections, this is the KMO name in eDirectory. The KMO name is the name before the ' - ' in the RDN. Leave this field blank when a keystore file is used (see below) or when HTTPS connections are not used.</description>
										<value xml:space="preserve"/>
									</definition>
									<definition display-name="Keystore file" id="173" name="pubKeystoreFile" type="string">
										<description>When this server is configured to accept HTTPS connections, this is the path and the name of the keystore file. For example: C:\security\keystore. Leave this field blank when a KMO name is used (see above) or when HTTPS connections are not used.</description>
										<value xml:space="preserve"/>
									</definition>
									<definition display-name="Keystore password" id="174" name="pubKeystorePassword" type="password-ref">
										<description>When this server is configured to accept HTTPS connections, this is the keystore file password. Leave this field blank when a KMO name is used (see above) or when HTTPS connections are not used.</description>
										<value xml:space="preserve">sub-password</value>
									</definition>
									<definition display-name="Server key alias" id="175" name="pubServerKeyAlias" type="string">
										<description>When this server is configured to accept HTTPS connections, this is the key alias. Leave this field blank when a KMO name is used (see above) or when HTTPS connections are not used.</description>
										<value xml:space="preserve"/>
									</definition>
									<definition display-name="Server key password" id="176" name="pubServerKeyPassword" type="password-ref">
										<description>When this server is configured to accept HTTPS connections, this is the key alias password (not the keystore password). Leave this field blank when a KMO name is used (see above) or when HTTPS connections are not used.</description>
										<value xml:space="preserve">sub-password</value>
									</definition>
									<definition display-name="Require mutual authentication" id="177" name="pubRequireMutualAuth" type="enum">
										<description>When using SSL, it is common to do only server authentication. However, if you want to force both client and server to present certificates during the handshake process, select Required.</description>
										<enum-choice display-name="Required">true</enum-choice>
										<enum-choice display-name="Not required">false</enum-choice>
										<value>false</value>
									</definition>
								</subordinates>
								<definition display-name="Heartbeat interval in minutes" id="178" name="heartbeat" type="string">
									<description>Specify the heartbeat interval in minutes. Leave this field blank to turn off the heartbeat.</description>
									<value xml:space="preserve">1</value>
								</definition>
							</group>
						</definitions>
					</configuration-values>
				</publisher-options>
			</driver-config>
		</shim-config-info-xml>
		<global-engine-values>
			<configuration-values>
				<definitions>
					<definition display-name="Subscriber channel retry interval in seconds" display-name-ref="ecnm_rint" name="dirxml.engine.retry-interval" range-lo="1" type="integer">
						<description description-ref="ecds_rint">The subscriber channel retry interval controls how frequently the DirXML Engine will retry the processing of a cached transaction after the application shim's Subscriber object returns a retry status.</description>
						<value>30</value>
					</definition>
					<definition display-name="Qualified form for DN-syntax attribute values" display-name-ref="ecnm_dnvf" name="dirxml.engine.qualified-dn-values" type="boolean">
						<description description-ref="ecds_dnvf">The qualified form for DN-syntax attribute values controls whether values for DN-syntax attribute values are presented in unqualified slash form or qualified slash form. A "true" setting means the values are presented in qualified form.</description>
						<value>false</value>
					</definition>
					<definition display-name="Qualified form for rename events" display-name-ref="ecnm_refm" name="dirxml.engine.qualified-rename-values" type="boolean">
						<description description-ref="ecds_refm">The qualified form for rename events controls whether the new-name portion of rename events coming from the Identity Vault are presented to the Subscriber channel with type qualifier(s) (e.g. CN=). A "true" setting means the names are presented in qualified form.</description>
						<value>false</value>
					</definition>
					<definition display-name="Maximum eDirectory replication wait time in seconds" display-name-ref="ecnm_mrpw" name="dirxml.engine.max-replication-wait" range-lo="1" type="integer">
						<description description-ref="ecds_mrpw">The maximum eDirectory replication wait time controls the maximum time that the DirXML Engine will wait for a particular change to replicate between the local replica and a remote replica. This only affects operations where the DirXML Engine is required to contact a remote eDirectory server in the same tree to perform an operation and may need to wait until some change has replicated to or from the remote server before the operation can be completed (e.g. object moves when the DirXML server does not hold the master replica of the moved object ;file system rights operations for Users created from a template.)</description>
						<value>180</value>
					</definition>
					<definition display-name="Use non-compliant backwards-compatible mode for XSLT" display-name-ref="ecnm_xbcm" name="dirxml.engine.xslt-bc-mode" type="boolean">
						<description description-ref="ecds_xbcm">This control sets the XSLT processor used by the DirXML Engine to a backwards-compatible mode. The backwards-compatible mode causes the XSLT processor to use one or more behaviors that are not XPath 1.0 and/or XSLT 1.0 standards-compliant. This is done in the interest of backwards-compatiblity with existing DirXML stylesheets that depend on the non-standard behavior(s). 
 
 In particular: 
 
 The behavior of the XPath "!=" operator when one operand is a node-set and the other operand is other than a node-set is incorrect in DirXML releases up to and including DirXML 2.0 (Novell Identity Manager 2.0). This behavior has been corrected; however, the corrected behavior is disabled by default through this control in favor of backwards-compatibility with existing DirXML stylesheets.</description>
						<value>true</value>
					</definition>
					<definition display-name="Maximum application objects to migrate at once" display-name-ref="ecnm_mxappm" name="dirxml.engine.max-migrate-app-count" range-lo="1" type="integer">
						<description description-ref="ecds_mxappm">This control is used to limit the number of application objects that the DirXML Engine will request from an application during a single query that is performed as part of a "migrate objects from application" operation. 
 
 If "java.lang.OutOfMemoryError" errors are encountered during a migrate from application operation then this number should be set lower than the default. 
 
 Note that this control does not limit the number of application objects that can be migrated; it merely limits the "batch size".</description>
						<value>50</value>
					</definition>
					<definition display-name="Set creatorsName on objects created in Identity Vault" display-name-ref="ecnm_scrnm" name="dirxml.engine.set-creators-name" type="boolean">
						<description description-ref="ecds_scrnm">This control is used by the DirXML Engine to determine if the creatorsName attribute should be set to the DN of this driver on all objects created in the Identity Vault by this driver.
 
 Setting the creatorsName attribute allows for easily identifying objects created by this driver, but also carries a performance penalty. If not set, the creatorsName attribute will default to the DN of the NCP Server object that is hosting the driver.</description>
						<value>false</value>
					</definition>
					<definition display-name="Write pending associations" display-name-ref="ecnm_pass" name="dirxml.engine.use-pending-association" type="boolean">
						<description description-ref="ecds_pass">This control determines whether the DirXML Engine will write a pending association on an object during subscriber channel processing.
 
 Writing a pending association confers little or no benefit but does incur a performance penalty. Nevertheless, the option exists to turn it on for backward compatibility.</description>
						<value>false</value>
					</definition>
					<definition display-name="Use password event values" display-name-ref="ecnm_pevvl" name="dirxml.engine.use-password-event-values" type="boolean">
						<description description-ref="ecds_pevvl">This control determines the source of the value reported for the nspmDistributionPassword attribute for subscriber channel add and modify events.
 
 Setting the control to false means that the current value of nspmDistributionPassword is obtained and reported as the value of the attribute event. This means that only the current password value is available. This is the default behavior.
 
 Setting the control to true means that the value recorded with the eDirectory event will be decrypted and reported as the value of the attribute event. This means that both the old password value (if it exists) and the replacement password value at the time of the event are available. This is useful for synchronizing passwords to certain applications that require the old password to enable setting a new password.</description>
						<value>false</value>
					</definition>
					<definition display-name="Enable password synchronization status reporting" display-name-ref="ecnm_pss" name="dirxml.engine.pwd-sync-status" type="boolean">
						<description description-ref="ecds_pss">This control determines whether the DirXML Engine will report the status of subscriber channel password change events. 
 
 Reporting the status of subscriber channel password change events allows applications such as the Identity Manager User Application to monitor the synchronization progress of a password change that should be synchronized to the connected application.</description>
						<value>true</value>
					</definition>
					<definition display-name="Combine values from template object with those from add operation" display-name-ref="ecnm_ctv" name="dirxml.engine.combine-template-values" type="boolean">
						<description description-ref="ecds_ctv">This control determines how the DirXML Engine will use values from a template object when the template is used to create objects in the Identity Vault. Setting the control to true causes multi-valued attribute values from the template to be used in addition to those values for the same attribute that are  specified in the add operation. Setting the control to false causes the value(s) from the template to be ignored if there are values for the same attribute specified in the add operation.</description>
						<value>true</value>
					</definition>
					<definition display-name="Allow event loopback from publisher to subscriber channel" display-name-ref="ecnm_ael" name="dirxml.engine.allow-event-loopback" type="boolean">
						<description description-ref="ecds_ael">This control determines whether the DirXML Engine will allow an event to loopback from the publisher channel of a driver to the subscriber channel of the same driver. Setting the control to false means that the loopback of the event from the publisher to the subscriber channel will not be allowed. Setting the control to true means that events would flow from the publisher channel to the subscriber channel of the same driver.  </description>
						<value>false</value>
					</definition>
					<definition display-name="Revert to calculated membership value behavior" display-name-ref="ecnm_cavl" name="dirxml.engine.use-calculated-values" type="boolean">
						<description description-ref="ecds_cavl">Prior to Identity Manager 3.6 the DirXML Engine retrieved "calculated" values for the attributes "Member" and "Group Membership". The Engine now retrieves static values. This behavior is more generally useful and makes synchronizing Nested Groups possible. Setting this control to true reverts to the pre-3.6 behavior. 
 
 It is possible even with the post-3.6 default behavior to read the calculated values for "Member" and "Group Membership" by using the special attribute names "[pseudo].Member" and "[pseudo].Group Membership".</description>
						<value>false</value>
					</definition>
					<definition display-name="Maximum time to wait for driver shutdown  in seconds" display-name-ref="ecnm_mdst" name="dirxml.engine.max-driver-shutdown-timeout" range-hi="3600" range-lo="5" type="integer">
						<description description-ref="ecds_mdst">This control determines the maximum time in seconds for which the DirXML Engine will wait for the drivers publisher channel to shutdown. If the driver does not shutdown within the provided time value, then the driver will be terminated by the DirXML Engine.</description>
						<value>60</value>
					</definition>
					<definition display-name="Regular Expression escape meta-characters" display-name-ref="ecnm_reecn" name="dirxml.engine.reg-ex-escape-chars" type="string">
						<description description-ref="ecds_reecd">This control determines the meta-characters that will be escaped while evaluating regular expressions. If a meta-char is not present in control value then it will not be escaped during local variable expansion containing a regular expression. 
 
 To escape all the regular expression meta-characters, "\,$,^,.,?,*,+,[,],(,),|" should be added as the value. 
 
 If a meta-character need not be escaped, then remove it from the control value. 
 
 The control value should be a valid comma(,) separated list, else errors may be encountered during policy evaluation.</description>
						<value xml:space="preserve">$</value>
					</definition>
					<definition display-name="Retry of Out of Band events" display-name-ref="ecnm_robe" name="dirxml.engine.retry-outofband-event" type="boolean">
						<description description-ref="ecds_robe">This control determines whether the DirXML Engine will retry an out of band event when the status is a RETRY. Setting the control to false means that the Engine will not retry the Out of Band event on a RETRY status. Setting the control to true means that the Engine will retry the Out of band event on a RETRY status.</description>
						<value>false</value>
					</definition>
					<definition display-name="Use Rhino ECMAScript engine" display-name-ref="ecnm_uree" name="dirxml.engine.rhino-ecma-engine" type="boolean">
						<description description-ref="ecds_uree">This control determines whether DirXML Engine will use the Rhino ECMAScript engine. DirXML Engine uses Rhino as the default ECMAScript engine.</description>
						<value>true</value>
					</definition>
					<definition display-name="Enable Subscriber Service Channel" display-name-ref="ecnm_essc" name="dirxml.engine.enable-subsvc-channel" type="boolean">
						<description description-ref="ecds_essc">This control determines whether the DirXML Engine will send the out of band queries in subscriber service channel. This is applicable only if the driver supports subscriber service channel.If this is set to true, Engine will send the out of band queries in subscriber service channel.</description>
						<value>false</value>
					</definition>
					<definition display-name="Ignore Entitlement Changes of other drivers" display-name-ref="ecnm_ierc" name="dirxml.engine.ignore-entitlement-change" type="boolean">
						<description description-ref="ecds_ierc">This control is used by the DirXML Engine to either ignore or process the Entitlement Changes of other drivers. If this control is set to true, the Entitlement changes of other drivers will be ignored by this driver. If this contorl is set to false, the Entitlement changes of other drivers will be cached and processed by this driver.</description>
						<value>true</value>
					</definition>
					<definition display-name="Allow Entitlement event loopback from cprs to subscriber channel" display-name-ref="ecnm_acel" name="dirxml.engine.allow-cprs-event-loopback" type="boolean">
						<description description-ref="ecds_acel">This control determines whether the DirXML Engine will allow an entitlement event generated by cprs assignment to loopback to the subscriber channel of the driver. Setting the control to false means that the loopback of the event from cprs to the subscriber channel will not be allowed.Setting the control to true means that events would flow from the cprs to the subscriber channelof the same driver. </description>
						<value>false</value>
					</definition>
					<definition display-name="Interpret Time as Signed Integer" display-name-ref="ecnm_itsi" name="dirxml.engine.interpret-time-signed" type="boolean">
						<description description-ref="ecds_itsi">This control determines whether the DirXML Engine will interpret a time value as signed or unsigned integer. If this is set to true, Engine will support time values from 1902 to 2037. If this is set to false, Engine will support time values from 1970 to 2106. </description>
						<value>true</value>
					</definition>
					<definition display-name="Optimize Modify on Publisher Merge" display-name-ref="ecnm_omom" name="dirxml.engine.optimize-modify-merge" type="boolean">
						<description description-ref="ecds_omom">This control determines whether the DirXML Engine will perform optimize modify on publisher merge. If this is set to true, Engine will perform optimize modify on Publisher Merge. </description>
						<value>true</value>
					</definition>
					<definition display-name="Remove Manual/Migrate Associations" display-name-ref="ecnm_rmma" name="dirxml.engine.remove-manual-migrate-assoc" type="boolean">
						<description description-ref="ecds_rmma">This control determines whether the DirXML Engine will remove the manual/migrate association states. If this is set to true, Engine will remove the manual/migrate association </description>
						<value>true</value>
					</definition>
					<definition display-name="Retrieve Application Schema" display-name-ref="ecnm_rasc" name="dirxml.engine.retrieve-application-schema" type="boolean">
						<description description-ref="ecds_rasc">This control determines whether the DirXML Engine will query for application schema. For some drivers like generic null where application does not have any schema, this control can be set to false so that Engine does not query for application schema.</description>
						<value>true</value>
					</definition>
				</definitions>
			</configuration-values>
		</global-engine-values>
		<global-config-values>
			<configuration-values>
				<definitions>
					<definition display-name="Association" name="drv.association" type="string">
						<value/>
						<description>Select one of the attributes as association.</description>
					</definition>
				</definitions>
			</configuration-values>
		</global-config-values>
		<named-password-query display-name="Subscriber Authentication Password" name="subAuthPwd-1"/>
		<named-password-query display-name="Publisher Authentication Password" name="pubAuthPwd"/>
		<application-schema/>
		<pkg-initial-states>
			<pkg-initial-state package-id="DQ3ZPHXF_201505121302320165" pkg-assoc-id="I53KDN51_201505121304050419" version="1.0.1.20180613142919">PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48ZHMtb2JqZWN0IGRzLW9iamVjdC1jbGFzcz0iRGlyWE1MLVJ1bGUiIGRzLW9iamVjdC1uYW1lPSJORVRRUkVTVERDRkctcHViLWN0cC1Nb2RpZnl0b1JlbmFtZSIgbmFtZT0iTkVUUVJFU1REQ0ZHLXB1Yi1jdHAtTW9kaWZ5dG9SZW5hbWUiPgoJPGRzLWF0dHJpYnV0ZXM+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9IlhtbERhdGEiPgoJCQk8ZHMtdmFsdWU+CgkJCQk8cG9saWN5PgoJCQkJCTxydWxlPgoJCQkJCQk8ZGVzY3JpcHRpb24+Q29udmVydCBtb2RpZnkgdG8gcmVuYW1lPC9kZXNjcmlwdGlvbj4KCQkJCQkJPGNvbmRpdGlvbnM+CgkJCQkJCQk8YW5kPgoJCQkJCQkJCTxpZi1vcGVyYXRpb24gb3A9ImVxdWFsIj5tb2RpZnk8L2lmLW9wZXJhdGlvbj4KCQkJCQkJCQk8aWYtb3AtYXR0ciBuYW1lPSJDTiIgb3A9ImNoYW5naW5nIi8+CgkJCQkJCQk8L2FuZD4KCQkJCQkJPC9jb25kaXRpb25zPgoJCQkJCQk8YWN0aW9ucz4KCQkJCQkJCTxkby1hcHBlbmQteG1sLWVsZW1lbnQgZXhwcmVzc2lvbj0iLi4iIG5hbWU9InJlbmFtZSIvPgoJCQkJCQkJPGRvLWFwcGVuZC14bWwtZWxlbWVudCBleHByZXNzaW9uPSIuLi9yZW5hbWVbbGFzdCgpXSIgbmFtZT0iYXNzb2NpYXRpb24iLz4KCQkJCQkJCTxkby1hcHBlbmQteG1sLXRleHQgZXhwcmVzc2lvbj0iLi4vcmVuYW1lW2xhc3QoKV0vYXNzb2NpYXRpb24iPgoJCQkJCQkJCTxhcmctc3RyaW5nPgoJCQkJCQkJCQk8dG9rZW4tYXNzb2NpYXRpb24vPgoJCQkJCQkJCTwvYXJnLXN0cmluZz4KCQkJCQkJCTwvZG8tYXBwZW5kLXhtbC10ZXh0PgoJCQkJCQkJPGRvLXNldC14bWwtYXR0ciBleHByZXNzaW9uPSIuLi9yZW5hbWVbbGFzdCgpXSIgbmFtZT0iZXZlbnQtaWQiPgoJCQkJCQkJCTxhcmctc3RyaW5nPgoJCQkJCQkJCQk8dG9rZW4teHBhdGggZXhwcmVzc2lvbj0iJGN1cnJlbnQtb3AvQGV2ZW50LWlkIi8+CgkJCQkJCQkJPC9hcmctc3RyaW5nPgoJCQkJCQkJPC9kby1zZXQteG1sLWF0dHI+CgkJCQkJCQk8ZG8tc2V0LXhtbC1hdHRyIGV4cHJlc3Npb249Ii4uL3JlbmFtZVtsYXN0KCldIiBuYW1lPSJzcmMtZG4iPgoJCQkJCQkJCTxhcmctc3RyaW5nPgoJCQkJCQkJCQk8dG9rZW4teHBhdGggZXhwcmVzc2lvbj0iJGN1cnJlbnQtb3AvQHNyYy1kbiIvPgoJCQkJCQkJCTwvYXJnLXN0cmluZz4KCQkJCQkJCTwvZG8tc2V0LXhtbC1hdHRyPgoJCQkJCQkJPGRvLWFwcGVuZC14bWwtZWxlbWVudCBleHByZXNzaW9uPSIuLi9yZW5hbWVbbGFzdCgpXSIgbmFtZT0ibmV3LW5hbWUiLz4KCQkJCQkJCTxkby1hcHBlbmQteG1sLXRleHQgZXhwcmVzc2lvbj0iLi4vcmVuYW1lW2xhc3QoKV0vbmV3LW5hbWUiPgoJCQkJCQkJCTxhcmctc3RyaW5nPgoJCQkJCQkJCQk8dG9rZW4teHBhdGggZXhwcmVzc2lvbj0iJGN1cnJlbnQtb3AvbW9kaWZ5LWF0dHJbQGF0dHItbmFtZT0nQ04nXS9hZGQtdmFsdWUvdmFsdWUvdGV4dCgpIi8+CgkJCQkJCQkJPC9hcmctc3RyaW5nPgoJCQkJCQkJPC9kby1hcHBlbmQteG1sLXRleHQ+CgkJCQkJCQk8ZG8tc3RyaXAtb3AtYXR0ciBuYW1lPSJDTiIvPgoJCQkJCQk8L2FjdGlvbnM+CgkJCQkJPC9ydWxlPgoJCQkJPC9wb2xpY3k+CgkJCTwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9ImlkbS1pbnN0YWxsYXRpb25kaXJlY3RpdmUiPgoJCQk8ZHMtdmFsdWU+UEQ5NGJXd2dkbVZ5YzJsdmJqMGlNUzR3SWlCbGJtTnZaR2x1WnowaVZWUkdMVGdpUHo0OGFXNXpkR0ZzYkdGMGFXOXVMV1JwY21WamRHbDJaVDRLQ1R4d2JHRmpaVzFsYm5RZ2JHOWpZWFJwYjI0OUluQjFZbXhwYzJobGNpSXZQZ29KUEdSekxXRjBkSEpwWW5WMFpYTXZQZ29KUEhCdmJHbGplUzFzYVc1cllXZGxQZ29KQ1R4d2IyeHBZM2t0YzJWMElHTm9ZVzV1Wld3OUluQjFZbXhwYzJobGNpSWdibUZ0WlQwaVkyOXRiV0Z1WkNJZ2IzSmtaWEk5SW5kbGFXZG9kQ0lnZG1Gc2RXVTlJalV3TlNJdlBnb0pQQzl3YjJ4cFkza3RiR2x1YTJGblpUNEtQQzlwYm5OMFlXeHNZWFJwYjI0dFpHbHlaV04wYVhabFBnPT08L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0tZGlyZWN0aXZlY2hlY2tzdW0iPgoJCQk8ZHMtdmFsdWU+Mzk4NzI0NjkwNjwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9ImlkbS1wYWNrYWdlYXNzb2NndWlkIj4KCQkJPGRzLXZhbHVlPkk1M0tETjUxXzIwMTUwNTEyMTMwNDA1MDQxOTwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9ImlkbS1wYWNrYWdlZ3VpZCI+CgkJCTxkcy12YWx1ZT5EUTNaUEhYRl8yMDE1MDUxMjEzMDIzMjAxNjU8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0tY29udGVudGNoZWNrc3VtIj4KCQkJPGRzLXZhbHVlPjIwOTEyNzg3MTI8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJPC9kcy1hdHRyaWJ1dGVzPgo8L2RzLW9iamVjdD4=</pkg-initial-state>
			<pkg-initial-state package-id="DQ3ZPHXF_201505121302320165" pkg-assoc-id="H7WTLCEF_201505121304050581" version="1.0.1.20180613142919">PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48ZHMtb2JqZWN0IGRzLW9iamVjdC1jbGFzcz0iRGlyWE1MLVJ1bGUiIGRzLW9iamVjdC1uYW1lPSJORVRRUkVTVERDRkctcHViLXBwIiBuYW1lPSJORVRRUkVTVERDRkctcHViLXBwIj4KCTxkcy1hdHRyaWJ1dGVzPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJYbWxEYXRhIj4KCQkJPGRzLXZhbHVlPgoJCQkJPHBvbGljeT4KCQkJCQk8cnVsZT4KCQkJCQkJPGRlc2NyaXB0aW9uPlVzZXIgUGxhY2VtZW50IFBvbGljeTwvZGVzY3JpcHRpb24+CgkJCQkJCTxjb25kaXRpb25zPgoJCQkJCQkJPG9yPgoJCQkJCQkJCTxpZi1jbGFzcy1uYW1lIG9wPSJlcXVhbCI+VXNlcjwvaWYtY2xhc3MtbmFtZT4KCQkJCQkJCTwvb3I+CgkJCQkJCTwvY29uZGl0aW9ucz4KCQkJCQkJPGFjdGlvbnM+CgkJCQkJCQk8ZG8tc2V0LWxvY2FsLXZhcmlhYmxlIG5hbWU9ImRuIj4KCQkJCQkJCQk8YXJnLXN0cmluZz4KCQkJCQkJCQkJPHRva2VuLWdsb2JhbC12YXJpYWJsZSBuYW1lPSJpZHYuZGl0LmRhdGEudXNlcnMiLz4KCQkJCQkJCQkJPHRva2VuLXRleHQ+XDwvdG9rZW4tdGV4dD4KCQkJCQkJCQkJPHRva2VuLWF0dHIgbmFtZT0iQ04iLz4KCQkJCQkJCQk8L2FyZy1zdHJpbmc+CgkJCQkJCQk8L2RvLXNldC1sb2NhbC12YXJpYWJsZT4KCQkJCQkJPC9hY3Rpb25zPgoJCQkJCTwvcnVsZT4KCQkJCQk8cnVsZT4KCQkJCQkJPGRlc2NyaXB0aW9uPkdyb3VwIFBsYWNlbWVudCBQb2xpY3k8L2Rlc2NyaXB0aW9uPgoJCQkJCQk8Y29uZGl0aW9ucz4KCQkJCQkJCTxhbmQ+CgkJCQkJCQkJPGlmLWNsYXNzLW5hbWUgbW9kZT0ibm9jYXNlIiBvcD0iZXF1YWwiPkdyb3VwPC9pZi1jbGFzcy1uYW1lPgoJCQkJCQkJPC9hbmQ+CgkJCQkJCTwvY29uZGl0aW9ucz4KCQkJCQkJPGFjdGlvbnM+CgkJCQkJCQk8ZG8tc2V0LWxvY2FsLXZhcmlhYmxlIG5hbWU9ImRuIiBzY29wZT0icG9saWN5Ij4KCQkJCQkJCQk8YXJnLXN0cmluZz4KCQkJCQkJCQkJPHRva2VuLWdsb2JhbC12YXJpYWJsZSBuYW1lPSJpZHYuZGl0LmRhdGEuZ3JvdXBzIi8+CgkJCQkJCQkJCTx0b2tlbi10ZXh0Plw8L3Rva2VuLXRleHQ+CgkJCQkJCQkJCTx0b2tlbi1hdHRyIG5hbWU9IkNOIi8+CgkJCQkJCQkJPC9hcmctc3RyaW5nPgoJCQkJCQkJPC9kby1zZXQtbG9jYWwtdmFyaWFibGU+CgkJCQkJCTwvYWN0aW9ucz4KCQkJCQk8L3J1bGU+CgkJCQkJPHJ1bGU+CgkJCQkJCTxkZXNjcmlwdGlvbj5TZXQgRGVzdGluYXRpb24gRE48L2Rlc2NyaXB0aW9uPgoJCQkJCQk8Y29uZGl0aW9ucz4KCQkJCQkJCTxhbmQvPgoJCQkJCQk8L2NvbmRpdGlvbnM+CgkJCQkJCTxhY3Rpb25zPgoJCQkJCQkJPGRvLXNldC1vcC1kZXN0LWRuPgoJCQkJCQkJCTxhcmctZG4+CgkJCQkJCQkJCTx0b2tlbi1sb2NhbC12YXJpYWJsZSBuYW1lPSJkbiIvPgoJCQkJCQkJCTwvYXJnLWRuPgoJCQkJCQkJPC9kby1zZXQtb3AtZGVzdC1kbj4KCQkJCQkJPC9hY3Rpb25zPgoJCQkJCTwvcnVsZT4KCQkJCTwvcG9saWN5PgoJCQk8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0taW5zdGFsbGF0aW9uZGlyZWN0aXZlIj4KCQkJPGRzLXZhbHVlPlBEOTRiV3dnZG1WeWMybHZiajBpTVM0d0lpQmxibU52WkdsdVp6MGlWVlJHTFRnaVB6NDhhVzV6ZEdGc2JHRjBhVzl1TFdScGNtVmpkR2wyWlQ0S0NUeHdiR0ZqWlcxbGJuUWdiRzlqWVhScGIyNDlJbkIxWW14cGMyaGxjaUl2UGdvSlBHUnpMV0YwZEhKcFluVjBaWE12UGdvSlBIQnZiR2xqZVMxc2FXNXJZV2RsUGdvSkNUeHdiMnhwWTNrdGMyVjBJR05vWVc1dVpXdzlJbkIxWW14cGMyaGxjaUlnYm1GdFpUMGljR3hoWTJWdFpXNTBJaUJ2Y21SbGNqMGlkMlZwWjJoMElpQjJZV3gxWlQwaU5UQTFJaTgrQ2drOEwzQnZiR2xqZVMxc2FXNXJZV2RsUGdvOEwybHVjM1JoYkd4aGRHbHZiaTFrYVhKbFkzUnBkbVUrPC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iaWRtLWRpcmVjdGl2ZWNoZWNrc3VtIj4KCQkJPGRzLXZhbHVlPjE1NTYwMjg1Mjk8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0tcGFja2FnZWFzc29jZ3VpZCI+CgkJCTxkcy12YWx1ZT5IN1dUTENFRl8yMDE1MDUxMjEzMDQwNTA1ODE8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0tcGFja2FnZWd1aWQiPgoJCQk8ZHMtdmFsdWU+RFEzWlBIWEZfMjAxNTA1MTIxMzAyMzIwMTY1PC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iaWRtLWNvbnRlbnRjaGVja3N1bSI+CgkJCTxkcy12YWx1ZT4zMTY4MDA1NDE5PC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCTwvZHMtYXR0cmlidXRlcz4KPC9kcy1vYmplY3Q+</pkg-initial-state>
			<pkg-initial-state package-id="DQ3ZPHXF_201505121302320165" pkg-assoc-id="RKSNLX6P_201505121315370584" version="1.0.1.20180613142919">PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48ZHMtb2JqZWN0IGRzLW9iamVjdC1jbGFzcz0iRGlyWE1MLVJ1bGUiIGRzLW9iamVjdC1uYW1lPSJORVRRUkVTVERDRkctcHViLW1wIiBuYW1lPSJORVRRUkVTVERDRkctcHViLW1wIj4KCTxkcy1hdHRyaWJ1dGVzPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJYbWxEYXRhIj4KCQkJPGRzLXZhbHVlPgoJCQkJPHBvbGljeT4KCQkJCQk8cnVsZT4KCQkJCQkJPGRlc2NyaXB0aW9uPlVzZXIgbWF0Y2ggb24gQ048L2Rlc2NyaXB0aW9uPgoJCQkJCQk8Y29uZGl0aW9ucz4KCQkJCQkJCTxhbmQ+CgkJCQkJCQkJPGlmLWNsYXNzLW5hbWUgbW9kZT0ibm9jYXNlIiBvcD0iZXF1YWwiPlVzZXI8L2lmLWNsYXNzLW5hbWU+CgkJCQkJCQk8L2FuZD4KCQkJCQkJPC9jb25kaXRpb25zPgoJCQkJCQk8YWN0aW9ucz4KCQkJCQkJCTxkby1maW5kLW1hdGNoaW5nLW9iamVjdCBzY29wZT0ic3VidHJlZSI+CgkJCQkJCQkJPGFyZy1kbj4KCQkJCQkJCQkJPHRva2VuLWdsb2JhbC12YXJpYWJsZSBuYW1lPSJpZHYuZGl0LmRhdGEudXNlcnMiLz4KCQkJCQkJCQk8L2FyZy1kbj4KCQkJCQkJCQk8YXJnLW1hdGNoLWF0dHIgbmFtZT0iQ04iLz4KCQkJCQkJCTwvZG8tZmluZC1tYXRjaGluZy1vYmplY3Q+CgkJCQkJCTwvYWN0aW9ucz4KCQkJCQk8L3J1bGU+CgkJCQkJPHJ1bGU+CgkJCQkJCTxkZXNjcmlwdGlvbj5Hcm91cCBtYXRjaCBvbiBDTjwvZGVzY3JpcHRpb24+CgkJCQkJCTxjb25kaXRpb25zPgoJCQkJCQkJPGFuZD4KCQkJCQkJCQk8aWYtY2xhc3MtbmFtZSBtb2RlPSJub2Nhc2UiIG9wPSJlcXVhbCI+R3JvdXA8L2lmLWNsYXNzLW5hbWU+CgkJCQkJCQk8L2FuZD4KCQkJCQkJPC9jb25kaXRpb25zPgoJCQkJCQk8YWN0aW9ucz4KCQkJCQkJCTxkby1maW5kLW1hdGNoaW5nLW9iamVjdCBzY29wZT0ic3VidHJlZSI+CgkJCQkJCQkJPGFyZy1kbj4KCQkJCQkJCQkJPHRva2VuLWdsb2JhbC12YXJpYWJsZSBuYW1lPSJpZHYuZGl0LmRhdGEuZ3JvdXBzIi8+CgkJCQkJCQkJPC9hcmctZG4+CgkJCQkJCQkJPGFyZy1tYXRjaC1hdHRyIG5hbWU9IkNOIi8+CgkJCQkJCQk8L2RvLWZpbmQtbWF0Y2hpbmctb2JqZWN0PgoJCQkJCQk8L2FjdGlvbnM+CgkJCQkJPC9ydWxlPgoJCQkJPC9wb2xpY3k+CgkJCTwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9ImlkbS1pbnN0YWxsYXRpb25kaXJlY3RpdmUiPgoJCQk8ZHMtdmFsdWU+UEQ5NGJXd2dkbVZ5YzJsdmJqMGlNUzR3SWlCbGJtTnZaR2x1WnowaVZWUkdMVGdpUHo0OGFXNXpkR0ZzYkdGMGFXOXVMV1JwY21WamRHbDJaVDRLQ1R4d2JHRmpaVzFsYm5RZ2JHOWpZWFJwYjI0OUluQjFZbXhwYzJobGNpSXZQZ29KUEdSekxXRjBkSEpwWW5WMFpYTXZQZ29KUEhCdmJHbGplUzFzYVc1cllXZGxQZ29KQ1R4d2IyeHBZM2t0YzJWMElHTm9ZVzV1Wld3OUluQjFZbXhwYzJobGNpSWdibUZ0WlQwaWJXRjBZMmhwYm1jaUlHOXlaR1Z5UFNKWFpXbG5hSFFpSUhaaGJIVmxQU0kxTURBaUx6NEtDVHd2Y0c5c2FXTjVMV3hwYm10aFoyVStDand2YVc1emRHRnNiR0YwYVc5dUxXUnBjbVZqZEdsMlpUND08L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0tZGlyZWN0aXZlY2hlY2tzdW0iPgoJCQk8ZHMtdmFsdWU+MTYwOTE5MDgyPC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iaWRtLXBhY2thZ2Vhc3NvY2d1aWQiPgoJCQk8ZHMtdmFsdWU+UktTTkxYNlBfMjAxNTA1MTIxMzE1MzcwNTg0PC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iaWRtLXBhY2thZ2VndWlkIj4KCQkJPGRzLXZhbHVlPkRRM1pQSFhGXzIwMTUwNTEyMTMwMjMyMDE2NTwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9ImlkbS1jb250ZW50Y2hlY2tzdW0iPgoJCQk8ZHMtdmFsdWU+MjkyMjIwMTU2NjwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+Cgk8L2RzLWF0dHJpYnV0ZXM+CjwvZHMtb2JqZWN0Pg==</pkg-initial-state>
			<pkg-initial-state package-id="DQ3ZPHXF_201505121302320165" pkg-assoc-id="MUXK9PEA_201507011237170385" version="1.0.1.20180613142919">PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48ZHMtb2JqZWN0IGRzLW9iamVjdC1jbGFzcz0iRGlyWE1MLVJ1bGUiIGRzLW9iamVjdC1uYW1lPSJORVRRUkVTVERDRkctcHViLWNwIiBuYW1lPSJORVRRUkVTVERDRkctcHViLWNwIj4KCTxkcy1hdHRyaWJ1dGVzPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJYbWxEYXRhIj4KCQkJPGRzLXZhbHVlPgoJCQkJPHBvbGljeT4KCQkJCQk8cnVsZT4KCQkJCQkJPGRlc2NyaXB0aW9uPlJlcXVpcmVkIGF0dHJpYnV0ZXMgZm9yIFVzZXIgY3JlYXRpb248L2Rlc2NyaXB0aW9uPgoJCQkJCQk8Y29tbWVudCB4bWw6c3BhY2U9InByZXNlcnZlIj5UaGUgcG9saWN5IGxpc3RzIGJhc2ljIHNldCBvZiBtYW5kYXRvcnkgYXR0cmlidXRlcyByZXF1aXJlZCBmb3IgdXNlciBjcmVhdGlvbiBpbiBJZGVudGl0eSB2YXVsdC4gVW5hdmFpbGFiaWxpeSBvZiB0aGVzZSBhdHRpYnV0ZXMgd2lsbCByZXN1bHQgaW4gb3BlcmF0aW9uIGdldHRpbmcgdmV0b2VkLgo8L2NvbW1lbnQ+CgkJCQkJCTxjb25kaXRpb25zPgoJCQkJCQkJPGFuZD4KCQkJCQkJCQk8aWYtY2xhc3MtbmFtZSBtb2RlPSJub2Nhc2UiIG9wPSJlcXVhbCI+VXNlcjwvaWYtY2xhc3MtbmFtZT4KCQkJCQkJCTwvYW5kPgoJCQkJCQk8L2NvbmRpdGlvbnM+CgkJCQkJCTxhY3Rpb25zPgoJCQkJCQkJPGRvLXZldG8taWYtb3AtYXR0ci1ub3QtYXZhaWxhYmxlIG5hbWU9IkNOIi8+CgkJCQkJCQk8ZG8tdmV0by1pZi1vcC1hdHRyLW5vdC1hdmFpbGFibGUgbmFtZT0iU3VybmFtZSIvPgoJCQkJCQk8L2FjdGlvbnM+CgkJCQkJPC9ydWxlPgoJCQkJPC9wb2xpY3k+CgkJCTwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9ImlkbS1pbnN0YWxsYXRpb25kaXJlY3RpdmUiPgoJCQk8ZHMtdmFsdWU+UEQ5NGJXd2dkbVZ5YzJsdmJqMGlNUzR3SWlCbGJtTnZaR2x1WnowaVZWUkdMVGdpUHo0OGFXNXpkR0ZzYkdGMGFXOXVMV1JwY21WamRHbDJaVDRLQ1R4d2JHRmpaVzFsYm5RZ2JHOWpZWFJwYjI0OUluQjFZbXhwYzJobGNpSXZQZ29KUEdSekxXRjBkSEpwWW5WMFpYTXZQZ29KUEhCdmJHbGplUzFzYVc1cllXZGxQZ29KQ1R4d2IyeHBZM2t0YzJWMElHTm9ZVzV1Wld3OUluQjFZbXhwYzJobGNpSWdibUZ0WlQwaVkzSmxZWFJwYjI0aUlHOXlaR1Z5UFNKWFpXbG5hSFFpSUhaaGJIVmxQU0kxTURBaUx6NEtDVHd2Y0c5c2FXTjVMV3hwYm10aFoyVStDand2YVc1emRHRnNiR0YwYVc5dUxXUnBjbVZqZEdsMlpUND08L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0tZGlyZWN0aXZlY2hlY2tzdW0iPgoJCQk8ZHMtdmFsdWU+NDEwMTc0MDY1MzwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9ImlkbS1wYWNrYWdlYXNzb2NndWlkIj4KCQkJPGRzLXZhbHVlPk1VWEs5UEVBXzIwMTUwNzAxMTIzNzE3MDM4NTwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9ImlkbS1wYWNrYWdlZ3VpZCI+CgkJCTxkcy12YWx1ZT5EUTNaUEhYRl8yMDE1MDUxMjEzMDIzMjAxNjU8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0tY29udGVudGNoZWNrc3VtIj4KCQkJPGRzLXZhbHVlPjE2MDU0MDAzNDA8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJPC9kcy1hdHRyaWJ1dGVzPgo8L2RzLW9iamVjdD4=</pkg-initial-state>
			<pkg-initial-state package-id="CP32RFWU_201505121250070695" pkg-assoc-id="FIN3S6PU_201505212016350356" version="1.1.0.20200528134627">PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48ZHMtb2JqZWN0IGRzLW9iamVjdC1jbGFzcz0iRGlyWE1MLVJ1bGUiIGRzLW9iamVjdC1uYW1lPSJORVRRUkVTVEpTT04taXRwLUpTT050b1hEUyIgbmFtZT0iTkVUUVJFU1RKU09OLWl0cC1KU09OdG9YRFMiPgoJPGRzLWF0dHJpYnV0ZXM+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9IlhtbERhdGEiPgoJCQk8ZHMtdmFsdWU+CgkJCQk8cG9saWN5IHhtbG5zOmVzPSJodHRwOi8vd3d3Lm5vdmVsbC5jb20vbnhzbC9lY21hc2NyaXB0IiB4bWxuczpycz0iaHR0cDovL3d3dy5ub3ZlbGwuY29tL254c2wvamF2YS9jb20ubm92ZWxsLm5kcy5kaXJ4bWwuZHJpdmVyLnJlc3QuY29tbW9uLkpTT05Db252ZXJ0ZXIiPgoJCQkJCTxydWxlPgoJCQkJCQk8ZGVzY3JpcHRpb24+VHJhbnNsYXRlIEpTT04gdG8gWERTPC9kZXNjcmlwdGlvbj4KCQkJCQkJPGNvbmRpdGlvbnM+CgkJCQkJCQk8YW5kPgoJCQkJCQkJCTxpZi1jbGFzcy1uYW1lIG9wPSJhdmFpbGFibGUiLz4KCQkJCQkJCQk8aWYtY2xhc3MtbmFtZSBtb2RlPSJub2Nhc2UiIG9wPSJub3QtZXF1YWwiPkRpclhNTC1Ecml2ZXI8L2lmLWNsYXNzLW5hbWU+CgkJCQkJCQk8L2FuZD4KCQkJCQkJCTxhbmQ+CgkJCQkJCQkJPGlmLW9wZXJhdGlvbiBtb2RlPSJyZWdleCIgb3A9ImVxdWFsIj5zdGF0dXM8L2lmLW9wZXJhdGlvbj4KCQkJCQkJCQk8aWYteHBhdGggZGlzYWJsZWQ9InRydWUiIG9wPSJub3QtdHJ1ZSI+JGN1cnJlbnQtb3AvZHJpdmVyLW9wZXJhdGlvbi1kYXRhIFtAY2xhc3MtbmFtZT0iRGlyWE1MLURyaXZlciJdPC9pZi14cGF0aD4KCQkJCQkJCTwvYW5kPgoJCQkJCQk8L2NvbmRpdGlvbnM+CgkJCQkJCTxhY3Rpb25zPgoJCQkJCQkJPGRvLWlmPgoJCQkJCQkJCTxhcmctY29uZGl0aW9ucz4KCQkJCQkJCQkJPG9yPgoJCQkJCQkJCQkJPGlmLW9wZXJhdGlvbiBtb2RlPSJyZWdleCIgb3A9ImVxdWFsIj5zdGF0dXM8L2lmLW9wZXJhdGlvbj4KCQkJCQkJCQkJPC9vcj4KCQkJCQkJCQk8L2FyZy1jb25kaXRpb25zPgoJCQkJCQkJCTxhcmctYWN0aW9ucz4KCQkJCQkJCQkJPGRvLWlmPgoJCQkJCQkJCQkJPGFyZy1jb25kaXRpb25zPgoJCQkJCQkJCQkJCTxhbmQ+CgkJCQkJCQkJCQkJCTxpZi14cGF0aCBvcD0idHJ1ZSI+c3RyaW5nLWxlbmd0aCguL2RyaXZlci1vcGVyYXRpb24tZGF0YS9yZXNwb25zZS92YWx1ZS90ZXh0KCkpPjA8L2lmLXhwYXRoPgoJCQkJCQkJCQkJCQk8aWYteHBhdGggb3A9InRydWUiPi4vZHJpdmVyLW9wZXJhdGlvbi1kYXRhW0Bjb21tYW5kPSJxdWVyeSJdPC9pZi14cGF0aD4KCQkJCQkJCQkJCQk8L2FuZD4KCQkJCQkJCQkJCTwvYXJnLWNvbmRpdGlvbnM+CgkJCQkJCQkJCQk8YXJnLWFjdGlvbnM+CgkJCQkJCQkJCQkJPGRvLXNldC1sb2NhbC12YXJpYWJsZSBuYW1lPSJ4bWxJbnB1dCIgbm90cmFjZT0idHJ1ZSIgc2NvcGU9InBvbGljeSI+CgkJCQkJCQkJCQkJCTxhcmctc3RyaW5nPgoJCQkJCQkJCQkJCQkJPHRva2VuLWJhc2U2NC1lbmNvZGUgY2hhcnNldD0iVVRGLTgiPgoJCQkJCQkJCQkJCQkJCTx0b2tlbi1yZXBsYWNlLWFsbCByZWdleD0iJmFtcDtsdDsiIHJlcGxhY2Utd2l0aD0iJmx0OyI+CgkJCQkJCQkJCQkJCQkJCTx0b2tlbi14bWwtc2VyaWFsaXplPgoJCQkJCQkJCQkJCQkJCQkJPHRva2VuLXhwYXRoIGV4cHJlc3Npb249Ii4iLz4KCQkJCQkJCQkJCQkJCQkJPC90b2tlbi14bWwtc2VyaWFsaXplPgoJCQkJCQkJCQkJCQkJCTwvdG9rZW4tcmVwbGFjZS1hbGw+CgkJCQkJCQkJCQkJCQk8L3Rva2VuLWJhc2U2NC1lbmNvZGU+CgkJCQkJCQkJCQkJCTwvYXJnLXN0cmluZz4KCQkJCQkJCQkJCQk8L2RvLXNldC1sb2NhbC12YXJpYWJsZT4KCQkJCQkJCQkJCQk8ZG8tc2V0LWxvY2FsLXZhcmlhYmxlIG5hbWU9ImFwcGxpY2F0aW9uQ29udGVudCIgbm90cmFjZT0idHJ1ZSIgc2NvcGU9InBvbGljeSI+CgkJCQkJCQkJCQkJCTxhcmctc3RyaW5nPgoJCQkJCQkJCQkJCQkJPHRva2VuLXhwYXRoIGV4cHJlc3Npb249InJzOmpzb25Ub1hEUygkeG1sSW5wdXQpIi8+CgkJCQkJCQkJCQkJCTwvYXJnLXN0cmluZz4KCQkJCQkJCQkJCQk8L2RvLXNldC1sb2NhbC12YXJpYWJsZT4KCQkJCQkJCQkJCQk8ZG8taWYgbm90cmFjZT0idHJ1ZSI+CgkJCQkJCQkJCQkJCTxhcmctY29uZGl0aW9ucz4KCQkJCQkJCQkJCQkJCTxhbmQ+CgkJCQkJCQkJCQkJCQkJPGlmLWxvY2FsLXZhcmlhYmxlIG1vZGU9Im5vY2FzZSIgbmFtZT0iYXBwbGljYXRpb25Db250ZW50IiBvcD0ibm90LWVxdWFsIi8+CgkJCQkJCQkJCQkJCQk8L2FuZD4KCQkJCQkJCQkJCQkJPC9hcmctY29uZGl0aW9ucz4KCQkJCQkJCQkJCQkJPGFyZy1hY3Rpb25zPgoJCQkJCQkJCQkJCQkJPGRvLXNldC1sb2NhbC12YXJpYWJsZSBuYW1lPSJ4ZHNjb250ZW50IiBzY29wZT0icG9saWN5Ij4KCQkJCQkJCQkJCQkJCQk8YXJnLW5vZGUtc2V0PgoJCQkJCQkJCQkJCQkJCQk8dG9rZW4teG1sLXBhcnNlPgoJCQkJCQkJCQkJCQkJCQkJPHRva2VuLWxvY2FsLXZhcmlhYmxlIG5hbWU9ImFwcGxpY2F0aW9uQ29udGVudCIvPgoJCQkJCQkJCQkJCQkJCQk8L3Rva2VuLXhtbC1wYXJzZT4KCQkJCQkJCQkJCQkJCQk8L2FyZy1ub2RlLXNldD4KCQkJCQkJCQkJCQkJCTwvZG8tc2V0LWxvY2FsLXZhcmlhYmxlPgoJCQkJCQkJCQkJCQkJPGRvLWNsb25lLXhwYXRoIGRlc3QtZXhwcmVzc2lvbj0iLi4iIHNyYy1leHByZXNzaW9uPSIkeGRzY29udGVudC9zdGF0dXMvaW5zdGFuY2UiLz4KCQkJCQkJCQkJCQkJPC9hcmctYWN0aW9ucz4KCQkJCQkJCQkJCQkJPGFyZy1hY3Rpb25zLz4KCQkJCQkJCQkJCQk8L2RvLWlmPgoJCQkJCQkJCQkJCTxkby1zdHJpcC14cGF0aCBleHByZXNzaW9uPSIuL2RyaXZlci1vcGVyYXRpb24tZGF0YSIvPgoJCQkJCQkJCQkJPC9hcmctYWN0aW9ucz4KCQkJCQkJCQkJCTxhcmctYWN0aW9ucy8+CgkJCQkJCQkJCTwvZG8taWY+CgkJCQkJCQkJPC9hcmctYWN0aW9ucz4KCQkJCQkJCQk8YXJnLWFjdGlvbnM+CgkJCQkJCQkJCTxkby1pZj4KCQkJCQkJCQkJCTxhcmctY29uZGl0aW9ucz4KCQkJCQkJCQkJCQk8YW5kPgoJCQkJCQkJCQkJCQk8aWYteG1sLWF0dHIgbmFtZT0iY29tbWFuZCIgb3A9ImF2YWlsYWJsZSIvPgoJCQkJCQkJCQkJCTwvYW5kPgoJCQkJCQkJCQkJPC9hcmctY29uZGl0aW9ucz4KCQkJCQkJCQkJCTxhcmctYWN0aW9ucz4KCQkJCQkJCQkJCQk8ZG8taWY+CgkJCQkJCQkJCQkJCTxhcmctY29uZGl0aW9ucz4KCQkJCQkJCQkJCQkJCTxhbmQ+CgkJCQkJCQkJCQkJCQkJPGlmLXhtbC1hdHRyIG1vZGU9Im5vY2FzZSIgbmFtZT0iY29tbWFuZCIgb3A9ImVxdWFsIj5wb2xsPC9pZi14bWwtYXR0cj4KCQkJCQkJCQkJCQkJCTwvYW5kPgoJCQkJCQkJCQkJCQk8L2FyZy1jb25kaXRpb25zPgoJCQkJCQkJCQkJCQk8YXJnLWFjdGlvbnM+CgkJCQkJCQkJCQkJCQk8ZG8taWY+CgkJCQkJCQkJCQkJCQkJPGFyZy1jb25kaXRpb25zPgoJCQkJCQkJCQkJCQkJCQk8YW5kPgoJCQkJCQkJCQkJCQkJCQkJPGlmLXhwYXRoIG9wPSJ0cnVlIj5zdHJpbmctbGVuZ3RoKC4vcmVzcG9uc2UvdmFsdWUvdGV4dCgpKT4wPC9pZi14cGF0aD4KCQkJCQkJCQkJCQkJCQkJPC9hbmQ+CgkJCQkJCQkJCQkJCQkJPC9hcmctY29uZGl0aW9ucz4KCQkJCQkJCQkJCQkJCQk8YXJnLWFjdGlvbnM+CgkJCQkJCQkJCQkJCQkJCTxkby1zZXQtbG9jYWwtdmFyaWFibGUgbmFtZT0ieG1sSW5wdXQiIG5vdHJhY2U9InRydWUiIHNjb3BlPSJwb2xpY3kiPgoJCQkJCQkJCQkJCQkJCQkJPGFyZy1zdHJpbmc+CgkJCQkJCQkJCQkJCQkJCQkJPHRva2VuLWJhc2U2NC1lbmNvZGUgY2hhcnNldD0iVVRGLTgiPgoJCQkJCQkJCQkJCQkJCQkJCQk8dG9rZW4tcmVwbGFjZS1hbGwgcmVnZXg9IiZhbXA7bHQ7IiByZXBsYWNlLXdpdGg9IiZsdDsiPgoJCQkJCQkJCQkJCQkJCQkJCQkJPHRva2VuLXhtbC1zZXJpYWxpemU+CgkJCQkJCQkJCQkJCQkJCQkJCQkJPHRva2VuLXhwYXRoIGV4cHJlc3Npb249Ii4iLz4KCQkJCQkJCQkJCQkJCQkJCQkJCTwvdG9rZW4teG1sLXNlcmlhbGl6ZT4KCQkJCQkJCQkJCQkJCQkJCQkJPC90b2tlbi1yZXBsYWNlLWFsbD4KCQkJCQkJCQkJCQkJCQkJCQk8L3Rva2VuLWJhc2U2NC1lbmNvZGU+CgkJCQkJCQkJCQkJCQkJCQk8L2FyZy1zdHJpbmc+CgkJCQkJCQkJCQkJCQkJCTwvZG8tc2V0LWxvY2FsLXZhcmlhYmxlPgoJCQkJCQkJCQkJCQkJCQk8ZG8tc2V0LWxvY2FsLXZhcmlhYmxlIG5hbWU9ImFwcGxpY2F0aW9uQ29udGVudCIgbm90cmFjZT0idHJ1ZSIgc2NvcGU9InBvbGljeSI+CgkJCQkJCQkJCQkJCQkJCQk8YXJnLXN0cmluZz4KCQkJCQkJCQkJCQkJCQkJCQk8dG9rZW4teHBhdGggZXhwcmVzc2lvbj0icnM6anNvblRvWERTKCR4bWxJbnB1dCkiLz4KCQkJCQkJCQkJCQkJCQkJCTwvYXJnLXN0cmluZz4KCQkJCQkJCQkJCQkJCQkJPC9kby1zZXQtbG9jYWwtdmFyaWFibGU+CgkJCQkJCQkJCQkJCQkJCTxkby1pZiBub3RyYWNlPSJ0cnVlIj4KCQkJCQkJCQkJCQkJCQkJCTxhcmctY29uZGl0aW9ucz4KCQkJCQkJCQkJCQkJCQkJCQk8YW5kPgoJCQkJCQkJCQkJCQkJCQkJCQk8aWYtbG9jYWwtdmFyaWFibGUgbW9kZT0ibm9jYXNlIiBuYW1lPSJhcHBsaWNhdGlvbkNvbnRlbnQiIG9wPSJub3QtZXF1YWwiLz4KCQkJCQkJCQkJCQkJCQkJCQk8L2FuZD4KCQkJCQkJCQkJCQkJCQkJCTwvYXJnLWNvbmRpdGlvbnM+CgkJCQkJCQkJCQkJCQkJCQk8YXJnLWFjdGlvbnM+CgkJCQkJCQkJCQkJCQkJCQkJPGRvLXNldC1sb2NhbC12YXJpYWJsZSBuYW1lPSJ4ZHNjb250ZW50IiBzY29wZT0icG9saWN5Ij4KCQkJCQkJCQkJCQkJCQkJCQkJPGFyZy1ub2RlLXNldD4KCQkJCQkJCQkJCQkJCQkJCQkJCTx0b2tlbi14bWwtcGFyc2U+CgkJCQkJCQkJCQkJCQkJCQkJCQkJPHRva2VuLWxvY2FsLXZhcmlhYmxlIG5hbWU9ImFwcGxpY2F0aW9uQ29udGVudCIvPgoJCQkJCQkJCQkJCQkJCQkJCQkJPC90b2tlbi14bWwtcGFyc2U+CgkJCQkJCQkJCQkJCQkJCQkJCTwvYXJnLW5vZGUtc2V0PgoJCQkJCQkJCQkJCQkJCQkJCTwvZG8tc2V0LWxvY2FsLXZhcmlhYmxlPgoJCQkJCQkJCQkJCQkJCQkJCTxkby1jbG9uZS14cGF0aCBkZXN0LWV4cHJlc3Npb249Ii4uIiBzcmMtZXhwcmVzc2lvbj0iJHhkc2NvbnRlbnQvaW5wdXQvbW9kaWZ5Ii8+CgkJCQkJCQkJCQkJCQkJCQk8L2FyZy1hY3Rpb25zPgoJCQkJCQkJCQkJCQkJCQkJPGFyZy1hY3Rpb25zLz4KCQkJCQkJCQkJCQkJCQkJPC9kby1pZj4KCQkJCQkJCQkJCQkJCQkJPGRvLXN0cmlwLXhwYXRoIGV4cHJlc3Npb249Ii4iLz4KCQkJCQkJCQkJCQkJCQk8L2FyZy1hY3Rpb25zPgoJCQkJCQkJCQkJCQkJCTxhcmctYWN0aW9ucy8+CgkJCQkJCQkJCQkJCQk8L2RvLWlmPgoJCQkJCQkJCQkJCQk8L2FyZy1hY3Rpb25zPgoJCQkJCQkJCQkJCQk8YXJnLWFjdGlvbnM+CgkJCQkJCQkJCQkJCQk8ZG8tc2V0LWxvY2FsLXZhcmlhYmxlIG5hbWU9Im9wZXJhdGlvbnMiIHNjb3BlPSJwb2xpY3kiPgoJCQkJCQkJCQkJCQkJCTxhcmctbm9kZS1zZXQ+CgkJCQkJCQkJCQkJCQkJCTx0b2tlbi14cGF0aCBleHByZXNzaW9uPSIuIi8+CgkJCQkJCQkJCQkJCQkJPC9hcmctbm9kZS1zZXQ+CgkJCQkJCQkJCQkJCQk8L2RvLXNldC1sb2NhbC12YXJpYWJsZT4KCQkJCQkJCQkJCQkJCTxkby1mb3ItZWFjaD4KCQkJCQkJCQkJCQkJCQk8YXJnLW5vZGUtc2V0PgoJCQkJCQkJCQkJCQkJCQk8dG9rZW4tbG9jYWwtdmFyaWFibGUgbmFtZT0ib3BlcmF0aW9ucyIvPgoJCQkJCQkJCQkJCQkJCTwvYXJnLW5vZGUtc2V0PgoJCQkJCQkJCQkJCQkJCTxhcmctYWN0aW9ucz4KCQkJCQkJCQkJCQkJCQkJPGRvLXNldC1sb2NhbC12YXJpYWJsZSBuYW1lPSJjb21tYW5kIiBzY29wZT0icG9saWN5Ij4KCQkJCQkJCQkJCQkJCQkJCTxhcmctc3RyaW5nPgoJCQkJCQkJCQkJCQkJCQkJCTx0b2tlbi14cGF0aCBleHByZXNzaW9uPSJAY29tbWFuZCIvPgoJCQkJCQkJCQkJCQkJCQkJPC9hcmctc3RyaW5nPgoJCQkJCQkJCQkJCQkJCQk8L2RvLXNldC1sb2NhbC12YXJpYWJsZT4KCQkJCQkJCQkJCQkJCQkJPGRvLWlmPgoJCQkJCQkJCQkJCQkJCQkJPGFyZy1jb25kaXRpb25zPgoJCQkJCQkJCQkJCQkJCQkJCTxhbmQ+CgkJCQkJCQkJCQkJCQkJCQkJCTxpZi1sb2NhbC12YXJpYWJsZSBtb2RlPSJyZWdleCIgbmFtZT0iY29tbWFuZCIgb3A9ImVxdWFsIj5xdWVyeXxkZWxldGU8L2lmLWxvY2FsLXZhcmlhYmxlPgoJCQkJCQkJCQkJCQkJCQkJCTwvYW5kPgoJCQkJCQkJCQkJCQkJCQkJPC9hcmctY29uZGl0aW9ucz4KCQkJCQkJCQkJCQkJCQkJCTxhcmctYWN0aW9ucz4KCQkJCQkJCQkJCQkJCQkJCQk8ZG8taWY+CgkJCQkJCQkJCQkJCQkJCQkJCTxhcmctY29uZGl0aW9ucz4KCQkJCQkJCQkJCQkJCQkJCQkJCTxhbmQ+CgkJCQkJCQkJCQkJCQkJCQkJCQkJPGlmLWxvY2FsLXZhcmlhYmxlIG1vZGU9Im5vY2FzZSIgbmFtZT0iY29tbWFuZCIgb3A9ImVxdWFsIj5xdWVyeTwvaWYtbG9jYWwtdmFyaWFibGU+CgkJCQkJCQkJCQkJCQkJCQkJCQk8L2FuZD4KCQkJCQkJCQkJCQkJCQkJCQkJPC9hcmctY29uZGl0aW9ucz4KCQkJCQkJCQkJCQkJCQkJCQkJPGFyZy1hY3Rpb25zPgoJCQkJCQkJCQkJCQkJCQkJCQkJPGRvLWFwcGVuZC14bWwtZWxlbWVudCBleHByZXNzaW9uPSIvL25kcy9pbnB1dCIgbmFtZT0icXVlcnkiLz4KCQkJCQkJCQkJCQkJCQkJCQkJCTxkby1zZXQteG1sLWF0dHIgZXhwcmVzc2lvbj0iLy9uZHMvaW5wdXQvcXVlcnlbbGFzdCgpXSIgbmFtZT0iY2xhc3MtbmFtZSI+CgkJCQkJCQkJCQkJCQkJCQkJCQkJPGFyZy1zdHJpbmc+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCTx0b2tlbi14cGF0aCBleHByZXNzaW9uPSJAY2xhc3MtbmFtZSIvPgoJCQkJCQkJCQkJCQkJCQkJCQkJCTwvYXJnLXN0cmluZz4KCQkJCQkJCQkJCQkJCQkJCQkJCTwvZG8tc2V0LXhtbC1hdHRyPgoJCQkJCQkJCQkJCQkJCQkJCQkJPGRvLWFwcGVuZC14bWwtZWxlbWVudCBleHByZXNzaW9uPSIvL25kcy9pbnB1dC9xdWVyeVtsYXN0KCldIiBuYW1lPSJzZWFyY2gtY2xhc3MiLz4KCQkJCQkJCQkJCQkJCQkJCQkJCTxkby1zZXQteG1sLWF0dHIgZXhwcmVzc2lvbj0iLy9uZHMvaW5wdXQvcXVlcnlbbGFzdCgpXS9zZWFyY2gtY2xhc3NbbGFzdCgpXSIgbmFtZT0iY2xhc3MtbmFtZSI+CgkJCQkJCQkJCQkJCQkJCQkJCQkJPGFyZy1zdHJpbmc+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCTx0b2tlbi14cGF0aCBleHByZXNzaW9uPSJAY2xhc3MtbmFtZSIvPgoJCQkJCQkJCQkJCQkJCQkJCQkJCTwvYXJnLXN0cmluZz4KCQkJCQkJCQkJCQkJCQkJCQkJCTwvZG8tc2V0LXhtbC1hdHRyPgoJCQkJCQkJCQkJCQkJCQkJCQkJPGRvLWlmPgoJCQkJCQkJCQkJCQkJCQkJCQkJCTxhcmctY29uZGl0aW9ucz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJPGFuZD4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTxpZi14cGF0aCBvcD0idHJ1ZSI+QGFzc29jaWF0aW9uPC9pZi14cGF0aD4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJPC9hbmQ+CgkJCQkJCQkJCQkJCQkJCQkJCQkJPC9hcmctY29uZGl0aW9ucz4KCQkJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLWFjdGlvbnM+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCTxkby1hcHBlbmQteG1sLWVsZW1lbnQgZXhwcmVzc2lvbj0iLy9uZHMvaW5wdXQvcXVlcnlbbGFzdCgpXSIgbmFtZT0iYXNzb2NpYXRpb24iLz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJPGRvLWFwcGVuZC14bWwtdGV4dCBleHByZXNzaW9uPSIvL25kcy9pbnB1dC9xdWVyeVtsYXN0KCldL2Fzc29jaWF0aW9uIj4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTxhcmctc3RyaW5nPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTx0b2tlbi14cGF0aCBleHByZXNzaW9uPSJAYXNzb2NpYXRpb24iLz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTwvYXJnLXN0cmluZz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJPC9kby1hcHBlbmQteG1sLXRleHQ+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCTxkby1zZXQtbG9jYWwtdmFyaWFibGUgbmFtZT0iZmlsdGVyVGV4dCIgc2NvcGU9InBvbGljeSI+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLXN0cmluZz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8dG9rZW4teHBhdGggZXhwcmVzc2lvbj0iQGZpbHRlciIvPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPC9hcmctc3RyaW5nPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQk8L2RvLXNldC1sb2NhbC12YXJpYWJsZT4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJPGRvLXNldC1sb2NhbC12YXJpYWJsZSBuYW1lPSJmaWx0ZXJUZXh0U3BsaXQiIHNjb3BlPSJwb2xpY3kiPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPGFyZy1ub2RlLXNldD4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8dG9rZW4tc3BsaXQgZGVsaW1pdGVyPSImYW1wOyI+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTx0b2tlbi1sb2NhbC12YXJpYWJsZSBuYW1lPSJmaWx0ZXJUZXh0Ii8+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPC90b2tlbi1zcGxpdD4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTwvYXJnLW5vZGUtc2V0PgoJCQkJCQkJCQkJCQkJCQkJCQkJCQk8L2RvLXNldC1sb2NhbC12YXJpYWJsZT4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJPGRvLXNldC1sb2NhbC12YXJpYWJsZSBuYW1lPSJyZWFkQXR0clRleHQiIHNjb3BlPSJwb2xpY3kiPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPGFyZy1zdHJpbmc+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPHRva2VuLXN1YnN0cmluZyBzdGFydD0iMTAiPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8dG9rZW4teHBhdGggZXhwcmVzc2lvbj0icnM6dXJsRGVjb2RlKCRmaWx0ZXJUZXh0U3BsaXRbMl0pIi8+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPC90b2tlbi1zdWJzdHJpbmc+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8L2FyZy1zdHJpbmc+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCTwvZG8tc2V0LWxvY2FsLXZhcmlhYmxlPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQk8ZG8taWY+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLWNvbmRpdGlvbnM+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPGFuZD4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPGlmLWxvY2FsLXZhcmlhYmxlIG1vZGU9ImNhc2UiIG5hbWU9InJlYWRBdHRyVGV4dCIgb3A9Im5vdC1lcXVhbCIvPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTwvYW5kPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPC9hcmctY29uZGl0aW9ucz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTxhcmctYWN0aW9ucz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8ZG8taWY+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTxhcmctY29uZGl0aW9ucz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTxhbmQ+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPGlmLWxvY2FsLXZhcmlhYmxlIG1vZGU9ImNhc2UiIG5hbWU9InJlYWRBdHRyVGV4dCIgb3A9Im5vdC1lcXVhbCI+KjwvaWYtbG9jYWwtdmFyaWFibGU+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8L2FuZD4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPC9hcmctY29uZGl0aW9ucz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPGFyZy1hY3Rpb25zPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPGRvLXNldC1sb2NhbC12YXJpYWJsZSBuYW1lPSJyZWFkQXR0cnMiIHNjb3BlPSJwb2xpY3kiPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTxhcmctbm9kZS1zZXQ+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTx0b2tlbi1zcGxpdCBkZWxpbWl0ZXI9ImFuZCI+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8dG9rZW4tbG9jYWwtdmFyaWFibGUgbmFtZT0icmVhZEF0dHJUZXh0Ii8+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTwvdG9rZW4tc3BsaXQ+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPC9hcmctbm9kZS1zZXQ+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8L2RvLXNldC1sb2NhbC12YXJpYWJsZT4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTxkby1mb3ItZWFjaD4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLW5vZGUtc2V0PgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8dG9rZW4tbG9jYWwtdmFyaWFibGUgbmFtZT0icmVhZEF0dHJzIi8+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPC9hcmctbm9kZS1zZXQ+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPGFyZy1hY3Rpb25zPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8ZG8tYXBwZW5kLXhtbC1lbGVtZW50IGV4cHJlc3Npb249Ii8vbmRzL2lucHV0L3F1ZXJ5W2xhc3QoKV0iIG5hbWU9InJlYWQtYXR0ciIvPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8ZG8tc2V0LXhtbC1hdHRyIGV4cHJlc3Npb249Ii8vbmRzL2lucHV0L3F1ZXJ5W2xhc3QoKV0vcmVhZC1hdHRyW2xhc3QoKV0iIG5hbWU9ImF0dHItbmFtZSI+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLXN0cmluZz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8dG9rZW4tcmVwbGFjZS1hbGwgcmVnZXg9IiciIHJlcGxhY2Utd2l0aD0iIj4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPHRva2VuLWxvY2FsLXZhcmlhYmxlIG5hbWU9ImN1cnJlbnQtbm9kZSIvPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTwvdG9rZW4tcmVwbGFjZS1hbGw+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8L2FyZy1zdHJpbmc+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTwvZG8tc2V0LXhtbC1hdHRyPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTwvYXJnLWFjdGlvbnM+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8L2RvLWZvci1lYWNoPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8L2FyZy1hY3Rpb25zPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLWFjdGlvbnMvPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTwvZG8taWY+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8L2FyZy1hY3Rpb25zPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPGFyZy1hY3Rpb25zPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTxkby1hcHBlbmQteG1sLWVsZW1lbnQgZXhwcmVzc2lvbj0iLy9uZHMvaW5wdXQvcXVlcnlbbGFzdCgpXSIgbmFtZT0icmVhZC1hdHRyIi8+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8L2FyZy1hY3Rpb25zPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQk8L2RvLWlmPgoJCQkJCQkJCQkJCQkJCQkJCQkJCTwvYXJnLWFjdGlvbnM+CgkJCQkJCQkJCQkJCQkJCQkJCQkJPGFyZy1hY3Rpb25zPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQk8IS0tIGRvLXNldC14bWwtYXR0ciBleHByZXNzaW9uPSIvL25kcy9pbnB1dC9xdWVyeVtsYXN0KCldIiBuYW1lPSJkZXN0LWRuIj4KCQkJCQkJCQkJCQkJCQkJCQkJPGFyZy1zdHJpbmc+CgkJCQkJCQkJCQkJCQkJCQkJCQk8dG9rZW4tZ2xvYmFsLXZhcmlhYmxlIG5hbWU9Imlkdi5kaXQuZGF0YS51c2VycyIvPgoJCQkJCQkJCQkJCQkJCQkJCQk8L2FyZy1zdHJpbmc+CgkJCQkJCQkJCQkJCQkJCQkJPC9kby1zZXQteG1sLWF0dHItLT4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJPGRvLXNldC1sb2NhbC12YXJpYWJsZSBuYW1lPSJmaWx0ZXJUZXh0IiBzY29wZT0icG9saWN5Ij4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTxhcmctc3RyaW5nPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTx0b2tlbi14cGF0aCBleHByZXNzaW9uPSJAZmlsdGVyIi8+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8L2FyZy1zdHJpbmc+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCTwvZG8tc2V0LWxvY2FsLXZhcmlhYmxlPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQk8ZG8tc2V0LWxvY2FsLXZhcmlhYmxlIG5hbWU9ImZpbHRlclRleHRTcGxpdCIgc2NvcGU9InBvbGljeSI+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLW5vZGUtc2V0PgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTx0b2tlbi1zcGxpdCBkZWxpbWl0ZXI9IiZhbXA7Ij4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPHRva2VuLWxvY2FsLXZhcmlhYmxlIG5hbWU9ImZpbHRlclRleHQiLz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8L3Rva2VuLXNwbGl0PgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPC9hcmctbm9kZS1zZXQ+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCTwvZG8tc2V0LWxvY2FsLXZhcmlhYmxlPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQk8ZG8tc2V0LWxvY2FsLXZhcmlhYmxlIG5hbWU9ImZpbHRlclRleHROb2RlIiBzY29wZT0icG9saWN5Ij4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTxhcmctbm9kZS1zZXQ+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPHRva2VuLXNwbGl0IGRlbGltaXRlcj0iYW5kIj4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPHRva2VuLXN1YnN0cmluZyBzdGFydD0iMTIiPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPHRva2VuLXhwYXRoIGV4cHJlc3Npb249InJzOnVybERlY29kZSgkZmlsdGVyVGV4dFNwbGl0WzFdKSIvPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8L3Rva2VuLXN1YnN0cmluZz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8L3Rva2VuLXNwbGl0PgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPC9hcmctbm9kZS1zZXQ+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCTwvZG8tc2V0LWxvY2FsLXZhcmlhYmxlPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQk8ZG8tZm9yLWVhY2g+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLW5vZGUtc2V0PgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTx0b2tlbi1sb2NhbC12YXJpYWJsZSBuYW1lPSJmaWx0ZXJUZXh0Tm9kZSIvPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPC9hcmctbm9kZS1zZXQ+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLWFjdGlvbnM+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPGRvLXNldC1sb2NhbC12YXJpYWJsZSBuYW1lPSJzZWFyY2gtYXR0ciIgc2NvcGU9InBvbGljeSI+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTxhcmctbm9kZS1zZXQ+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8dG9rZW4tc3BsaXQgZGVsaW1pdGVyPSJlcSI+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPHRva2VuLWxvY2FsLXZhcmlhYmxlIG5hbWU9ImN1cnJlbnQtbm9kZSIvPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPC90b2tlbi1zcGxpdD4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPC9hcmctbm9kZS1zZXQ+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPC9kby1zZXQtbG9jYWwtdmFyaWFibGU+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPGRvLWFwcGVuZC14bWwtZWxlbWVudCBleHByZXNzaW9uPSIvL25kcy9pbnB1dC9xdWVyeVtsYXN0KCldIiBuYW1lPSJzZWFyY2gtYXR0ciIvPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTxkby1zZXQteG1sLWF0dHIgZXhwcmVzc2lvbj0iLy9uZHMvaW5wdXQvcXVlcnlbbGFzdCgpXS9zZWFyY2gtYXR0cltsYXN0KCldIiBuYW1lPSJhdHRyLW5hbWUiPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLXN0cmluZz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTx0b2tlbi14cGF0aCBleHByZXNzaW9uPSIkc2VhcmNoLWF0dHJbMV0iLz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPC9hcmctc3RyaW5nPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTwvZG8tc2V0LXhtbC1hdHRyPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTxkby1hcHBlbmQteG1sLWVsZW1lbnQgZXhwcmVzc2lvbj0iLy9uZHMvaW5wdXQvcXVlcnlbbGFzdCgpXS9zZWFyY2gtYXR0cltsYXN0KCldIiBuYW1lPSJ2YWx1ZSIvPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTxkby1hcHBlbmQteG1sLXRleHQgZXhwcmVzc2lvbj0iLy9uZHMvaW5wdXQvcXVlcnlbbGFzdCgpXS9zZWFyY2gtYXR0cltsYXN0KCldL3ZhbHVlIj4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPGFyZy1zdHJpbmc+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8dG9rZW4tcmVwbGFjZS1hbGwgcmVnZXg9IiciIHJlcGxhY2Utd2l0aD0iIj4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8dG9rZW4teHBhdGggZXhwcmVzc2lvbj0iJHNlYXJjaC1hdHRyWzJdIi8+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8L3Rva2VuLXJlcGxhY2UtYWxsPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8L2FyZy1zdHJpbmc+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPC9kby1hcHBlbmQteG1sLXRleHQ+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8L2FyZy1hY3Rpb25zPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQk8L2RvLWZvci1lYWNoPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQk8ZG8tc2V0LWxvY2FsLXZhcmlhYmxlIG5hbWU9InJlYWRBdHRyVGV4dCIgc2NvcGU9InBvbGljeSI+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLXN0cmluZz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8dG9rZW4tc3Vic3RyaW5nIHN0YXJ0PSIxMCI+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTx0b2tlbi14cGF0aCBleHByZXNzaW9uPSJyczp1cmxEZWNvZGUoJGZpbHRlclRleHRTcGxpdFsyXSkiLz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8L3Rva2VuLXN1YnN0cmluZz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTwvYXJnLXN0cmluZz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJPC9kby1zZXQtbG9jYWwtdmFyaWFibGU+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCTxkby1pZj4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTxhcmctY29uZGl0aW9ucz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8YW5kPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8aWYtbG9jYWwtdmFyaWFibGUgbW9kZT0iY2FzZSIgbmFtZT0icmVhZEF0dHJUZXh0IiBvcD0ibm90LWVxdWFsIi8+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPC9hbmQ+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8L2FyZy1jb25kaXRpb25zPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPGFyZy1hY3Rpb25zPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTxkby1pZj4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPGFyZy1jb25kaXRpb25zPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPGFuZD4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8aWYtbG9jYWwtdmFyaWFibGUgbW9kZT0iY2FzZSIgbmFtZT0icmVhZEF0dHJUZXh0IiBvcD0ibm90LWVxdWFsIj4qPC9pZi1sb2NhbC12YXJpYWJsZT4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTwvYW5kPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8L2FyZy1jb25kaXRpb25zPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLWFjdGlvbnM+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8ZG8tc2V0LWxvY2FsLXZhcmlhYmxlIG5hbWU9InJlYWRBdHRycyIgc2NvcGU9InBvbGljeSI+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPGFyZy1ub2RlLXNldD4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPHRva2VuLXNwbGl0IGRlbGltaXRlcj0iYW5kIj4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTx0b2tlbi1sb2NhbC12YXJpYWJsZSBuYW1lPSJyZWFkQXR0clRleHQiLz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPC90b2tlbi1zcGxpdD4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8L2FyZy1ub2RlLXNldD4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTwvZG8tc2V0LWxvY2FsLXZhcmlhYmxlPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPGRvLWZvci1lYWNoPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTxhcmctbm9kZS1zZXQ+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTx0b2tlbi1sb2NhbC12YXJpYWJsZSBuYW1lPSJyZWFkQXR0cnMiLz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8L2FyZy1ub2RlLXNldD4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLWFjdGlvbnM+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTxkby1hcHBlbmQteG1sLWVsZW1lbnQgZXhwcmVzc2lvbj0iLy9uZHMvaW5wdXQvcXVlcnlbbGFzdCgpXSIgbmFtZT0icmVhZC1hdHRyIi8+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTxkby1zZXQteG1sLWF0dHIgZXhwcmVzc2lvbj0iLy9uZHMvaW5wdXQvcXVlcnlbbGFzdCgpXS9yZWFkLWF0dHJbbGFzdCgpXSIgbmFtZT0iYXR0ci1uYW1lIj4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTxhcmctc3RyaW5nPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTx0b2tlbi1yZXBsYWNlLWFsbCByZWdleD0iJyIgcmVwbGFjZS13aXRoPSIiPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8dG9rZW4tbG9jYWwtdmFyaWFibGUgbmFtZT0iY3VycmVudC1ub2RlIi8+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPC90b2tlbi1yZXBsYWNlLWFsbD4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTwvYXJnLXN0cmluZz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPC9kby1zZXQteG1sLWF0dHI+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPC9hcmctYWN0aW9ucz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTwvZG8tZm9yLWVhY2g+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTwvYXJnLWFjdGlvbnM+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTxhcmctYWN0aW9ucy8+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPC9kby1pZj4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTwvYXJnLWFjdGlvbnM+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLWFjdGlvbnM+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPGRvLWFwcGVuZC14bWwtZWxlbWVudCBleHByZXNzaW9uPSIvL25kcy9pbnB1dC9xdWVyeVtsYXN0KCldIiBuYW1lPSJyZWFkLWF0dHIiLz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTwvYXJnLWFjdGlvbnM+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCTwvZG8taWY+CgkJCQkJCQkJCQkJCQkJCQkJCQkJPC9hcmctYWN0aW9ucz4KCQkJCQkJCQkJCQkJCQkJCQkJCTwvZG8taWY+CgkJCQkJCQkJCQkJCQkJCQkJCTwvYXJnLWFjdGlvbnM+CgkJCQkJCQkJCQkJCQkJCQkJCTxhcmctYWN0aW9ucz4KCQkJCQkJCQkJCQkJCQkJCQkJCTxkby1hcHBlbmQteG1sLWVsZW1lbnQgZXhwcmVzc2lvbj0iLy9uZHMvaW5wdXQiIG5hbWU9ImRlbGV0ZSIvPgoJCQkJCQkJCQkJCQkJCQkJCQkJPGRvLXNldC14bWwtYXR0ciBleHByZXNzaW9uPSIvL25kcy9pbnB1dC9kZWxldGVbbGFzdCgpXSIgbmFtZT0iY2xhc3MtbmFtZSI+CgkJCQkJCQkJCQkJCQkJCQkJCQkJPGFyZy1zdHJpbmc+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCTx0b2tlbi14cGF0aCBleHByZXNzaW9uPSJAY2xhc3MtbmFtZSIvPgoJCQkJCQkJCQkJCQkJCQkJCQkJCTwvYXJnLXN0cmluZz4KCQkJCQkJCQkJCQkJCQkJCQkJCTwvZG8tc2V0LXhtbC1hdHRyPgoJCQkJCQkJCQkJCQkJCQkJCQkJPGRvLWlmPgoJCQkJCQkJCQkJCQkJCQkJCQkJCTxhcmctY29uZGl0aW9ucz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJPGFuZD4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTxpZi14cGF0aCBvcD0idHJ1ZSI+QGFzc29jaWF0aW9uPC9pZi14cGF0aD4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJPC9hbmQ+CgkJCQkJCQkJCQkJCQkJCQkJCQkJPC9hcmctY29uZGl0aW9ucz4KCQkJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLWFjdGlvbnM+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCTxkby1hcHBlbmQteG1sLWVsZW1lbnQgZXhwcmVzc2lvbj0iLy9uZHMvaW5wdXQvZGVsZXRlW2xhc3QoKV0iIG5hbWU9ImFzc29jaWF0aW9uIi8+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCTxkby1hcHBlbmQteG1sLXRleHQgZXhwcmVzc2lvbj0iLy9uZHMvaW5wdXQvZGVsZXRlW2xhc3QoKV0vYXNzb2NpYXRpb24iPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPGFyZy1zdHJpbmc+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPHRva2VuLXhwYXRoIGV4cHJlc3Npb249IkBhc3NvY2lhdGlvbiIvPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPC9hcmctc3RyaW5nPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQk8L2RvLWFwcGVuZC14bWwtdGV4dD4KCQkJCQkJCQkJCQkJCQkJCQkJCQk8L2FyZy1hY3Rpb25zPgoJCQkJCQkJCQkJCQkJCQkJCQkJCTxhcmctYWN0aW9ucy8+CgkJCQkJCQkJCQkJCQkJCQkJCQk8L2RvLWlmPgoJCQkJCQkJCQkJCQkJCQkJCQk8L2FyZy1hY3Rpb25zPgoJCQkJCQkJCQkJCQkJCQkJCTwvZG8taWY+CgkJCQkJCQkJCQkJCQkJCQk8L2FyZy1hY3Rpb25zPgoJCQkJCQkJCQkJCQkJCQkJPGFyZy1hY3Rpb25zPgoJCQkJCQkJCQkJCQkJCQkJCTxkby1zZXQtbG9jYWwtdmFyaWFibGUgbmFtZT0ieG1sSW5wdXQiIG5vdHJhY2U9InRydWUiIHNjb3BlPSJwb2xpY3kiPgoJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLXN0cmluZz4KCQkJCQkJCQkJCQkJCQkJCQkJCTx0b2tlbi1iYXNlNjQtZW5jb2RlIGNoYXJzZXQ9IlVURi04Ij4KCQkJCQkJCQkJCQkJCQkJCQkJCQk8dG9rZW4tcmVwbGFjZS1hbGwgcmVnZXg9IiZhbXA7bHQ7IiByZXBsYWNlLXdpdGg9IiZsdDsiPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQk8dG9rZW4teG1sLXNlcmlhbGl6ZT4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTx0b2tlbi14cGF0aCBleHByZXNzaW9uPSIuIi8+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCTwvdG9rZW4teG1sLXNlcmlhbGl6ZT4KCQkJCQkJCQkJCQkJCQkJCQkJCQk8L3Rva2VuLXJlcGxhY2UtYWxsPgoJCQkJCQkJCQkJCQkJCQkJCQkJPC90b2tlbi1iYXNlNjQtZW5jb2RlPgoJCQkJCQkJCQkJCQkJCQkJCQk8L2FyZy1zdHJpbmc+CgkJCQkJCQkJCQkJCQkJCQkJPC9kby1zZXQtbG9jYWwtdmFyaWFibGU+CgkJCQkJCQkJCQkJCQkJCQkJPGRvLXNldC1sb2NhbC12YXJpYWJsZSBuYW1lPSJhcHBsaWNhdGlvbkNvbnRlbnQiIG5vdHJhY2U9InRydWUiIHNjb3BlPSJwb2xpY3kiPgoJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLXN0cmluZz4KCQkJCQkJCQkJCQkJCQkJCQkJCTx0b2tlbi14cGF0aCBleHByZXNzaW9uPSJyczpqc29uVG9YRFMoJHhtbElucHV0KSIvPgoJCQkJCQkJCQkJCQkJCQkJCQk8L2FyZy1zdHJpbmc+CgkJCQkJCQkJCQkJCQkJCQkJPC9kby1zZXQtbG9jYWwtdmFyaWFibGU+CgkJCQkJCQkJCQkJCQkJCQkJPGRvLWlmIG5vdHJhY2U9InRydWUiPgoJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLWNvbmRpdGlvbnM+CgkJCQkJCQkJCQkJCQkJCQkJCQk8YW5kPgoJCQkJCQkJCQkJCQkJCQkJCQkJCTxpZi1sb2NhbC12YXJpYWJsZSBtb2RlPSJub2Nhc2UiIG5hbWU9ImFwcGxpY2F0aW9uQ29udGVudCIgb3A9Im5vdC1lcXVhbCIvPgoJCQkJCQkJCQkJCQkJCQkJCQkJPC9hbmQ+CgkJCQkJCQkJCQkJCQkJCQkJCTwvYXJnLWNvbmRpdGlvbnM+CgkJCQkJCQkJCQkJCQkJCQkJCTxhcmctYWN0aW9ucz4KCQkJCQkJCQkJCQkJCQkJCQkJCTxkby1zZXQtbG9jYWwtdmFyaWFibGUgbmFtZT0ieGRzY29udGVudCIgc2NvcGU9InBvbGljeSI+CgkJCQkJCQkJCQkJCQkJCQkJCQkJPGFyZy1ub2RlLXNldD4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJPHRva2VuLXhtbC1wYXJzZT4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTx0b2tlbi1sb2NhbC12YXJpYWJsZSBuYW1lPSJhcHBsaWNhdGlvbkNvbnRlbnQiLz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJPC90b2tlbi14bWwtcGFyc2U+CgkJCQkJCQkJCQkJCQkJCQkJCQkJPC9hcmctbm9kZS1zZXQ+CgkJCQkJCQkJCQkJCQkJCQkJCQk8L2RvLXNldC1sb2NhbC12YXJpYWJsZT4KCQkJCQkJCQkJCQkJCQkJCQkJCTxkby1jbG9uZS14cGF0aCBkZXN0LWV4cHJlc3Npb249Ii9uZHMvaW5wdXQiIHNyYy1leHByZXNzaW9uPSIkeGRzY29udGVudCIvPgoJCQkJCQkJCQkJCQkJCQkJCQk8L2FyZy1hY3Rpb25zPgoJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLWFjdGlvbnMvPgoJCQkJCQkJCQkJCQkJCQkJCTwvZG8taWY+CgkJCQkJCQkJCQkJCQkJCQk8L2FyZy1hY3Rpb25zPgoJCQkJCQkJCQkJCQkJCQk8L2RvLWlmPgoJCQkJCQkJCQkJCQkJCQk8ZG8tc3RyaXAteHBhdGggZXhwcmVzc2lvbj0iLiIvPgoJCQkJCQkJCQkJCQkJCTwvYXJnLWFjdGlvbnM+CgkJCQkJCQkJCQkJCQk8L2RvLWZvci1lYWNoPgoJCQkJCQkJCQkJCQk8L2FyZy1hY3Rpb25zPgoJCQkJCQkJCQkJCTwvZG8taWY+CgkJCQkJCQkJCQk8L2FyZy1hY3Rpb25zPgoJCQkJCQkJCQkJPGFyZy1hY3Rpb25zLz4KCQkJCQkJCQkJPC9kby1pZj4KCQkJCQkJCQk8L2FyZy1hY3Rpb25zPgoJCQkJCQkJPC9kby1pZj4KCQkJCQkJPC9hY3Rpb25zPgoJCQkJCTwvcnVsZT4KCQkJCTwvcG9saWN5PgoJCQk8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0taW5zdGFsbGF0aW9uZGlyZWN0aXZlIj4KCQkJPGRzLXZhbHVlPlBEOTRiV3dnZG1WeWMybHZiajBpTVM0d0lpQmxibU52WkdsdVp6MGlWVlJHTFRnaVB6NDhhVzV6ZEdGc2JHRjBhVzl1TFdScGNtVmpkR2wyWlQ0S0NUeHdiR0ZqWlcxbGJuUWdiRzlqWVhScGIyNDlJbkIxWW14cGMyaGxjaUl2UGdvSlBHUnpMV0YwZEhKcFluVjBaWE12UGdvSlBIQnZiR2xqZVMxc2FXNXJZV2RsUGdvSkNUeHdiMnhwWTNrdGMyVjBJRzVoYldVOUltbHVjSFYwSWlCdmNtUmxjajBpZDJWcFoyaDBJaUIyWVd4MVpUMGlNekF3SWk4K0NnazhMM0J2YkdsamVTMXNhVzVyWVdkbFBnbzhMMmx1YzNSaGJHeGhkR2x2Ymkxa2FYSmxZM1JwZG1VKzwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9ImlkbS1kaXJlY3RpdmVjaGVja3N1bSI+CgkJCTxkcy12YWx1ZT4yMDMyNTI1OTUwPC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iaWRtLXBhY2thZ2Vhc3NvY2d1aWQiPgoJCQk8ZHMtdmFsdWU+RklOM1M2UFVfMjAxNTA1MjEyMDE2MzUwMzU2PC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iaWRtLXBhY2thZ2VndWlkIj4KCQkJPGRzLXZhbHVlPkNQMzJSRldVXzIwMTUwNTEyMTI1MDA3MDY5NTwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9ImlkbS1jb250ZW50Y2hlY2tzdW0iPgoJCQk8ZHMtdmFsdWU+MzU2NjIxMjAyNTwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+Cgk8L2RzLWF0dHJpYnV0ZXM+CjwvZHMtb2JqZWN0Pg==</pkg-initial-state>
			<pkg-initial-state package-id="XTEF1YO3_201006231733410161" pkg-assoc-id="2BRCGU9C_201006231753280863" version="2.1.2.20190806140123">PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48ZHMtb2JqZWN0IGRzLW9iamVjdC1jbGFzcz0iRGlyWE1MLVJ1bGUiIGRzLW9iamVjdC1uYW1lPSJOT1ZMUFdEU1lOQy1wdWItY3RwLUFkZFB3ZFBheWxvYWQiIG5hbWU9Ik5PVkxQV0RTWU5DLXB1Yi1jdHAtQWRkUHdkUGF5bG9hZCI+Cgk8ZHMtYXR0cmlidXRlcz4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iWG1sRGF0YSI+CgkJCTxkcy12YWx1ZT4KCQkJCTxwb2xpY3k+CgkJCQkJPGRlc2NyaXB0aW9uPlB1Ymxpc2ggcGFzc3dvcmQgcGF5bG9hZHM8L2Rlc2NyaXB0aW9uPgoJCQkJCTxydWxlPgoJCQkJCQk8ZGVzY3JpcHRpb24+QWRkIG9wZXJhdGlvbi1kYXRhIGVsZW1lbnQgdG8gcGFzc3dvcmQgb3BlcmF0aW9uczwvZGVzY3JpcHRpb24+CgkJCQkJCTxjb25kaXRpb25zPgoJCQkJCQkJPGFuZD4KCQkJCQkJCQk8aWYtb3BlcmF0aW9uIG9wPSJlcXVhbCI+YWRkPC9pZi1vcGVyYXRpb24+CgkJCQkJCQkJPGlmLXBhc3N3b3JkIG9wPSJhdmFpbGFibGUiLz4KCQkJCQkJCQk8aWYteHBhdGggb3A9Im5vdC10cnVlIj5vcGVyYXRpb24tZGF0YTwvaWYteHBhdGg+CgkJCQkJCQk8L2FuZD4KCQkJCQkJCTxhbmQ+CgkJCQkJCQkJPGlmLW9wZXJhdGlvbiBvcD0iZXF1YWwiPmFkZDwvaWYtb3BlcmF0aW9uPgoJCQkJCQkJCTxpZi14cGF0aCBvcD0idHJ1ZSI+YWRkLWF0dHJbQGF0dHItbmFtZT0nbnNwbURpc3RyaWJ1dGlvblBhc3N3b3JkJ108L2lmLXhwYXRoPgoJCQkJCQkJCTxpZi14cGF0aCBvcD0ibm90LXRydWUiPm9wZXJhdGlvbi1kYXRhPC9pZi14cGF0aD4KCQkJCQkJCTwvYW5kPgoJCQkJCQkJPGFuZD4KCQkJCQkJCQk8aWYtb3BlcmF0aW9uIG9wPSJlcXVhbCI+bW9kaWZ5LXBhc3N3b3JkPC9pZi1vcGVyYXRpb24+CgkJCQkJCQkJPGlmLXhwYXRoIG9wPSJub3QtdHJ1ZSI+b3BlcmF0aW9uLWRhdGE8L2lmLXhwYXRoPgoJCQkJCQkJPC9hbmQ+CgkJCQkJCQk8YW5kPgoJCQkJCQkJCTxpZi1vcGVyYXRpb24gb3A9ImVxdWFsIj5tb2RpZnk8L2lmLW9wZXJhdGlvbj4KCQkJCQkJCQk8aWYteHBhdGggb3A9InRydWUiPm1vZGlmeS1hdHRyW0BhdHRyLW5hbWU9J25zcG1EaXN0cmlidXRpb25QYXNzd29yZCddPC9pZi14cGF0aD4KCQkJCQkJCQk8aWYteHBhdGggb3A9Im5vdC10cnVlIj5vcGVyYXRpb24tZGF0YTwvaWYteHBhdGg+CgkJCQkJCQk8L2FuZD4KCQkJCQkJPC9jb25kaXRpb25zPgoJCQkJCQk8YWN0aW9ucz4KCQkJCQkJCTwhLS0gQWRkIGEgb3BlcmF0aW9uIGRhdGEgcGF5bG9hZCBlbGVtZW50IHRvIHBpY2sgdXAgcmVzdWx0IG9mIGEgcGFzc3dvcmQgb3BlcmF0aW9uIC0tPgoJCQkJCQkJPGRvLWFwcGVuZC14bWwtZWxlbWVudCBleHByZXNzaW9uPSIuIiBuYW1lPSJvcGVyYXRpb24tZGF0YSIvPgoJCQkJCQk8L2FjdGlvbnM+CgkJCQkJPC9ydWxlPgoJCQkJCTxydWxlPgoJCQkJCQk8ZGVzY3JpcHRpb24+QWRkIHBheWxvYWQgZGF0YSB0byBwYXNzd29yZCBvcGVyYXRpb25zPC9kZXNjcmlwdGlvbj4KCQkJCQkJPGNvbmRpdGlvbnM+CgkJCQkJCQk8YW5kPgoJCQkJCQkJCTxpZi1vcGVyYXRpb24gb3A9ImVxdWFsIj5hZGQ8L2lmLW9wZXJhdGlvbj4KCQkJCQkJCQk8aWYtcGFzc3dvcmQgb3A9ImF2YWlsYWJsZSIvPgoJCQkJCQkJPC9hbmQ+CgkJCQkJCQk8YW5kPgoJCQkJCQkJCTxpZi1vcGVyYXRpb24gb3A9ImVxdWFsIj5hZGQ8L2lmLW9wZXJhdGlvbj4KCQkJCQkJCQk8aWYteHBhdGggb3A9InRydWUiPmFkZC1hdHRyW0BhdHRyLW5hbWU9J25zcG1EaXN0cmlidXRpb25QYXNzd29yZCddPC9pZi14cGF0aD4KCQkJCQkJCTwvYW5kPgoJCQkJCQkJPGFuZD4KCQkJCQkJCQk8aWYtb3BlcmF0aW9uIG9wPSJlcXVhbCI+bW9kaWZ5LXBhc3N3b3JkPC9pZi1vcGVyYXRpb24+CgkJCQkJCQk8L2FuZD4KCQkJCQkJCTxhbmQ+CgkJCQkJCQkJPGlmLW9wZXJhdGlvbiBvcD0iZXF1YWwiPm1vZGlmeTwvaWYtb3BlcmF0aW9uPgoJCQkJCQkJCTxpZi14cGF0aCBvcD0idHJ1ZSI+bW9kaWZ5LWF0dHJbQGF0dHItbmFtZT0nbnNwbURpc3RyaWJ1dGlvblBhc3N3b3JkJ108L2lmLXhwYXRoPgoJCQkJCQkJPC9hbmQ+CgkJCQkJCTwvY29uZGl0aW9ucz4KCQkJCQkJPGFjdGlvbnM+CgkJCQkJCQk8IS0tIEFkZCBhIG9wZXJhdGlvbiBkYXRhIHBheWxvYWQgZWxlbWVudCB0byBwaWNrIHVwIHJlc3VsdCBvZiBhIHBhc3N3b3JkIG9wZXJhdGlvbiAtLT4KCQkJCQkJCTxkby1hcHBlbmQteG1sLWVsZW1lbnQgZXhwcmVzc2lvbj0ib3BlcmF0aW9uLWRhdGEiIG5hbWU9InBhc3N3b3JkLXB1Ymxpc2gtc3RhdHVzIi8+CgkJCQkJCQk8ZG8tYXBwZW5kLXhtbC1lbGVtZW50IGV4cHJlc3Npb249Im9wZXJhdGlvbi1kYXRhL3Bhc3N3b3JkLXB1Ymxpc2gtc3RhdHVzIiBuYW1lPSJhc3NvY2lhdGlvbiIvPgoJCQkJCQkJPGRvLWFwcGVuZC14bWwtdGV4dCBleHByZXNzaW9uPSJvcGVyYXRpb24tZGF0YS9wYXNzd29yZC1wdWJsaXNoLXN0YXR1cy9hc3NvY2lhdGlvbiI+CgkJCQkJCQkJPGFyZy1zdHJpbmc+CgkJCQkJCQkJCTx0b2tlbi1hc3NvY2lhdGlvbi8+CgkJCQkJCQkJPC9hcmctc3RyaW5nPgoJCQkJCQkJPC9kby1hcHBlbmQteG1sLXRleHQ+CgkJCQkJCTwvYWN0aW9ucz4KCQkJCQk8L3J1bGU+CgkJCQk8L3BvbGljeT4KCQkJPC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iaWRtLWluc3RhbGxhdGlvbmRpcmVjdGl2ZSI+CgkJCTxkcy12YWx1ZT5QRDk0Yld3Z2RtVnljMmx2YmowaU1TNHdJaUJsYm1OdlpHbHVaejBpVlZSR0xUZ2lQejQ4YVc1emRHRnNiR0YwYVc5dUxXUnBjbVZqZEdsMlpUNEtDVHh3YkdGalpXMWxiblFnYkc5allYUnBiMjQ5SW5CMVlteHBjMmhsY2lJdlBnb0pQR1J6TFdGMGRISnBZblYwWlhNdlBnb0pQSEJ2YkdsamVTMXNhVzVyWVdkbEx6NEtQQzlwYm5OMFlXeHNZWFJwYjI0dFpHbHlaV04wYVhabFBnPT08L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0tZGlyZWN0aXZlY2hlY2tzdW0iPgoJCQk8ZHMtdmFsdWU+MTIzMTI4MjgzMzwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9ImlkbS1wYWNrYWdlYXNzb2NndWlkIj4KCQkJPGRzLXZhbHVlPjJCUkNHVTlDXzIwMTAwNjIzMTc1MzI4MDg2MzwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9ImlkbS1wYWNrYWdlZ3VpZCI+CgkJCTxkcy12YWx1ZT5YVEVGMVlPM18yMDEwMDYyMzE3MzM0MTAxNjE8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0tY29udGVudGNoZWNrc3VtIj4KCQkJPGRzLXZhbHVlPjI1NDkyMTEwMzc8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJPC9kcy1hdHRyaWJ1dGVzPgo8L2RzLW9iamVjdD4=</pkg-initial-state>
			<pkg-initial-state package-id="XTEF1YO3_201006231733410161" pkg-assoc-id="K51N08RF_201006231754340016" version="2.1.2.20190806140123">PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48ZHMtb2JqZWN0IGRzLW9iamVjdC1jbGFzcz0iRGlyWE1MLVJ1bGUiIGRzLW9iamVjdC1uYW1lPSJOT1ZMUFdEU1lOQy1wdWItY3RwLUNoZWNrUHdkR0NWIiBuYW1lPSJOT1ZMUFdEU1lOQy1wdWItY3RwLUNoZWNrUHdkR0NWIj4KCTxkcy1hdHRyaWJ1dGVzPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJYbWxEYXRhIj4KCQkJPGRzLXZhbHVlPgoJCQkJPHBvbGljeT4KCQkJCQk8ZGVzY3JpcHRpb24+UHVibGlzaCBQYXNzd29yZHM8L2Rlc2NyaXB0aW9uPgoJCQkJCTxydWxlPgoJCQkJCQk8ZGVzY3JpcHRpb24+QmxvY2sgcHVibGlzaGluZyBwYXNzd29yZHMgdG8gdGhlIElkZW50aXR5IFZhdWx0IHdoZW4gYWRkaW5nIGFuIG9iamVjdDwvZGVzY3JpcHRpb24+CgkJCQkJCTxjb25kaXRpb25zPgoJCQkJCQkJPGFuZD4KCQkJCQkJCQk8aWYtZ2xvYmFsLXZhcmlhYmxlIG1vZGU9Im5vY2FzZSIgbmFtZT0iZW5hYmxlLXBhc3N3b3JkLXB1Ymxpc2giIG9wPSJlcXVhbCI+ZmFsc2U8L2lmLWdsb2JhbC12YXJpYWJsZT4KCQkJCQkJCQk8aWYtb3BlcmF0aW9uIG9wPSJlcXVhbCI+YWRkPC9pZi1vcGVyYXRpb24+CgkJCQkJCQk8L2FuZD4KCQkJCQkJPC9jb25kaXRpb25zPgoJCQkJCQk8YWN0aW9ucz4KCQkJCQkJCTwhLS0gUmVtb3ZlIGFsbCBwYXNzd29yZCBlbGVtZW50cyBmcm9tIGFkZCAtLT4KCQkJCQkJCTxkby1zdHJpcC14cGF0aCBleHByZXNzaW9uPSJwYXNzd29yZCIvPgoJCQkJCQk8L2FjdGlvbnM+CgkJCQkJPC9ydWxlPgoJCQkJCTxydWxlPgoJCQkJCQk8ZGVzY3JpcHRpb24+QmxvY2sgc2VuZGluZyBtb2RpZnktcGFzc3dvcmQgY2hhbmdlcyB0byB0aGUgSWRlbnRpdHkgVmF1bHQ8L2Rlc2NyaXB0aW9uPgoJCQkJCQk8Y29uZGl0aW9ucz4KCQkJCQkJCTxhbmQ+CgkJCQkJCQkJPGlmLWdsb2JhbC12YXJpYWJsZSBtb2RlPSJub2Nhc2UiIG5hbWU9ImVuYWJsZS1wYXNzd29yZC1wdWJsaXNoIiBvcD0iZXF1YWwiPmZhbHNlPC9pZi1nbG9iYWwtdmFyaWFibGU+CgkJCQkJCQkJPGlmLW9wZXJhdGlvbiBvcD0iZXF1YWwiPm1vZGlmeS1wYXNzd29yZDwvaWYtb3BlcmF0aW9uPgoJCQkJCQkJPC9hbmQ+CgkJCQkJCTwvY29uZGl0aW9ucz4KCQkJCQkJPGFjdGlvbnM+CgkJCQkJCQk8IS0tIEJsb2NrIGFsbCBtb2RpZnktcGFzc3dvcmRzIC0tPgoJCQkJCQkJPGRvLXZldG8vPgoJCQkJCQk8L2FjdGlvbnM+CgkJCQkJPC9ydWxlPgoJCQkJPC9wb2xpY3k+CgkJCTwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9ImlkbS1pbnN0YWxsYXRpb25kaXJlY3RpdmUiPgoJCQk8ZHMtdmFsdWU+UEQ5NGJXd2dkbVZ5YzJsdmJqMGlNUzR3SWlCbGJtTnZaR2x1WnowaVZWUkdMVGdpUHo0OGFXNXpkR0ZzYkdGMGFXOXVMV1JwY21WamRHbDJaVDRLQ1R4d2JHRmpaVzFsYm5RZ2JHOWpZWFJwYjI0OUluQjFZbXhwYzJobGNpSXZQZ29KUEdSekxXRjBkSEpwWW5WMFpYTXZQZ29KUEhCdmJHbGplUzFzYVc1cllXZGxMejRLUEM5cGJuTjBZV3hzWVhScGIyNHRaR2x5WldOMGFYWmxQZz09PC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iaWRtLWRpcmVjdGl2ZWNoZWNrc3VtIj4KCQkJPGRzLXZhbHVlPjEyMzEyODI4MzM8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0tcGFja2FnZWFzc29jZ3VpZCI+CgkJCTxkcy12YWx1ZT5LNTFOMDhSRl8yMDEwMDYyMzE3NTQzNDAwMTY8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0tcGFja2FnZWd1aWQiPgoJCQk8ZHMtdmFsdWU+WFRFRjFZTzNfMjAxMDA2MjMxNzMzNDEwMTYxPC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iaWRtLWNvbnRlbnRjaGVja3N1bSI+CgkJCTxkcy12YWx1ZT4zMDc5MTM5NTU4PC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCTwvZHMtYXR0cmlidXRlcz4KPC9kcy1vYmplY3Q+</pkg-initial-state>
			<pkg-initial-state package-id="XTEF1YO3_201006231733410161" pkg-assoc-id="0J0H3EFI_201006231755560188" version="2.1.2.20190806140123">PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48ZHMtb2JqZWN0IGRzLW9iamVjdC1jbGFzcz0iRGlyWE1MLVJ1bGUiIGRzLW9iamVjdC1uYW1lPSJOT1ZMUFdEU1lOQy1wdWItY3AtRGVmYXVsdFB3ZCIgbmFtZT0iTk9WTFBXRFNZTkMtcHViLWNwLURlZmF1bHRQd2QiPgoJPGRzLWF0dHJpYnV0ZXM+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9IlhtbERhdGEiPgoJCQk8ZHMtdmFsdWU+CgkJCQk8cG9saWN5PgoJCQkJCTxydWxlPgoJCQkJCQk8ZGVzY3JpcHRpb24+T24gVXNlciBhZGQsIHByb3ZpZGUgdGhlIGRlZmF1bHQgcGFzc3dvcmQgaWYgbm8gcGFzc3dvcmQgZXhpc3RzPC9kZXNjcmlwdGlvbj4KCQkJCQkJPGNvbmRpdGlvbnM+CgkJCQkJCQk8YW5kPgoJCQkJCQkJCTxpZi1vcGVyYXRpb24gb3A9ImVxdWFsIj5hZGQ8L2lmLW9wZXJhdGlvbj4KCQkJCQkJCQk8aWYtY2xhc3MtbmFtZSBvcD0iZXF1YWwiPlVzZXI8L2lmLWNsYXNzLW5hbWU+CgkJCQkJCQkJPGlmLXBhc3N3b3JkIG9wPSJub3QtYXZhaWxhYmxlIi8+CgkJCQkJCQkJPGlmLW9wLWF0dHIgbmFtZT0ibnNwbURpc3RyaWJ1dGlvblBhc3N3b3JkIiBvcD0ibm90LWF2YWlsYWJsZSIvPgoJCQkJCQkJPC9hbmQ+CgkJCQkJCTwvY29uZGl0aW9ucz4KCQkJCQkJPGFjdGlvbnM+CgkJCQkJCQk8ZG8taWY+CgkJCQkJCQkJPGFyZy1jb25kaXRpb25zPgoJCQkJCQkJCQk8YW5kPgoJCQkJCQkJCQkJPGlmLWdsb2JhbC12YXJpYWJsZSBtb2RlPSJub2Nhc2UiIG5hbWU9ImRlZmF1bHRQYXNzd29yZC5lbmFibGUiIG9wPSJlcXVhbCI+eWVzPC9pZi1nbG9iYWwtdmFyaWFibGU+CgkJCQkJCQkJCTwvYW5kPgoJCQkJCQkJCTwvYXJnLWNvbmRpdGlvbnM+CgkJCQkJCQkJPGFyZy1hY3Rpb25zPgoJCQkJCQkJCQk8ZG8tc2V0LWRlc3QtcGFzc3dvcmQ+CgkJCQkJCQkJCQk8YXJnLXN0cmluZz4KCQkJCQkJCQkJCQk8dG9rZW4tdGV4dCB4bWw6c3BhY2U9InByZXNlcnZlIj5ARGlyWG1sMTwvdG9rZW4tdGV4dD4KCQkJCQkJCQkJCTwvYXJnLXN0cmluZz4KCQkJCQkJCQkJPC9kby1zZXQtZGVzdC1wYXNzd29yZD4KCQkJCQkJCQk8L2FyZy1hY3Rpb25zPgoJCQkJCQkJCTxhcmctYWN0aW9ucz4KCQkJCQkJCQkJPGRvLXZldG8vPgoJCQkJCQkJCTwvYXJnLWFjdGlvbnM+CgkJCQkJCQk8L2RvLWlmPgoJCQkJCQk8L2FjdGlvbnM+CgkJCQkJPC9ydWxlPgoJCQkJPC9wb2xpY3k+CgkJCTwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9ImlkbS1pbnN0YWxsYXRpb25kaXJlY3RpdmUiPgoJCQk8ZHMtdmFsdWU+UEQ5NGJXd2dkbVZ5YzJsdmJqMGlNUzR3SWlCbGJtTnZaR2x1WnowaVZWUkdMVGdpUHo0OGFXNXpkR0ZzYkdGMGFXOXVMV1JwY21WamRHbDJaVDRLQ1R4d2JHRmpaVzFsYm5RZ2JHOWpZWFJwYjI0OUluQjFZbXhwYzJobGNpSXZQZ29KUEdSekxXRjBkSEpwWW5WMFpYTXZQZ29KUEhCdmJHbGplUzFzYVc1cllXZGxMejRLUEM5cGJuTjBZV3hzWVhScGIyNHRaR2x5WldOMGFYWmxQZz09PC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iaWRtLWRpcmVjdGl2ZWNoZWNrc3VtIj4KCQkJPGRzLXZhbHVlPjEyMzEyODI4MzM8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0tcGFja2FnZWFzc29jZ3VpZCI+CgkJCTxkcy12YWx1ZT4wSjBIM0VGSV8yMDEwMDYyMzE3NTU1NjAxODg8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0tcGFja2FnZWd1aWQiPgoJCQk8ZHMtdmFsdWU+WFRFRjFZTzNfMjAxMDA2MjMxNzMzNDEwMTYxPC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iaWRtLWNvbnRlbnRjaGVja3N1bSI+CgkJCTxkcy12YWx1ZT44MTc2MTU5MTwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+Cgk8L2RzLWF0dHJpYnV0ZXM+CjwvZHMtb2JqZWN0Pg==</pkg-initial-state>
			<pkg-initial-state package-id="XTEF1YO3_201006231733410161" pkg-assoc-id="WQU9K1S0_201006231757350198" version="2.1.2.20190806140123">PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48ZHMtb2JqZWN0IGRzLW9iamVjdC1jbGFzcz0iRGlyWE1MLVJ1bGUiIGRzLW9iamVjdC1uYW1lPSJOT1ZMUFdEU1lOQy1wdWItY3RwLVB1Ymxpc2hEaXN0UHdkIiBuYW1lPSJOT1ZMUFdEU1lOQy1wdWItY3RwLVB1Ymxpc2hEaXN0UHdkIj4KCTxkcy1hdHRyaWJ1dGVzPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJYbWxEYXRhIj4KCQkJPGRzLXZhbHVlPgoJCQkJPHBvbGljeT4KCQkJCQk8ZGVzY3JpcHRpb24+UHVibGlzaCBwYXNzd29yZHMgdG8gTk1BUyBkaXN0cmlidXRpb24gcGFzc3dvcmQ8L2Rlc2NyaXB0aW9uPgoJCQkJCTxydWxlPgoJCQkJCQk8ZGVzY3JpcHRpb24+QWRkIG5zcG1EaXN0cmlidXRpb25BdHRyaWJ1dGUgYXR0cmlidXRlIHRvIGFkZCBvcGVyYXRpb248L2Rlc2NyaXB0aW9uPgoJCQkJCQk8Y29uZGl0aW9ucz4KCQkJCQkJCTxhbmQ+CgkJCQkJCQkJPGlmLWdsb2JhbC12YXJpYWJsZSBtb2RlPSJub2Nhc2UiIG5hbWU9InB1Ymxpc2gtcGFzc3dvcmQtdG8tZHAiIG9wPSJlcXVhbCI+dHJ1ZTwvaWYtZ2xvYmFsLXZhcmlhYmxlPgoJCQkJCQkJCTxpZi1vcGVyYXRpb24gb3A9ImVxdWFsIj5hZGQ8L2lmLW9wZXJhdGlvbj4KCQkJCQkJCQk8aWYtcGFzc3dvcmQgb3A9ImF2YWlsYWJsZSIvPgoJCQkJCQkJCTxpZi1wYXNzd29yZCBtb2RlPSJyZWdleCIgb3A9ImVxdWFsIj4uKzwvaWYtcGFzc3dvcmQ+CgkJCQkJCQk8L2FuZD4KCQkJCQkJPC9jb25kaXRpb25zPgoJCQkJCQk8YWN0aW9ucz4KCQkJCQkJCTwhLS0gQWRkIGFkZC1hdHRyIGVsZW1lbnQgZm9yIG5zcG1EaXN0cmlidXRpb25QYXNzd29yZCBhdHRyaWJ1dGUgLS0+CgkJCQkJCQk8ZG8tYWRkLWRlc3QtYXR0ci12YWx1ZSBuYW1lPSJuc3BtRGlzdHJpYnV0aW9uUGFzc3dvcmQiPgoJCQkJCQkJCTxhcmctdmFsdWU+CgkJCQkJCQkJCTx0b2tlbi1wYXNzd29yZC8+CgkJCQkJCQkJPC9hcmctdmFsdWU+CgkJCQkJCQk8L2RvLWFkZC1kZXN0LWF0dHItdmFsdWU+CgkJCQkJCQk8IS0tIEFkZCBhIHZhbGlkYXRlLXBhc3N3b3JkIGF0dHJpYnV0ZSB0byBwcmV2aW91cyBhZGQtYXR0ciBlbGVtZW50IC0tPgoJCQkJCQkJPGRvLXNldC14bWwtYXR0ciBleHByZXNzaW9uPSJhZGQtYXR0cltAYXR0ci1uYW1lID0gJ25zcG1EaXN0cmlidXRpb25QYXNzd29yZCddW2xhc3QoKV0iIG5hbWU9ImVuZm9yY2UtcGFzc3dvcmQtcG9saWN5Ij4KCQkJCQkJCQk8YXJnLXN0cmluZz4KCQkJCQkJCQkJPHRva2VuLWdsb2JhbC12YXJpYWJsZSBuYW1lPSJlbmZvcmNlLXBhc3N3b3JkLXBvbGljeSIvPgoJCQkJCQkJCTwvYXJnLXN0cmluZz4KCQkJCQkJCTwvZG8tc2V0LXhtbC1hdHRyPgoJCQkJCQk8L2FjdGlvbnM+CgkJCQkJPC9ydWxlPgoJCQkJCTxydWxlPgoJCQkJCQk8ZGVzY3JpcHRpb24+Q2hhbmdlIG1vZGlmeS1wYXNzd29yZCBvcGVyYXRpb25zIHRvIGEgbW9kaWZ5PC9kZXNjcmlwdGlvbj4KCQkJCQkJPGNvbmRpdGlvbnM+CgkJCQkJCQk8YW5kPgoJCQkJCQkJCTxpZi1nbG9iYWwtdmFyaWFibGUgbW9kZT0ibm9jYXNlIiBuYW1lPSJwdWJsaXNoLXBhc3N3b3JkLXRvLWRwIiBvcD0iZXF1YWwiPnRydWU8L2lmLWdsb2JhbC12YXJpYWJsZT4KCQkJCQkJCQk8aWYtb3BlcmF0aW9uIG9wPSJlcXVhbCI+bW9kaWZ5LXBhc3N3b3JkPC9pZi1vcGVyYXRpb24+CgkJCQkJCQkJPGlmLXBhc3N3b3JkIG9wPSJhdmFpbGFibGUiLz4KCQkJCQkJCQk8aWYtcGFzc3dvcmQgbW9kZT0icmVnZXgiIG9wPSJlcXVhbCI+Lis8L2lmLXBhc3N3b3JkPgoJCQkJCQkJPC9hbmQ+CgkJCQkJCTwvY29uZGl0aW9ucz4KCQkJCQkJPGFjdGlvbnM+CgkJCQkJCQk8IS0tIEFkZCBtb2RpZnktYXR0ciBlbGVtZW50IGZvciBuc3BtRGlzdHJpYnV0aW9uUGFzc3dvcmQgYXR0cmlidXRlIC0tPgoJCQkJCQkJPGRvLWFkZC1kZXN0LWF0dHItdmFsdWUgbmFtZT0ibnNwbURpc3RyaWJ1dGlvblBhc3N3b3JkIj4KCQkJCQkJCQk8YXJnLXZhbHVlPgoJCQkJCQkJCQk8dG9rZW4tcGFzc3dvcmQvPgoJCQkJCQkJCTwvYXJnLXZhbHVlPgoJCQkJCQkJPC9kby1hZGQtZGVzdC1hdHRyLXZhbHVlPgoJCQkJCQkJPCEtLSBBZGQgYSBldmVudC1pZCBhdHRyaWJ1dGUgdG8gcHJldmlvdXMgbW9kaWZ5IGVsZW1lbnQgLS0+CgkJCQkJCQk8ZG8tc2V0LXhtbC1hdHRyIGV4cHJlc3Npb249Ii4uL21vZGlmeSIgbmFtZT0iZXZlbnQtaWQiPgoJCQkJCQkJCTxhcmctc3RyaW5nPgoJCQkJCQkJCQk8dG9rZW4tdGV4dD5wd2QtcHVibGlzaDwvdG9rZW4tdGV4dD4KCQkJCQkJCQk8L2FyZy1zdHJpbmc+CgkJCQkJCQk8L2RvLXNldC14bWwtYXR0cj4KCQkJCQkJCTwhLS0gQWRkIGEgdmFsaWRhdGUtcGFzc3dvcmQgYXR0cmlidXRlIHRvIHByZXZpb3VzIGFkZC1hdHRyIGVsZW1lbnQgLS0+CgkJCQkJCQk8ZG8tc2V0LXhtbC1hdHRyIGV4cHJlc3Npb249Ii4uL21vZGlmeS9tb2RpZnktYXR0cltAYXR0ci1uYW1lPSduc3BtRGlzdHJpYnV0aW9uUGFzc3dvcmQnXSIgbmFtZT0iZW5mb3JjZS1wYXNzd29yZC1wb2xpY3kiPgoJCQkJCQkJCTxhcmctc3RyaW5nPgoJCQkJCQkJCQk8dG9rZW4tZ2xvYmFsLXZhcmlhYmxlIG5hbWU9ImVuZm9yY2UtcGFzc3dvcmQtcG9saWN5Ii8+CgkJCQkJCQkJPC9hcmctc3RyaW5nPgoJCQkJCQkJPC9kby1zZXQteG1sLWF0dHI+CgkJCQkJCTwvYWN0aW9ucz4KCQkJCQk8L3J1bGU+CgkJCQk8L3BvbGljeT4KCQkJPC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iaWRtLWluc3RhbGxhdGlvbmRpcmVjdGl2ZSI+CgkJCTxkcy12YWx1ZT5QRDk0Yld3Z2RtVnljMmx2YmowaU1TNHdJaUJsYm1OdlpHbHVaejBpVlZSR0xUZ2lQejQ4YVc1emRHRnNiR0YwYVc5dUxXUnBjbVZqZEdsMlpUNEtDVHh3YkdGalpXMWxiblFnYkc5allYUnBiMjQ5SW5CMVlteHBjMmhsY2lJdlBnb0pQR1J6TFdGMGRISnBZblYwWlhNdlBnb0pQSEJ2YkdsamVTMXNhVzVyWVdkbEx6NEtQQzlwYm5OMFlXeHNZWFJwYjI0dFpHbHlaV04wYVhabFBnPT08L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0tZGlyZWN0aXZlY2hlY2tzdW0iPgoJCQk8ZHMtdmFsdWU+MTIzMTI4MjgzMzwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9ImlkbS1wYWNrYWdlYXNzb2NndWlkIj4KCQkJPGRzLXZhbHVlPldRVTlLMVMwXzIwMTAwNjIzMTc1NzM1MDE5ODwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9ImlkbS1wYWNrYWdlZ3VpZCI+CgkJCTxkcy12YWx1ZT5YVEVGMVlPM18yMDEwMDYyMzE3MzM0MTAxNjE8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0tY29udGVudGNoZWNrc3VtIj4KCQkJPGRzLXZhbHVlPjM3NjY1MDk3NzE8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJPC9kcy1hdHRyaWJ1dGVzPgo8L2RzLW9iamVjdD4=</pkg-initial-state>
			<pkg-initial-state package-id="XTEF1YO3_201006231733410161" pkg-assoc-id="84V5V29N_201006231759000291" version="2.1.2.20190806140123">PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48ZHMtb2JqZWN0IGRzLW9iamVjdC1jbGFzcz0iRGlyWE1MLVJ1bGUiIGRzLW9iamVjdC1uYW1lPSJOT1ZMUFdEU1lOQy1wdWItY3RwLVB1Ymxpc2hORFNQd2QiIG5hbWU9Ik5PVkxQV0RTWU5DLXB1Yi1jdHAtUHVibGlzaE5EU1B3ZCI+Cgk8ZHMtYXR0cmlidXRlcz4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iWG1sRGF0YSI+CgkJCTxkcy12YWx1ZT4KCQkJCTxwb2xpY3k+CgkJCQkJPGRlc2NyaXB0aW9uPlB1Ymxpc2ggcGFzc3dvcmRzIHRvIGVEaXJlY3RvcnkgcGFzc3dvcmQuPC9kZXNjcmlwdGlvbj4KCQkJCQk8cnVsZT4KCQkJCQkJPGRlc2NyaXB0aW9uPkJsb2NrIHB1Ymxpc2hpbmcgcGFzc3dvcmRzIHRvIGVEaXJlY3RvcnkgcGFzc3dvcmQ8L2Rlc2NyaXB0aW9uPgoJCQkJCQk8Y29uZGl0aW9ucz4KCQkJCQkJCTxhbmQ+CgkJCQkJCQkJPGlmLW9wZXJhdGlvbiBvcD0iZXF1YWwiPmFkZDwvaWYtb3BlcmF0aW9uPgoJCQkJCQkJPC9hbmQ+CgkJCQkJCTwvY29uZGl0aW9ucz4KCQkJCQkJPGFjdGlvbnM+CgkJCQkJCQk8IS0tIFJlbW92ZSBhbGwgcGFzc3dvcmQgZWxlbWVudHMgZnJvbSBhZGQgLS0+CgkJCQkJCQk8ZG8taWY+CgkJCQkJCQkJPGFyZy1jb25kaXRpb25zPgoJCQkJCQkJCQk8b3I+CgkJCQkJCQkJCQk8aWYtZ2xvYmFsLXZhcmlhYmxlIG1vZGU9Im5vY2FzZSIgbmFtZT0icHVibGlzaC1wYXNzd29yZC10by1uZHMiIG9wPSJlcXVhbCI+ZmFsc2U8L2lmLWdsb2JhbC12YXJpYWJsZT4KCQkJCQkJCQkJCTxpZi1wYXNzd29yZCBvcD0ibm90LWF2YWlsYWJsZSIvPgoJCQkJCQkJCQkJPGlmLXBhc3N3b3JkIG1vZGU9InJlZ2V4IiBvcD0ibm90LWVxdWFsIj4uKzwvaWYtcGFzc3dvcmQ+CgkJCQkJCQkJCTwvb3I+CgkJCQkJCQkJPC9hcmctY29uZGl0aW9ucz4KCQkJCQkJCQk8YXJnLWFjdGlvbnM+CgkJCQkJCQkJCTxkby1zdHJpcC14cGF0aCBleHByZXNzaW9uPSJwYXNzd29yZCIvPgoJCQkJCQkJCTwvYXJnLWFjdGlvbnM+CgkJCQkJCQk8L2RvLWlmPgoJCQkJCQk8L2FjdGlvbnM+CgkJCQkJPC9ydWxlPgoJCQkJCTxydWxlPgoJCQkJCQk8ZGVzY3JpcHRpb24+QmxvY2sgc2VuZGluZyBtb2RpZnktcGFzc3dvcmQgY2hhbmdlcyB0byB0aGUgZURpcmVjdG9yeSBwYXNzd29yZDwvZGVzY3JpcHRpb24+CgkJCQkJCTxjb25kaXRpb25zPgoJCQkJCQkJPGFuZD4KCQkJCQkJCQk8aWYtb3BlcmF0aW9uIG9wPSJlcXVhbCI+bW9kaWZ5LXBhc3N3b3JkPC9pZi1vcGVyYXRpb24+CgkJCQkJCQk8L2FuZD4KCQkJCQkJPC9jb25kaXRpb25zPgoJCQkJCQk8YWN0aW9ucz4KCQkJCQkJCTwhLS0gQmxvY2sgYWxsIG1vZGlmeS1wYXNzd29yZHMgLS0+CgkJCQkJCQk8ZG8taWY+CgkJCQkJCQkJPGFyZy1jb25kaXRpb25zPgoJCQkJCQkJCQk8b3I+CgkJCQkJCQkJCQk8aWYtZ2xvYmFsLXZhcmlhYmxlIG1vZGU9Im5vY2FzZSIgbmFtZT0icHVibGlzaC1wYXNzd29yZC10by1uZHMiIG9wPSJlcXVhbCI+ZmFsc2U8L2lmLWdsb2JhbC12YXJpYWJsZT4KCQkJCQkJCQkJCTxpZi1wYXNzd29yZCBvcD0ibm90LWF2YWlsYWJsZSIvPgoJCQkJCQkJCQkJPGlmLXBhc3N3b3JkIG1vZGU9InJlZ2V4IiBvcD0ibm90LWVxdWFsIj4uKzwvaWYtcGFzc3dvcmQ+CgkJCQkJCQkJCTwvb3I+CgkJCQkJCQkJPC9hcmctY29uZGl0aW9ucz4KCQkJCQkJCQk8YXJnLWFjdGlvbnM+CgkJCQkJCQkJCTxkby12ZXRvLz4KCQkJCQkJCQk8L2FyZy1hY3Rpb25zPgoJCQkJCQkJPC9kby1pZj4KCQkJCQkJPC9hY3Rpb25zPgoJCQkJCTwvcnVsZT4KCQkJCTwvcG9saWN5PgoJCQk8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0taW5zdGFsbGF0aW9uZGlyZWN0aXZlIj4KCQkJPGRzLXZhbHVlPlBEOTRiV3dnZG1WeWMybHZiajBpTVM0d0lpQmxibU52WkdsdVp6MGlWVlJHTFRnaVB6NDhhVzV6ZEdGc2JHRjBhVzl1TFdScGNtVmpkR2wyWlQ0S0NUeHdiR0ZqWlcxbGJuUWdiRzlqWVhScGIyNDlJbkIxWW14cGMyaGxjaUl2UGdvSlBHUnpMV0YwZEhKcFluVjBaWE12UGdvSlBIQnZiR2xqZVMxc2FXNXJZV2RsTHo0S1BDOXBibk4wWVd4c1lYUnBiMjR0WkdseVpXTjBhWFpsUGc9PTwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9ImlkbS1kaXJlY3RpdmVjaGVja3N1bSI+CgkJCTxkcy12YWx1ZT4xMjMxMjgyODMzPC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iaWRtLXBhY2thZ2Vhc3NvY2d1aWQiPgoJCQk8ZHMtdmFsdWU+ODRWNVYyOU5fMjAxMDA2MjMxNzU5MDAwMjkxPC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iaWRtLXBhY2thZ2VndWlkIj4KCQkJPGRzLXZhbHVlPlhURUYxWU8zXzIwMTAwNjIzMTczMzQxMDE2MTwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9ImlkbS1jb250ZW50Y2hlY2tzdW0iPgoJCQk8ZHMtdmFsdWU+MTUxMzAwNjIwMjwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+Cgk8L2RzLWF0dHJpYnV0ZXM+CjwvZHMtb2JqZWN0Pg==</pkg-initial-state>
			<pkg-initial-state package-id="3V750MRQ_201504031637130312" pkg-assoc-id="AC644FBS_201504082045320904" version="1.0.0.20171211151747">PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48ZHMtb2JqZWN0IGRzLW9iamVjdC1jbGFzcz0iRGlyWE1MLVJ1bGUiIGRzLW9iamVjdC1uYW1lPSJORVRRUFdEU1lOQy1pdHAtVHJhbnNmb3JtUGFzc3dvcmQiIG5hbWU9Ik5FVFFQV0RTWU5DLWl0cC1UcmFuc2Zvcm1QYXNzd29yZCI+Cgk8ZHMtYXR0cmlidXRlcz4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iWG1sRGF0YSI+CgkJCTxkcy12YWx1ZT4KCQkJCTxwb2xpY3k+CgkJCQkJPHJ1bGU+CgkJCQkJCTxkZXNjcmlwdGlvbj5DcmVhdGUgTW9kaWZ5IFBhc3N3b3JkPC9kZXNjcmlwdGlvbj4KCQkJCQkJPGNvbmRpdGlvbnM+CgkJCQkJCQk8YW5kPgoJCQkJCQkJCTxpZi1jbGFzcy1uYW1lIG1vZGU9Im5vY2FzZSIgb3A9ImVxdWFsIj5Vc2VyPC9pZi1jbGFzcy1uYW1lPgoJCQkJCQkJCTxpZi1vcGVyYXRpb24gbW9kZT0ibm9jYXNlIiBvcD0iZXF1YWwiPm1vZGlmeTwvaWYtb3BlcmF0aW9uPgoJCQkJCQkJCTxpZi1vcC1hdHRyIG5hbWU9InBhc3N3b3JkIiBvcD0iYXZhaWxhYmxlIi8+CgkJCQkJCQk8L2FuZD4KCQkJCQkJPC9jb25kaXRpb25zPgoJCQkJCQk8YWN0aW9ucz4KCQkJCQkJCTxkby1zZXQtZGVzdC1wYXNzd29yZCBjbGFzcy1uYW1lPSJVc2VyIj4KCQkJCQkJCQk8YXJnLXN0cmluZz4KCQkJCQkJCQkJPHRva2VuLW9wLWF0dHIgbmFtZT0icGFzc3dvcmQiLz4KCQkJCQkJCQk8L2FyZy1zdHJpbmc+CgkJCQkJCQk8L2RvLXNldC1kZXN0LXBhc3N3b3JkPgoJCQkJCQkJPGRvLXN0cmlwLXhwYXRoIGV4cHJlc3Npb249Ii4iLz4KCQkJCQkJPC9hY3Rpb25zPgoJCQkJCTwvcnVsZT4KCQkJCTwvcG9saWN5PgoJCQk8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0taW5zdGFsbGF0aW9uZGlyZWN0aXZlIj4KCQkJPGRzLXZhbHVlPlBEOTRiV3dnZG1WeWMybHZiajBpTVM0d0lpQmxibU52WkdsdVp6MGlWVlJHTFRnaVB6NDhhVzV6ZEdGc2JHRjBhVzl1TFdScGNtVmpkR2wyWlQ0S0NUeHdiR0ZqWlcxbGJuUWdiRzlqWVhScGIyNDlJbkIxWW14cGMyaGxjaUl2UGdvSlBHUnpMV0YwZEhKcFluVjBaWE12UGdvSlBIQnZiR2xqZVMxc2FXNXJZV2RsUGdvSkNUeHdiMnhwWTNrdGMyVjBJRzVoYldVOUltbHVjSFYwSWlCdmNtUmxjajBpZDJWcFoyaDBJaUIyWVd4MVpUMGlOekV3SWk4K0NnazhMM0J2YkdsamVTMXNhVzVyWVdkbFBnbzhMMmx1YzNSaGJHeGhkR2x2Ymkxa2FYSmxZM1JwZG1VKzwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9ImlkbS1kaXJlY3RpdmVjaGVja3N1bSI+CgkJCTxkcy12YWx1ZT4xNjYxODExMDA5PC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iaWRtLXBhY2thZ2Vhc3NvY2d1aWQiPgoJCQk8ZHMtdmFsdWU+QUM2NDRGQlNfMjAxNTA0MDgyMDQ1MzIwOTA0PC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iaWRtLXBhY2thZ2VndWlkIj4KCQkJPGRzLXZhbHVlPjNWNzUwTVJRXzIwMTUwNDAzMTYzNzEzMDMxMjwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9ImlkbS1jb250ZW50Y2hlY2tzdW0iPgoJCQk8ZHMtdmFsdWU+MjUzODE0ODIzNDwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+Cgk8L2RzLWF0dHJpYnV0ZXM+CjwvZHMtb2JqZWN0Pg==</pkg-initial-state>
			<pkg-initial-state package-id="DQ3ZPHXF_201505121302320165" pkg-assoc-id="92DOXP4M_201505121304050581" version="1.0.1.20180613142919">PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48ZHMtb2JqZWN0IGRzLW9iamVjdC1jbGFzcz0iRGlyWE1MLVJ1bGUiIGRzLW9iamVjdC1uYW1lPSJORVRRUkVTVERDRkctc3ViLWN0cC1Bc3NvY2lhdGUiIG5hbWU9Ik5FVFFSRVNURENGRy1zdWItY3RwLUFzc29jaWF0ZSI+Cgk8ZHMtYXR0cmlidXRlcz4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iWG1sRGF0YSI+CgkJCTxkcy12YWx1ZT4KCQkJCTxwb2xpY3k+CgkJCQkJPHJ1bGU+CgkJCQkJCTxkZXNjcmlwdGlvbj5Bc3NvY2lhdGUgb24gQUREPC9kZXNjcmlwdGlvbj4KCQkJCQkJPGNvbmRpdGlvbnM+CgkJCQkJCQk8YW5kPgoJCQkJCQkJCTxpZi1vcGVyYXRpb24gbW9kZT0icmVnZXgiIG9wPSJlcXVhbCI+YWRkPC9pZi1vcGVyYXRpb24+CgkJCQkJCQk8L2FuZD4KCQkJCQkJPC9jb25kaXRpb25zPgoJCQkJCQk8YWN0aW9ucz4KCQkJCQkJCTxkby1zZXQtb3AtcHJvcGVydHkgbmFtZT0iYXNzb2NpYXRpb24iPgoJCQkJCQkJCTxhcmctc3RyaW5nPgoJCQkJCQkJCQk8dG9rZW4tYXR0ciBuYW1lPSIkZHJ2LmFzc29jaWF0aW9uJCIvPgoJCQkJCQkJCTwvYXJnLXN0cmluZz4KCQkJCQkJCTwvZG8tc2V0LW9wLXByb3BlcnR5PgoJCQkJCQkJPGRvLXNldC1vcC1wcm9wZXJ0eSBuYW1lPSJzcmMtZG4iPgoJCQkJCQkJCTxhcmctc3RyaW5nPgoJCQkJCQkJCQk8dG9rZW4tc3JjLWRuLz4KCQkJCQkJCQk8L2FyZy1zdHJpbmc+CgkJCQkJCQk8L2RvLXNldC1vcC1wcm9wZXJ0eT4KCQkJCQkJCTxkby1zZXQtb3AtYXNzb2NpYXRpb24+CgkJCQkJCQkJPGFyZy1hc3NvY2lhdGlvbj4KCQkJCQkJCQkJPHRva2VuLW9wLXByb3BlcnR5IG5hbWU9ImFzc29jaWF0aW9uIi8+CgkJCQkJCQkJPC9hcmctYXNzb2NpYXRpb24+CgkJCQkJCQk8L2RvLXNldC1vcC1hc3NvY2lhdGlvbj4KCQkJCQkJPC9hY3Rpb25zPgoJCQkJCTwvcnVsZT4KCQkJCTwvcG9saWN5PgoJCQk8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0taW5zdGFsbGF0aW9uZGlyZWN0aXZlIj4KCQkJPGRzLXZhbHVlPlBEOTRiV3dnZG1WeWMybHZiajBpTVM0d0lpQmxibU52WkdsdVp6MGlWVlJHTFRnaVB6NDhhVzV6ZEdGc2JHRjBhVzl1TFdScGNtVmpkR2wyWlQ0S0NUeHdiR0ZqWlcxbGJuUWdiRzlqWVhScGIyNDlJbk4xWW5OamNtbGlaWElpTHo0S0NUeGtjeTFoZEhSeWFXSjFkR1Z6THo0S0NUeHdiMnhwWTNrdGJHbHVhMkZuWlQ0S0NRazhjRzlzYVdONUxYTmxkQ0JqYUdGdWJtVnNQU0p6ZFdKelkzSnBZbVZ5SWlCdVlXMWxQU0pqYjIxdFlXNWtJaUJ2Y21SbGNqMGlkMlZwWjJoMElpQjJZV3gxWlQwaU1UQXdJaTgrQ2drOEwzQnZiR2xqZVMxc2FXNXJZV2RsUGdvOEwybHVjM1JoYkd4aGRHbHZiaTFrYVhKbFkzUnBkbVUrPC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iaWRtLWRpcmVjdGl2ZWNoZWNrc3VtIj4KCQkJPGRzLXZhbHVlPjMzMDk0ODEzNTc8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0tcGFja2FnZWFzc29jZ3VpZCI+CgkJCTxkcy12YWx1ZT45MkRPWFA0TV8yMDE1MDUxMjEzMDQwNTA1ODE8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0tcGFja2FnZWd1aWQiPgoJCQk8ZHMtdmFsdWU+RFEzWlBIWEZfMjAxNTA1MTIxMzAyMzIwMTY1PC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iaWRtLWNvbnRlbnRjaGVja3N1bSI+CgkJCTxkcy12YWx1ZT44MzE5NTY5MjA8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJPC9kcy1hdHRyaWJ1dGVzPgo8L2RzLW9iamVjdD4=</pkg-initial-state>
			<pkg-initial-state package-id="DQ3ZPHXF_201505121302320165" pkg-assoc-id="DSMC0QX4_201505121304050581" version="1.0.1.20180613142919">PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48ZHMtb2JqZWN0IGRzLW9iamVjdC1jbGFzcz0iRGlyWE1MLVJ1bGUiIGRzLW9iamVjdC1uYW1lPSJORVRRUkVTVERDRkctc3ViLWN0cC1SZW5hbWVUb01vZGlmeSIgbmFtZT0iTkVUUVJFU1REQ0ZHLXN1Yi1jdHAtUmVuYW1lVG9Nb2RpZnkiPgoJPGRzLWF0dHJpYnV0ZXM+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9IlhtbERhdGEiPgoJCQk8ZHMtdmFsdWU+CgkJCQk8cG9saWN5PgoJCQkJCTxydWxlPgoJCQkJCQk8ZGVzY3JpcHRpb24+VHJhbnNmb3JtIHJlbmFtZSBldmVudCB0byBtb2RpZnk8L2Rlc2NyaXB0aW9uPgoJCQkJCQk8Y29uZGl0aW9ucz4KCQkJCQkJCTxhbmQ+CgkJCQkJCQkJPGlmLW9wZXJhdGlvbiBvcD0iZXF1YWwiPnJlbmFtZTwvaWYtb3BlcmF0aW9uPgoJCQkJCQkJPC9hbmQ+CgkJCQkJCTwvY29uZGl0aW9ucz4KCQkJCQkJPGFjdGlvbnM+CgkJCQkJCQk8ZG8tc2V0LWRlc3QtYXR0ci12YWx1ZSBuYW1lPSJDTiIgd2hlbj0iYWZ0ZXIiPgoJCQkJCQkJCTxhcmctdmFsdWUgdHlwZT0ic3RyaW5nIj4KCQkJCQkJCQkJPHRva2VuLXhwYXRoIGV4cHJlc3Npb249Im5ldy1uYW1lL3RleHQoKSIvPgoJCQkJCQkJCTwvYXJnLXZhbHVlPgoJCQkJCQkJPC9kby1zZXQtZGVzdC1hdHRyLXZhbHVlPgoJCQkJCQkJPGRvLXZldG8vPgoJCQkJCQk8L2FjdGlvbnM+CgkJCQkJPC9ydWxlPgoJCQkJPC9wb2xpY3k+CgkJCTwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9ImlkbS1pbnN0YWxsYXRpb25kaXJlY3RpdmUiPgoJCQk8ZHMtdmFsdWU+UEQ5NGJXd2dkbVZ5YzJsdmJqMGlNUzR3SWlCbGJtTnZaR2x1WnowaVZWUkdMVGdpUHo0OGFXNXpkR0ZzYkdGMGFXOXVMV1JwY21WamRHbDJaVDRLQ1R4d2JHRmpaVzFsYm5RZ2JHOWpZWFJwYjI0OUluTjFZbk5qY21saVpYSWlMejRLQ1R4a2N5MWhkSFJ5YVdKMWRHVnpMejRLQ1R4d2IyeHBZM2t0YkdsdWEyRm5aVDRLQ1FrOGNHOXNhV041TFhObGRDQmphR0Z1Ym1Wc1BTSnpkV0p6WTNKcFltVnlJaUJ1WVcxbFBTSmpiMjF0WVc1a0lpQnZjbVJsY2owaWQyVnBaMmgwSWlCMllXeDFaVDBpTlRBMUlpOCtDZ2s4TDNCdmJHbGplUzFzYVc1cllXZGxQZ284TDJsdWMzUmhiR3hoZEdsdmJpMWthWEpsWTNScGRtVSs8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0tZGlyZWN0aXZlY2hlY2tzdW0iPgoJCQk8ZHMtdmFsdWU+MjIzMDM4NDM1MTwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9ImlkbS1wYWNrYWdlYXNzb2NndWlkIj4KCQkJPGRzLXZhbHVlPkRTTUMwUVg0XzIwMTUwNTEyMTMwNDA1MDU4MTwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9ImlkbS1wYWNrYWdlZ3VpZCI+CgkJCTxkcy12YWx1ZT5EUTNaUEhYRl8yMDE1MDUxMjEzMDIzMjAxNjU8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0tY29udGVudGNoZWNrc3VtIj4KCQkJPGRzLXZhbHVlPjE1MTc2MDUzMTM8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJPC9kcy1hdHRyaWJ1dGVzPgo8L2RzLW9iamVjdD4=</pkg-initial-state>
			<pkg-initial-state package-id="DQ3ZPHXF_201505121302320165" pkg-assoc-id="YZ5E0IK0_201505121315030061" version="1.0.1.20180613142919">PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48ZHMtb2JqZWN0IGRzLW9iamVjdC1jbGFzcz0iRGlyWE1MLVJ1bGUiIGRzLW9iamVjdC1uYW1lPSJORVRRUkVTVERDRkctc3ViLW1wIiBuYW1lPSJORVRRUkVTVERDRkctc3ViLW1wIj4KCTxkcy1hdHRyaWJ1dGVzPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJYbWxEYXRhIj4KCQkJPGRzLXZhbHVlPgoJCQkJPHBvbGljeT4KCQkJCQk8ZGVzY3JpcHRpb24+UXVlcnkgRGlzcGxheSBOYW1lPC9kZXNjcmlwdGlvbj4KCQkJCQk8cnVsZT4KCQkJCQkJPGRlc2NyaXB0aW9uPk1hdGNoIFVzZXJzPC9kZXNjcmlwdGlvbj4KCQkJCQkJPGNvbmRpdGlvbnM+CgkJCQkJCQk8YW5kPgoJCQkJCQkJCTxpZi1jbGFzcy1uYW1lIG1vZGU9Im5vY2FzZSIgb3A9ImVxdWFsIj5Vc2VyPC9pZi1jbGFzcy1uYW1lPgoJCQkJCQkJPC9hbmQ+CgkJCQkJCTwvY29uZGl0aW9ucz4KCQkJCQkJPGFjdGlvbnM+CgkJCQkJCQk8ZG8tZmluZC1tYXRjaGluZy1vYmplY3Qgc2NvcGU9InN1YnRyZWUiPgoJCQkJCQkJCTxhcmctbWF0Y2gtYXR0ciBuYW1lPSJDTiI+CgkJCQkJCQkJCTxhcmctdmFsdWUgdHlwZT0ic3RyaW5nIj4KCQkJCQkJCQkJCTx0b2tlbi1zcmMtYXR0ciBuYW1lPSJDTiIvPgoJCQkJCQkJCQk8L2FyZy12YWx1ZT4KCQkJCQkJCQk8L2FyZy1tYXRjaC1hdHRyPgoJCQkJCQkJPC9kby1maW5kLW1hdGNoaW5nLW9iamVjdD4KCQkJCQkJCTxkby1maW5kLW1hdGNoaW5nLW9iamVjdCBzY29wZT0ic3VidHJlZSI+CgkJCQkJCQkJPGFyZy1tYXRjaC1hdHRyIG5hbWU9IkRpc3BsYXlOYW1lIj4KCQkJCQkJCQkJPGFyZy12YWx1ZSB0eXBlPSJzdHJpbmciPgoJCQkJCQkJCQkJPHRva2VuLXNyYy1hdHRyIG5hbWU9IkZ1bGwgTmFtZSIvPgoJCQkJCQkJCQk8L2FyZy12YWx1ZT4KCQkJCQkJCQk8L2FyZy1tYXRjaC1hdHRyPgoJCQkJCQkJPC9kby1maW5kLW1hdGNoaW5nLW9iamVjdD4KCQkJCQkJPC9hY3Rpb25zPgoJCQkJCTwvcnVsZT4KCQkJCQk8cnVsZT4KCQkJCQkJPGRlc2NyaXB0aW9uPk1hdGNoIGdyb3VwPC9kZXNjcmlwdGlvbj4KCQkJCQkJPGNvbmRpdGlvbnM+CgkJCQkJCQk8YW5kPgoJCQkJCQkJCTxpZi1jbGFzcy1uYW1lIG1vZGU9Im5vY2FzZSIgb3A9ImVxdWFsIj5Hcm91cDwvaWYtY2xhc3MtbmFtZT4KCQkJCQkJCTwvYW5kPgoJCQkJCQk8L2NvbmRpdGlvbnM+CgkJCQkJCTxhY3Rpb25zPgoJCQkJCQkJPGRvLWZpbmQtbWF0Y2hpbmctb2JqZWN0IHNjb3BlPSJzdWJ0cmVlIj4KCQkJCQkJCQk8YXJnLW1hdGNoLWF0dHIgbmFtZT0iRGlzcGxheU5hbWUiPgoJCQkJCQkJCQk8YXJnLXZhbHVlIHR5cGU9InN0cmluZyI+CgkJCQkJCQkJCQk8dG9rZW4tc3JjLWF0dHIgbmFtZT0iQ04iLz4KCQkJCQkJCQkJPC9hcmctdmFsdWU+CgkJCQkJCQkJPC9hcmctbWF0Y2gtYXR0cj4KCQkJCQkJCTwvZG8tZmluZC1tYXRjaGluZy1vYmplY3Q+CgkJCQkJCTwvYWN0aW9ucz4KCQkJCQk8L3J1bGU+CgkJCQk8L3BvbGljeT4KCQkJPC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iaWRtLWluc3RhbGxhdGlvbmRpcmVjdGl2ZSI+CgkJCTxkcy12YWx1ZT5QRDk0Yld3Z2RtVnljMmx2YmowaU1TNHdJaUJsYm1OdlpHbHVaejBpVlZSR0xUZ2lQejQ4YVc1emRHRnNiR0YwYVc5dUxXUnBjbVZqZEdsMlpUNEtDVHh3YkdGalpXMWxiblFnYkc5allYUnBiMjQ5SW5OMVluTmpjbWxpWlhJaUx6NEtDVHhrY3kxaGRIUnlhV0oxZEdWekx6NEtDVHh3YjJ4cFkza3RiR2x1YTJGblpUNEtDUWs4Y0c5c2FXTjVMWE5sZENCamFHRnVibVZzUFNKemRXSnpZM0pwWW1WeUlpQnVZVzFsUFNKdFlYUmphR2x1WnlJZ2IzSmtaWEk5SWxkbGFXZG9kQ0lnZG1Gc2RXVTlJalV3TUNJdlBnb0pQQzl3YjJ4cFkza3RiR2x1YTJGblpUNEtQQzlwYm5OMFlXeHNZWFJwYjI0dFpHbHlaV04wYVhabFBnPT08L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0tZGlyZWN0aXZlY2hlY2tzdW0iPgoJCQk8ZHMtdmFsdWU+MzY1MTAxODkxNjwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9ImlkbS1wYWNrYWdlYXNzb2NndWlkIj4KCQkJPGRzLXZhbHVlPllaNUUwSUswXzIwMTUwNTEyMTMxNTAzMDA2MTwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9ImlkbS1wYWNrYWdlZ3VpZCI+CgkJCTxkcy12YWx1ZT5EUTNaUEhYRl8yMDE1MDUxMjEzMDIzMjAxNjU8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0tY29udGVudGNoZWNrc3VtIj4KCQkJPGRzLXZhbHVlPjE3Mzg2MjY5Nzc8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJPC9kcy1hdHRyaWJ1dGVzPgo8L2RzLW9iamVjdD4=</pkg-initial-state>
			<pkg-initial-state package-id="CP32RFWU_201505121250070695" pkg-assoc-id="4CBT7U00_201505121250070695" version="1.1.0.20200528134627">PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48ZHMtb2JqZWN0IGRzLW9iamVjdC1jbGFzcz0iRGlyWE1MLVJ1bGUiIGRzLW9iamVjdC1uYW1lPSJORVRRUkVTVEpTT04tb3RwLVhEU3RvSlNPTiIgbmFtZT0iTkVUUVJFU1RKU09OLW90cC1YRFN0b0pTT04iPgoJPGRzLWF0dHJpYnV0ZXM+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9IlhtbERhdGEiPgoJCQk8ZHMtdmFsdWU+CgkJCQk8cG9saWN5IHhtbG5zOmVzPSJodHRwOi8vd3d3Lm5vdmVsbC5jb20vbnhzbC9lY21hc2NyaXB0IiB4bWxuczpycz0iaHR0cDovL3d3dy5ub3ZlbGwuY29tL254c2wvamF2YS9jb20ubm92ZWxsLm5kcy5kaXJ4bWwuZHJpdmVyLnJlc3QuY29tbW9uLkpTT05Db252ZXJ0ZXIiPgoJCQkJCTxydWxlPgoJCQkJCQk8ZGVzY3JpcHRpb24+VHJhbnNsYXRlIFhEUyB0byBKU09OPC9kZXNjcmlwdGlvbj4KCQkJCQkJPGNvbmRpdGlvbnM+CgkJCQkJCQk8YW5kPgoJCQkJCQkJCTxpZi1vcGVyYXRpb24gbW9kZT0icmVnZXgiIG9wPSJub3QtZXF1YWwiPmluc3RhbmNlPC9pZi1vcGVyYXRpb24+CgkJCQkJCQkJPGlmLW9wZXJhdGlvbiBtb2RlPSJub2Nhc2UiIG9wPSJub3QtZXF1YWwiPmRyaXZlci1vcGVyYXRpb24tZGF0YTwvaWYtb3BlcmF0aW9uPgoJCQkJCQkJPC9hbmQ+CgkJCQkJCTwvY29uZGl0aW9ucz4KCQkJCQkJPGFjdGlvbnM+CgkJCQkJCQk8ZG8taWY+CgkJCQkJCQkJPGFyZy1jb25kaXRpb25zPgoJCQkJCQkJCQk8YW5kPgoJCQkJCQkJCQkJPGlmLW9wZXJhdGlvbiBtb2RlPSJyZWdleCIgb3A9ImVxdWFsIj5zdGF0dXM8L2lmLW9wZXJhdGlvbj4KCQkJCQkJCQkJCTxpZi14cGF0aCBvcD0idHJ1ZSI+Y291bnQoLy9uZHMvL2luc3RhbmNlKT4wPC9pZi14cGF0aD4KCQkJCQkJCQkJCTxpZi14cGF0aCBvcD0ibm90LXRydWUiPi8vaW5zdGFuY2VbQGNsYXNzLW5hbWU9IkRpclhNTC1Ecml2ZXIiXTwvaWYteHBhdGg+CgkJCQkJCQkJCTwvYW5kPgoJCQkJCQkJCTwvYXJnLWNvbmRpdGlvbnM+CgkJCQkJCQkJPGFyZy1hY3Rpb25zPgoJCQkJCQkJCQk8ZG8tc2V0LWxvY2FsLXZhcmlhYmxlIG5hbWU9InN0YXR1cyIgc2NvcGU9InBvbGljeSI+CgkJCQkJCQkJCQk8YXJnLW5vZGUtc2V0PgoJCQkJCQkJCQkJCTx0b2tlbi14bWwtcGFyc2U+CgkJCQkJCQkJCQkJCTx0b2tlbi10ZXh0IHhtbDpzcGFjZT0icHJlc2VydmUiPiZsdDtzdGF0dXM+Jmx0Oy9zdGF0dXM+PC90b2tlbi10ZXh0PgoJCQkJCQkJCQkJCTwvdG9rZW4teG1sLXBhcnNlPgoJCQkJCQkJCQkJPC9hcmctbm9kZS1zZXQ+CgkJCQkJCQkJCTwvZG8tc2V0LWxvY2FsLXZhcmlhYmxlPgoJCQkJCQkJCQk8ZG8tY2xvbmUteHBhdGggZGVzdC1leHByZXNzaW9uPSIkc3RhdHVzL3N0YXR1cyIgc3JjLWV4cHJlc3Npb249Ii9uZHMvKi9pbnN0YW5jZSIvPgoJCQkJCQkJCQk8ZG8tc2V0LWxvY2FsLXZhcmlhYmxlIG5hbWU9InhtbElucHV0IiBzY29wZT0icG9saWN5Ij4KCQkJCQkJCQkJCTxhcmctc3RyaW5nPgoJCQkJCQkJCQkJCTx0b2tlbi1iYXNlNjQtZW5jb2RlIGNoYXJzZXQ9IlVURi04Ij4KCQkJCQkJCQkJCQkJPHRva2VuLXJlcGxhY2UtYWxsIHJlZ2V4PSImYW1wO2x0OyIgcmVwbGFjZS13aXRoPSImbHQ7Ij4KCQkJCQkJCQkJCQkJCTx0b2tlbi14bWwtc2VyaWFsaXplPgoJCQkJCQkJCQkJCQkJCTx0b2tlbi14cGF0aCBleHByZXNzaW9uPSIkc3RhdHVzIi8+CgkJCQkJCQkJCQkJCQk8L3Rva2VuLXhtbC1zZXJpYWxpemU+CgkJCQkJCQkJCQkJCTwvdG9rZW4tcmVwbGFjZS1hbGw+CgkJCQkJCQkJCQkJPC90b2tlbi1iYXNlNjQtZW5jb2RlPgoJCQkJCQkJCQkJPC9hcmctc3RyaW5nPgoJCQkJCQkJCQk8L2RvLXNldC1sb2NhbC12YXJpYWJsZT4KCQkJCQkJCQkJPGRvLXNldC1sb2NhbC12YXJpYWJsZSBuYW1lPSJhcHBsaWNhdGlvbkNvbnRlbnQiIG5vdHJhY2U9InRydWUiIHNjb3BlPSJwb2xpY3kiPgoJCQkJCQkJCQkJPGFyZy1zdHJpbmc+CgkJCQkJCQkJCQkJPHRva2VuLXhwYXRoIGV4cHJlc3Npb249InJzOnhkc1RvSlNPTigkeG1sSW5wdXQpIi8+CgkJCQkJCQkJCQk8L2FyZy1zdHJpbmc+CgkJCQkJCQkJCTwvZG8tc2V0LWxvY2FsLXZhcmlhYmxlPgoJCQkJCQkJCQk8ZG8tYXBwZW5kLXhtbC1lbGVtZW50IGV4cHJlc3Npb249IiRjdXJyZW50LW9wIiBuYW1lPSJkcml2ZXItb3BlcmF0aW9uLWRhdGEiLz4KCQkJCQkJCQkJPGRvLWFwcGVuZC14bWwtZWxlbWVudCBleHByZXNzaW9uPSIkY3VycmVudC1vcC9kcml2ZXItb3BlcmF0aW9uLWRhdGFbbGFzdCgpXSIgbmFtZT0iaGVhZGVyIi8+CgkJCQkJCQkJCTxkby1zZXQteG1sLWF0dHIgZXhwcmVzc2lvbj0iJGN1cnJlbnQtb3AvZHJpdmVyLW9wZXJhdGlvbi1kYXRhW2xhc3QoKV0vaGVhZGVyIiBuYW1lPSJBY2NlcHQiPgoJCQkJCQkJCQkJPGFyZy1zdHJpbmc+CgkJCQkJCQkJCQkJPHRva2VuLXRleHQgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+YXBwbGljYXRpb24vanNvbjwvdG9rZW4tdGV4dD4KCQkJCQkJCQkJCTwvYXJnLXN0cmluZz4KCQkJCQkJCQkJPC9kby1zZXQteG1sLWF0dHI+CgkJCQkJCQkJCTxkby1hcHBlbmQteG1sLWVsZW1lbnQgZXhwcmVzc2lvbj0iJGN1cnJlbnQtb3AvZHJpdmVyLW9wZXJhdGlvbi1kYXRhW2xhc3QoKV0iIG5hbWU9InJlc3BvbnNlIi8+CgkJCQkJCQkJCTxkby1hcHBlbmQteG1sLWVsZW1lbnQgZXhwcmVzc2lvbj0iJGN1cnJlbnQtb3AvZHJpdmVyLW9wZXJhdGlvbi1kYXRhW2xhc3QoKV0vcmVzcG9uc2UiIG5hbWU9InZhbHVlIi8+CgkJCQkJCQkJCTxkby1hcHBlbmQteG1sLXRleHQgZXhwcmVzc2lvbj0iJGN1cnJlbnQtb3AvZHJpdmVyLW9wZXJhdGlvbi1kYXRhW2xhc3QoKV0vcmVzcG9uc2UvdmFsdWUiIG5vdHJhY2U9InRydWUiPgoJCQkJCQkJCQkJPGFyZy1zdHJpbmc+CgkJCQkJCQkJCQkJPHRva2VuLWxvY2FsLXZhcmlhYmxlIG5hbWU9ImFwcGxpY2F0aW9uQ29udGVudCIvPgoJCQkJCQkJCQkJPC9hcmctc3RyaW5nPgoJCQkJCQkJCQk8L2RvLWFwcGVuZC14bWwtdGV4dD4KCQkJCQkJCQkJPGRvLXN0cmlwLXhwYXRoIGV4cHJlc3Npb249Ii9uZHMvKi9pbnN0YW5jZSIvPgoJCQkJCQkJCTwvYXJnLWFjdGlvbnM+CgkJCQkJCQkJPGFyZy1hY3Rpb25zPgoJCQkJCQkJCQk8ZG8taWY+CgkJCQkJCQkJCQk8YXJnLWNvbmRpdGlvbnM+CgkJCQkJCQkJCQkJPGFuZD4KCQkJCQkJCQkJCQkJPGlmLWNsYXNzLW5hbWUgb3A9ImF2YWlsYWJsZSIvPgoJCQkJCQkJCQkJCQk8aWYtY2xhc3MtbmFtZSBtb2RlPSJub2Nhc2UiIG9wPSJub3QtZXF1YWwiPkRpclhNTC1Ecml2ZXI8L2lmLWNsYXNzLW5hbWU+CgkJCQkJCQkJCQkJPC9hbmQ+CgkJCQkJCQkJCQk8L2FyZy1jb25kaXRpb25zPgoJCQkJCQkJCQkJPGFyZy1hY3Rpb25zPgoJCQkJCQkJCQkJCTxkby1zZXQtbG9jYWwtdmFyaWFibGUgbmFtZT0ib3BlcmF0aW9ucyIgc2NvcGU9InBvbGljeSI+CgkJCQkJCQkJCQkJCTxhcmctbm9kZS1zZXQ+CgkJCQkJCQkJCQkJCQk8dG9rZW4teHBhdGggZXhwcmVzc2lvbj0iLiIvPgoJCQkJCQkJCQkJCQk8L2FyZy1ub2RlLXNldD4KCQkJCQkJCQkJCQk8L2RvLXNldC1sb2NhbC12YXJpYWJsZT4KCQkJCQkJCQkJCQk8ZG8tZm9yLWVhY2g+CgkJCQkJCQkJCQkJCTxhcmctbm9kZS1zZXQ+CgkJCQkJCQkJCQkJCQk8dG9rZW4tbG9jYWwtdmFyaWFibGUgbmFtZT0ib3BlcmF0aW9ucyIvPgoJCQkJCQkJCQkJCQk8L2FyZy1ub2RlLXNldD4KCQkJCQkJCQkJCQkJPGFyZy1hY3Rpb25zPgoJCQkJCQkJCQkJCQkJPGRvLXNldC1sb2NhbC12YXJpYWJsZSBuYW1lPSJ4bWxJbnB1dCIgbm90cmFjZT0idHJ1ZSIgc2NvcGU9InBvbGljeSI+CgkJCQkJCQkJCQkJCQkJPGFyZy1zdHJpbmc+CgkJCQkJCQkJCQkJCQkJCTx0b2tlbi1iYXNlNjQtZW5jb2RlIGNoYXJzZXQ9IlVURi04Ij4KCQkJCQkJCQkJCQkJCQkJCTx0b2tlbi1yZXBsYWNlLWFsbCByZWdleD0iJmFtcDtsdDsiIHJlcGxhY2Utd2l0aD0iJmx0OyI+CgkJCQkJCQkJCQkJCQkJCQkJPHRva2VuLXhtbC1zZXJpYWxpemU+CgkJCQkJCQkJCQkJCQkJCQkJCTx0b2tlbi14cGF0aCBleHByZXNzaW9uPSIkY3VycmVudC1vcCIvPgoJCQkJCQkJCQkJCQkJCQkJCTwvdG9rZW4teG1sLXNlcmlhbGl6ZT4KCQkJCQkJCQkJCQkJCQkJCTwvdG9rZW4tcmVwbGFjZS1hbGw+CgkJCQkJCQkJCQkJCQkJCTwvdG9rZW4tYmFzZTY0LWVuY29kZT4KCQkJCQkJCQkJCQkJCQk8L2FyZy1zdHJpbmc+CgkJCQkJCQkJCQkJCQk8L2RvLXNldC1sb2NhbC12YXJpYWJsZT4KCQkJCQkJCQkJCQkJCTxkby1zZXQtbG9jYWwtdmFyaWFibGUgbmFtZT0iYXBwbGljYXRpb25Db250ZW50IiBub3RyYWNlPSJ0cnVlIiBzY29wZT0icG9saWN5Ij4KCQkJCQkJCQkJCQkJCQk8YXJnLXN0cmluZz4KCQkJCQkJCQkJCQkJCQkJPHRva2VuLXhwYXRoIGV4cHJlc3Npb249InJzOnhkc1RvSlNPTigkeG1sSW5wdXQpIi8+CgkJCQkJCQkJCQkJCQkJPC9hcmctc3RyaW5nPgoJCQkJCQkJCQkJCQkJPC9kby1zZXQtbG9jYWwtdmFyaWFibGU+CgkJCQkJCQkJCQkJCQk8ZG8taWYgbm90cmFjZT0idHJ1ZSI+CgkJCQkJCQkJCQkJCQkJPGFyZy1jb25kaXRpb25zPgoJCQkJCQkJCQkJCQkJCQk8YW5kPgoJCQkJCQkJCQkJCQkJCQkJPGlmLWxvY2FsLXZhcmlhYmxlIG1vZGU9Im5vY2FzZSIgbmFtZT0iYXBwbGljYXRpb25Db250ZW50IiBvcD0ibm90LWVxdWFsIi8+CgkJCQkJCQkJCQkJCQkJCTwvYW5kPgoJCQkJCQkJCQkJCQkJCTwvYXJnLWNvbmRpdGlvbnM+CgkJCQkJCQkJCQkJCQkJPGFyZy1hY3Rpb25zPgoJCQkJCQkJCQkJCQkJCQk8ZG8taWY+CgkJCQkJCQkJCQkJCQkJCQk8YXJnLWNvbmRpdGlvbnM+CgkJCQkJCQkJCQkJCQkJCQkJPGFuZD4KCQkJCQkJCQkJCQkJCQkJCQkJPGlmLW9wZXJhdGlvbiBtb2RlPSJyZWdleCIgb3A9Im5vdC1lcXVhbCI+cXVlcnk8L2lmLW9wZXJhdGlvbj4KCQkJCQkJCQkJCQkJCQkJCQk8L2FuZD4KCQkJCQkJCQkJCQkJCQkJCTwvYXJnLWNvbmRpdGlvbnM+CgkJCQkJCQkJCQkJCQkJCQk8YXJnLWFjdGlvbnM+CgkJCQkJCQkJCQkJCQkJCQkJPGRvLWFwcGVuZC14bWwtZWxlbWVudCBleHByZXNzaW9uPSIuLiIgbmFtZT0iZHJpdmVyLW9wZXJhdGlvbi1kYXRhIi8+CgkJCQkJCQkJCQkJCQkJCQkJPGRvLXNldC14bWwtYXR0ciBleHByZXNzaW9uPSIuLi9kcml2ZXItb3BlcmF0aW9uLWRhdGEiIG5hbWU9InNyYy1kbiI+CgkJCQkJCQkJCQkJCQkJCQkJCTxhcmctc3RyaW5nPgoJCQkJCQkJCQkJCQkJCQkJCQkJPHRva2VuLXNyYy1kbi8+CgkJCQkJCQkJCQkJCQkJCQkJCTwvYXJnLXN0cmluZz4KCQkJCQkJCQkJCQkJCQkJCQk8L2RvLXNldC14bWwtYXR0cj4KCQkJCQkJCQkJCQkJCQkJCQk8ZG8tc2V0LXhtbC1hdHRyIGV4cHJlc3Npb249Ii4uL2RyaXZlci1vcGVyYXRpb24tZGF0YVtsYXN0KCldIiBuYW1lPSJpcy1zZW5zaXRpdmUiPgoJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLXN0cmluZz4KCQkJCQkJCQkJCQkJCQkJCQkJCTx0b2tlbi10ZXh0IHhtbDpzcGFjZT0icHJlc2VydmUiPnRydWU8L3Rva2VuLXRleHQ+CgkJCQkJCQkJCQkJCQkJCQkJCTwvYXJnLXN0cmluZz4KCQkJCQkJCQkJCQkJCQkJCQk8L2RvLXNldC14bWwtYXR0cj4KCQkJCQkJCQkJCQkJCQkJCQk8IS0tICA8ZG8taWY+CgkJCQkJCQkJCQkJCQkJPGFyZy1jb25kaXRpb25zPgoJCQkJCQkJCQkJCQkJCQk8YW5kPgoJCQkJCQkJCQkJCQkJCQkJPGlmLXBhc3N3b3JkIG9wPSJhdmFpbGFibGUiLz4KCQkJCQkJCQkJCQkJCQkJPC9hbmQ+CgkJCQkJCQkJCQkJCQkJPC9hcmctY29uZGl0aW9ucz4KCQkJCQkJCQkJCQkJCQk8YXJnLWFjdGlvbnM+CgkJCQkJCQkJCQkJCQkJCTxkby1zZXQteG1sLWF0dHIgZXhwcmVzc2lvbj0iLi4vZHJpdmVyLW9wZXJhdGlvbi1kYXRhW2xhc3QoKV0iIG5hbWU9ImlzLXNlbnNpdGl2ZSI+CgkJCQkJCQkJCQkJCQkJCQk8YXJnLXN0cmluZz4KCQkJCQkJCQkJCQkJCQkJCQk8dG9rZW4tdGV4dCB4bWw6c3BhY2U9InByZXNlcnZlIj50cnVlPC90b2tlbi10ZXh0PgoJCQkJCQkJCQkJCQkJCQkJPC9hcmctc3RyaW5nPgoJCQkJCQkJCQkJCQkJCQk8L2RvLXNldC14bWwtYXR0cj4KCQkJCQkJCQkJCQkJCQk8L2FyZy1hY3Rpb25zPgoJCQkJCQkJCQkJCQkJCTxhcmctYWN0aW9ucy8+CgkJCQkJCQkJCQkJCQk8L2RvLWlmPi0tPgoJCQkJCQkJCQkJCQkJCQkJCTxkby1zZXQteG1sLWF0dHIgZXhwcmVzc2lvbj0iLi4vZHJpdmVyLW9wZXJhdGlvbi1kYXRhW2xhc3QoKV0iIG5hbWU9ImNsYXNzLW5hbWUiPgoJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLXN0cmluZz4KCQkJCQkJCQkJCQkJCQkJCQkJCTx0b2tlbi1jbGFzcy1uYW1lLz4KCQkJCQkJCQkJCQkJCQkJCQkJPC9hcmctc3RyaW5nPgoJCQkJCQkJCQkJCQkJCQkJCTwvZG8tc2V0LXhtbC1hdHRyPgoJCQkJCQkJCQkJCQkJCQkJCTxkby1zZXQteG1sLWF0dHIgZXhwcmVzc2lvbj0iLi4vZHJpdmVyLW9wZXJhdGlvbi1kYXRhW2xhc3QoKV0iIG5hbWU9ImV2ZW50LWlkIj4KCQkJCQkJCQkJCQkJCQkJCQkJPGFyZy1zdHJpbmc+CgkJCQkJCQkJCQkJCQkJCQkJCQk8dG9rZW4teHBhdGggZXhwcmVzc2lvbj0iJGN1cnJlbnQtb3AvQGV2ZW50LWlkIi8+CgkJCQkJCQkJCQkJCQkJCQkJCTwvYXJnLXN0cmluZz4KCQkJCQkJCQkJCQkJCQkJCQk8L2RvLXNldC14bWwtYXR0cj4KCQkJCQkJCQkJCQkJCQkJCQk8ZG8taWY+CgkJCQkJCQkJCQkJCQkJCQkJCTxhcmctY29uZGl0aW9ucz4KCQkJCQkJCQkJCQkJCQkJCQkJCTxhbmQ+CgkJCQkJCQkJCQkJCQkJCQkJCQkJPGlmLW9wZXJhdGlvbiBtb2RlPSJub2Nhc2UiIG9wPSJlcXVhbCI+bW9kaWZ5LXBhc3N3b3JkPC9pZi1vcGVyYXRpb24+CgkJCQkJCQkJCQkJCQkJCQkJCQk8L2FuZD4KCQkJCQkJCQkJCQkJCQkJCQkJPC9hcmctY29uZGl0aW9ucz4KCQkJCQkJCQkJCQkJCQkJCQkJPGFyZy1hY3Rpb25zPgoJCQkJCQkJCQkJCQkJCQkJCQkJPGRvLXNldC14bWwtYXR0ciBleHByZXNzaW9uPSIuLi9kcml2ZXItb3BlcmF0aW9uLWRhdGFbbGFzdCgpXSIgbmFtZT0iY29tbWFuZCI+CgkJCQkJCQkJCQkJCQkJCQkJCQkJPGFyZy1zdHJpbmc+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCTx0b2tlbi10ZXh0IHhtbDpzcGFjZT0icHJlc2VydmUiPm1vZGlmeTwvdG9rZW4tdGV4dD4KCQkJCQkJCQkJCQkJCQkJCQkJCQk8L2FyZy1zdHJpbmc+CgkJCQkJCQkJCQkJCQkJCQkJCQk8L2RvLXNldC14bWwtYXR0cj4KCQkJCQkJCQkJCQkJCQkJCQkJPC9hcmctYWN0aW9ucz4KCQkJCQkJCQkJCQkJCQkJCQkJPGFyZy1hY3Rpb25zPgoJCQkJCQkJCQkJCQkJCQkJCQkJPGRvLXNldC14bWwtYXR0ciBleHByZXNzaW9uPSIuLi9kcml2ZXItb3BlcmF0aW9uLWRhdGFbbGFzdCgpXSIgbmFtZT0iY29tbWFuZCI+CgkJCQkJCQkJCQkJCQkJCQkJCQkJPGFyZy1zdHJpbmc+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCTx0b2tlbi1vcGVyYXRpb24vPgoJCQkJCQkJCQkJCQkJCQkJCQkJCTwvYXJnLXN0cmluZz4KCQkJCQkJCQkJCQkJCQkJCQkJCTwvZG8tc2V0LXhtbC1hdHRyPgoJCQkJCQkJCQkJCQkJCQkJCQk8L2FyZy1hY3Rpb25zPgoJCQkJCQkJCQkJCQkJCQkJCTwvZG8taWY+CgkJCQkJCQkJCQkJCQkJCQkJPGRvLWFwcGVuZC14bWwtZWxlbWVudCBleHByZXNzaW9uPSIuLi9kcml2ZXItb3BlcmF0aW9uLWRhdGFbbGFzdCgpXSIgbmFtZT0icmVxdWVzdCIvPgoJCQkJCQkJCQkJCQkJCQkJCTxkby1hcHBlbmQteG1sLWVsZW1lbnQgZXhwcmVzc2lvbj0iLi4vZHJpdmVyLW9wZXJhdGlvbi1kYXRhW2xhc3QoKV0vcmVxdWVzdFtsYXN0KCldIiBuYW1lPSJ1cmwtdG9rZW4iLz4KCQkJCQkJCQkJCQkJCQkJCQk8ZG8taWY+CgkJCQkJCQkJCQkJCQkJCQkJCTxhcmctY29uZGl0aW9ucz4KCQkJCQkJCQkJCQkJCQkJCQkJCTxhbmQ+CgkJCQkJCQkJCQkJCQkJCQkJCQkJPGlmLWFzc29jaWF0aW9uIG9wPSJhdmFpbGFibGUiLz4KCQkJCQkJCQkJCQkJCQkJCQkJCTwvYW5kPgoJCQkJCQkJCQkJCQkJCQkJCQk8L2FyZy1jb25kaXRpb25zPgoJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLWFjdGlvbnM+CgkJCQkJCQkJCQkJCQkJCQkJCQk8ZG8tc2V0LXhtbC1hdHRyIGV4cHJlc3Npb249Ii4uL2RyaXZlci1vcGVyYXRpb24tZGF0YVtsYXN0KCldL3JlcXVlc3RbbGFzdCgpXS91cmwtdG9rZW4iIG5hbWU9ImFzc29jaWF0aW9uIj4KCQkJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLXN0cmluZz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJPHRva2VuLWFzc29jaWF0aW9uLz4KCQkJCQkJCQkJCQkJCQkJCQkJCQk8L2FyZy1zdHJpbmc+CgkJCQkJCQkJCQkJCQkJCQkJCQk8L2RvLXNldC14bWwtYXR0cj4KCQkJCQkJCQkJCQkJCQkJCQkJPC9hcmctYWN0aW9ucz4KCQkJCQkJCQkJCQkJCQkJCQkJPGFyZy1hY3Rpb25zLz4KCQkJCQkJCQkJCQkJCQkJCQk8L2RvLWlmPgoJCQkJCQkJCQkJCQkJCQkJCTxkby1hcHBlbmQteG1sLWVsZW1lbnQgZXhwcmVzc2lvbj0iLi4vZHJpdmVyLW9wZXJhdGlvbi1kYXRhW2xhc3QoKV0vcmVxdWVzdFtsYXN0KCldIiBuYW1lPSJoZWFkZXIiLz4KCQkJCQkJCQkJCQkJCQkJCQk8ZG8tc2V0LXhtbC1hdHRyIGV4cHJlc3Npb249Ii4uL2RyaXZlci1vcGVyYXRpb24tZGF0YVtsYXN0KCldL3JlcXVlc3RbbGFzdCgpXS9oZWFkZXIiIG5hbWU9ImNvbnRlbnQtdHlwZSI+CgkJCQkJCQkJCQkJCQkJCQkJCTxhcmctc3RyaW5nPgoJCQkJCQkJCQkJCQkJCQkJCQkJPHRva2VuLXRleHQgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+YXBwbGljYXRpb24vanNvbjwvdG9rZW4tdGV4dD4KCQkJCQkJCQkJCQkJCQkJCQkJPC9hcmctc3RyaW5nPgoJCQkJCQkJCQkJCQkJCQkJCTwvZG8tc2V0LXhtbC1hdHRyPgoJCQkJCQkJCQkJCQkJCQkJCTxkby1hcHBlbmQteG1sLWVsZW1lbnQgZXhwcmVzc2lvbj0iLi4vZHJpdmVyLW9wZXJhdGlvbi1kYXRhW2xhc3QoKV0vcmVxdWVzdFtsYXN0KCldIiBuYW1lPSJ2YWx1ZSIvPgoJCQkJCQkJCQkJCQkJCQkJCTxkby1hcHBlbmQteG1sLXRleHQgZXhwcmVzc2lvbj0iLi4vZHJpdmVyLW9wZXJhdGlvbi1kYXRhW2xhc3QoKV0vcmVxdWVzdFtsYXN0KCldL3ZhbHVlIj4KCQkJCQkJCQkJCQkJCQkJCQkJPGFyZy1zdHJpbmc+CgkJCQkJCQkJCQkJCQkJCQkJCQk8dG9rZW4tbG9jYWwtdmFyaWFibGUgbmFtZT0iYXBwbGljYXRpb25Db250ZW50Ii8+CgkJCQkJCQkJCQkJCQkJCQkJCTwvYXJnLXN0cmluZz4KCQkJCQkJCQkJCQkJCQkJCQk8L2RvLWFwcGVuZC14bWwtdGV4dD4KCQkJCQkJCQkJCQkJCQkJCTwvYXJnLWFjdGlvbnM+CgkJCQkJCQkJCQkJCQkJCQk8YXJnLWFjdGlvbnM+CgkJCQkJCQkJCQkJCQkJCQkJPGRvLWlmPgoJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLWNvbmRpdGlvbnM+CgkJCQkJCQkJCQkJCQkJCQkJCQk8YW5kPgoJCQkJCQkJCQkJCQkJCQkJCQkJCTxpZi14cGF0aCBvcD0idHJ1ZSI+JGN1cnJlbnQtb3AvQHNjb3BlPSJlbnRyeSI8L2lmLXhwYXRoPgoJCQkJCQkJCQkJCQkJCQkJCQkJPC9hbmQ+CgkJCQkJCQkJCQkJCQkJCQkJCTwvYXJnLWNvbmRpdGlvbnM+CgkJCQkJCQkJCQkJCQkJCQkJCTxhcmctYWN0aW9ucz4KCQkJCQkJCQkJCQkJCQkJCQkJCTxkby1hcHBlbmQteG1sLWVsZW1lbnQgZXhwcmVzc2lvbj0iLi4iIG5hbWU9ImRyaXZlci1vcGVyYXRpb24tZGF0YSIvPgoJCQkJCQkJCQkJCQkJCQkJCQkJPGRvLWlmIGRpc2FibGVkPSJ0cnVlIj4KCQkJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLWNvbmRpdGlvbnM+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCTxhbmQ+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8aWYtZ2xvYmFsLXZhcmlhYmxlIG1vZGU9ImNhc2UiIG5hbWU9ImRydi5hbGxvd3RyYWNpbmciIG9wPSJlcXVhbCI+ZmFsc2U8L2lmLWdsb2JhbC12YXJpYWJsZT4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJPC9hbmQ+CgkJCQkJCQkJCQkJCQkJCQkJCQkJPC9hcmctY29uZGl0aW9ucz4KCQkJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLWFjdGlvbnM+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCTxkby1zZXQteG1sLWF0dHIgZXhwcmVzc2lvbj0iLi4vZHJpdmVyLW9wZXJhdGlvbi1kYXRhW2xhc3QoKV0iIG5hbWU9ImlzLXNlbnNpdGl2ZSI+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLXN0cmluZz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8dG9rZW4tdGV4dCB4bWw6c3BhY2U9InByZXNlcnZlIj5mYWxzZTwvdG9rZW4tdGV4dD4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTwvYXJnLXN0cmluZz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJPC9kby1zZXQteG1sLWF0dHI+CgkJCQkJCQkJCQkJCQkJCQkJCQkJPC9hcmctYWN0aW9ucz4KCQkJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLWFjdGlvbnM+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCTxkby1zZXQteG1sLWF0dHIgZXhwcmVzc2lvbj0iLi4vZHJpdmVyLW9wZXJhdGlvbi1kYXRhW2xhc3QoKV0iIG5hbWU9ImlzLXNlbnNpdGl2ZSI+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLXN0cmluZz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8dG9rZW4tdGV4dCB4bWw6c3BhY2U9InByZXNlcnZlIj50cnVlPC90b2tlbi10ZXh0PgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPC9hcmctc3RyaW5nPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQk8L2RvLXNldC14bWwtYXR0cj4KCQkJCQkJCQkJCQkJCQkJCQkJCQk8L2FyZy1hY3Rpb25zPgoJCQkJCQkJCQkJCQkJCQkJCQkJPC9kby1pZj4KCQkJCQkJCQkJCQkJCQkJCQkJCTxkby1zZXQteG1sLWF0dHIgZXhwcmVzc2lvbj0iLi4vZHJpdmVyLW9wZXJhdGlvbi1kYXRhW2xhc3QoKV0iIG5hbWU9ImNsYXNzLW5hbWUiPgoJCQkJCQkJCQkJCQkJCQkJCQkJCTxhcmctc3RyaW5nPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQk8dG9rZW4tY2xhc3MtbmFtZS8+CgkJCQkJCQkJCQkJCQkJCQkJCQkJPC9hcmctc3RyaW5nPgoJCQkJCQkJCQkJCQkJCQkJCQkJPC9kby1zZXQteG1sLWF0dHI+CgkJCQkJCQkJCQkJCQkJCQkJCQk8ZG8tc2V0LXhtbC1hdHRyIGV4cHJlc3Npb249Ii4uL2RyaXZlci1vcGVyYXRpb24tZGF0YVtsYXN0KCldIiBuYW1lPSJjb21tYW5kIj4KCQkJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLXN0cmluZz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJPHRva2VuLW9wZXJhdGlvbi8+CgkJCQkJCQkJCQkJCQkJCQkJCQkJPC9hcmctc3RyaW5nPgoJCQkJCQkJCQkJCQkJCQkJCQkJPC9kby1zZXQteG1sLWF0dHI+CgkJCQkJCQkJCQkJCQkJCQkJCQk8ZG8tc2V0LXhtbC1hdHRyIGV4cHJlc3Npb249Ii4uL2RyaXZlci1vcGVyYXRpb24tZGF0YVtsYXN0KCldIiBuYW1lPSJldmVudC1pZCI+CgkJCQkJCQkJCQkJCQkJCQkJCQkJPGFyZy1zdHJpbmc+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCTx0b2tlbi14cGF0aCBleHByZXNzaW9uPSIkY3VycmVudC1vcC9AZXZlbnQtaWQiLz4KCQkJCQkJCQkJCQkJCQkJCQkJCQk8L2FyZy1zdHJpbmc+CgkJCQkJCQkJCQkJCQkJCQkJCQk8L2RvLXNldC14bWwtYXR0cj4KCQkJCQkJCQkJCQkJCQkJCQkJCTxkby1hcHBlbmQteG1sLWVsZW1lbnQgZXhwcmVzc2lvbj0iLi4vZHJpdmVyLW9wZXJhdGlvbi1kYXRhW2xhc3QoKV0iIG5hbWU9InJlcXVlc3QiLz4KCQkJCQkJCQkJCQkJCQkJCQkJCTxkby1pZj4KCQkJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLWNvbmRpdGlvbnM+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCTxhbmQ+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8aWYtYXNzb2NpYXRpb24gb3A9ImF2YWlsYWJsZSIvPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQk8L2FuZD4KCQkJCQkJCQkJCQkJCQkJCQkJCQk8L2FyZy1jb25kaXRpb25zPgoJCQkJCQkJCQkJCQkJCQkJCQkJCTxhcmctYWN0aW9ucz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJPGRvLXNldC1sb2NhbC12YXJpYWJsZSBuYW1lPSJhc3NvY2lhdGlvbkhvbGRlciIgc2NvcGU9InBvbGljeSI+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLXN0cmluZz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8dG9rZW4tYXNzb2NpYXRpb24vPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPC9hcmctc3RyaW5nPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQk8L2RvLXNldC1sb2NhbC12YXJpYWJsZT4KCQkJCQkJCQkJCQkJCQkJCQkJCQk8L2FyZy1hY3Rpb25zPgoJCQkJCQkJCQkJCQkJCQkJCQkJCTxhcmctYWN0aW9ucz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJPGRvLXNldC1sb2NhbC12YXJpYWJsZSBuYW1lPSJhc3NvY2lhdGlvbkhvbGRlciIgc2NvcGU9InBvbGljeSI+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLXN0cmluZz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8dG9rZW4tdGV4dCB4bWw6c3BhY2U9InByZXNlcnZlIj4vPC90b2tlbi10ZXh0PgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTx0b2tlbi1kZXN0LWRuLz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTwvYXJnLXN0cmluZz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJPC9kby1zZXQtbG9jYWwtdmFyaWFibGU+CgkJCQkJCQkJCQkJCQkJCQkJCQkJPC9hcmctYWN0aW9ucz4KCQkJCQkJCQkJCQkJCQkJCQkJCTwvZG8taWY+CgkJCQkJCQkJCQkJCQkJCQkJCQk8ZG8tYXBwZW5kLXhtbC1lbGVtZW50IGV4cHJlc3Npb249Ii4uL2RyaXZlci1vcGVyYXRpb24tZGF0YVtsYXN0KCldL3JlcXVlc3RbbGFzdCgpXSIgbmFtZT0idXJsLXRva2VuIi8+CgkJCQkJCQkJCQkJCQkJCQkJCQk8ZG8tc2V0LXhtbC1hdHRyIGV4cHJlc3Npb249Ii4uL2RyaXZlci1vcGVyYXRpb24tZGF0YVtsYXN0KCldL3JlcXVlc3RbbGFzdCgpXS91cmwtdG9rZW4iIG5hbWU9ImFzc29jaWF0aW9uIj4KCQkJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLXN0cmluZz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJPHRva2VuLWxvY2FsLXZhcmlhYmxlIG5hbWU9ImFzc29jaWF0aW9uSG9sZGVyIi8+CgkJCQkJCQkJCQkJCQkJCQkJCQkJPC9hcmctc3RyaW5nPgoJCQkJCQkJCQkJCQkJCQkJCQkJPC9kby1zZXQteG1sLWF0dHI+CgkJCQkJCQkJCQkJCQkJCQkJCQk8ZG8tYXBwZW5kLXhtbC1lbGVtZW50IGV4cHJlc3Npb249Ii4uL2RyaXZlci1vcGVyYXRpb24tZGF0YVtsYXN0KCldL3JlcXVlc3RbbGFzdCgpXSIgbmFtZT0iaGVhZGVyIi8+CgkJCQkJCQkJCQkJCQkJCQkJCQk8ZG8tc2V0LXhtbC1hdHRyIGV4cHJlc3Npb249Ii4uL2RyaXZlci1vcGVyYXRpb24tZGF0YVtsYXN0KCldL3JlcXVlc3RbbGFzdCgpXS9oZWFkZXIiIG5hbWU9ImNvbnRlbnQtdHlwZSI+CgkJCQkJCQkJCQkJCQkJCQkJCQkJPGFyZy1zdHJpbmc+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCTx0b2tlbi10ZXh0IHhtbDpzcGFjZT0icHJlc2VydmUiPmFwcGxpY2F0aW9uL2pzb248L3Rva2VuLXRleHQ+CgkJCQkJCQkJCQkJCQkJCQkJCQkJPC9hcmctc3RyaW5nPgoJCQkJCQkJCQkJCQkJCQkJCQkJPC9kby1zZXQteG1sLWF0dHI+CgkJCQkJCQkJCQkJCQkJCQkJCQk8ZG8tYXBwZW5kLXhtbC1lbGVtZW50IGV4cHJlc3Npb249Ii4uL2RyaXZlci1vcGVyYXRpb24tZGF0YVtsYXN0KCldL3JlcXVlc3RbbGFzdCgpXSIgbmFtZT0idmFsdWUiLz4KCQkJCQkJCQkJCQkJCQkJCQkJCTxkby1hcHBlbmQteG1sLXRleHQgZXhwcmVzc2lvbj0iLi4vZHJpdmVyLW9wZXJhdGlvbi1kYXRhW2xhc3QoKV0vcmVxdWVzdFtsYXN0KCldL3ZhbHVlIj4KCQkJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLXN0cmluZz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJPHRva2VuLWxvY2FsLXZhcmlhYmxlIG5hbWU9ImFwcGxpY2F0aW9uQ29udGVudCIvPgoJCQkJCQkJCQkJCQkJCQkJCQkJCTwvYXJnLXN0cmluZz4KCQkJCQkJCQkJCQkJCQkJCQkJCTwvZG8tYXBwZW5kLXhtbC10ZXh0PgoJCQkJCQkJCQkJCQkJCQkJCQk8L2FyZy1hY3Rpb25zPgoJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLWFjdGlvbnM+CgkJCQkJCQkJCQkJCQkJCQkJCQk8ZG8tc2V0LWxvY2FsLXZhcmlhYmxlIG5hbWU9InNlYXJjaENsYXNzZXMiIHNjb3BlPSJwb2xpY3kiPgoJCQkJCQkJCQkJCQkJCQkJCQkJCTxhcmctbm9kZS1zZXQ+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCTx0b2tlbi14cGF0aCBleHByZXNzaW9uPSIkY3VycmVudC1vcC9zZWFyY2gtY2xhc3MiLz4KCQkJCQkJCQkJCQkJCQkJCQkJCQk8L2FyZy1ub2RlLXNldD4KCQkJCQkJCQkJCQkJCQkJCQkJCTwvZG8tc2V0LWxvY2FsLXZhcmlhYmxlPgoJCQkJCQkJCQkJCQkJCQkJCQkJPGRvLWZvci1lYWNoPgoJCQkJCQkJCQkJCQkJCQkJCQkJCTxhcmctbm9kZS1zZXQ+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCTx0b2tlbi1sb2NhbC12YXJpYWJsZSBuYW1lPSJzZWFyY2hDbGFzc2VzIi8+CgkJCQkJCQkJCQkJCQkJCQkJCQkJPC9hcmctbm9kZS1zZXQ+CgkJCQkJCQkJCQkJCQkJCQkJCQkJPGFyZy1hY3Rpb25zPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQk8ZG8tYXBwZW5kLXhtbC1lbGVtZW50IGV4cHJlc3Npb249Ii4uIiBuYW1lPSJkcml2ZXItb3BlcmF0aW9uLWRhdGEiLz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJPGRvLXNldC14bWwtYXR0ciBleHByZXNzaW9uPSIuLi9kcml2ZXItb3BlcmF0aW9uLWRhdGFbbGFzdCgpXSIgbmFtZT0iY2xhc3MtbmFtZSI+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLXN0cmluZz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8dG9rZW4tY2xhc3MtbmFtZS8+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8L2FyZy1zdHJpbmc+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCTwvZG8tc2V0LXhtbC1hdHRyPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQk8ZG8tc2V0LXhtbC1hdHRyIGV4cHJlc3Npb249Ii4uL2RyaXZlci1vcGVyYXRpb24tZGF0YVtsYXN0KCldIiBuYW1lPSJjb21tYW5kIj4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTxhcmctc3RyaW5nPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTx0b2tlbi1vcGVyYXRpb24vPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPC9hcmctc3RyaW5nPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQk8L2RvLXNldC14bWwtYXR0cj4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJPGRvLXNldC14bWwtYXR0ciBleHByZXNzaW9uPSIuLi9kcml2ZXItb3BlcmF0aW9uLWRhdGFbbGFzdCgpXSIgbmFtZT0iZXZlbnQtaWQiPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPGFyZy1zdHJpbmc+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPHRva2VuLXhwYXRoIGV4cHJlc3Npb249IiRjdXJyZW50LW9wL0BldmVudC1pZCIvPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPC9hcmctc3RyaW5nPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQk8L2RvLXNldC14bWwtYXR0cj4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJPGRvLWFwcGVuZC14bWwtZWxlbWVudCBleHByZXNzaW9uPSIuLi9kcml2ZXItb3BlcmF0aW9uLWRhdGFbbGFzdCgpXSIgbmFtZT0icmVxdWVzdCIvPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQk8ZG8tYXBwZW5kLXhtbC1lbGVtZW50IGV4cHJlc3Npb249Ii4uL2RyaXZlci1vcGVyYXRpb24tZGF0YVtsYXN0KCldL3JlcXVlc3RbbGFzdCgpXSIgbmFtZT0idXJsLXRva2VuIi8+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCTxkby1hcHBlbmQteG1sLWVsZW1lbnQgZXhwcmVzc2lvbj0iLi4vZHJpdmVyLW9wZXJhdGlvbi1kYXRhW2xhc3QoKV0vcmVxdWVzdFtsYXN0KCldIiBuYW1lPSJoZWFkZXIiLz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJPGRvLXNldC14bWwtYXR0ciBleHByZXNzaW9uPSIuLi9kcml2ZXItb3BlcmF0aW9uLWRhdGFbbGFzdCgpXS9yZXF1ZXN0W2xhc3QoKV0vaGVhZGVyIiBuYW1lPSJjb250ZW50LXR5cGUiPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPGFyZy1zdHJpbmc+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPHRva2VuLXRleHQgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+YXBwbGljYXRpb24vanNvbjwvdG9rZW4tdGV4dD4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTwvYXJnLXN0cmluZz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJPC9kby1zZXQteG1sLWF0dHI+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCTxkby1hcHBlbmQteG1sLWVsZW1lbnQgZXhwcmVzc2lvbj0iLi4vZHJpdmVyLW9wZXJhdGlvbi1kYXRhW2xhc3QoKV0vcmVxdWVzdFtsYXN0KCldIiBuYW1lPSJ2YWx1ZSIvPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQk8ZG8tYXBwZW5kLXhtbC10ZXh0IGV4cHJlc3Npb249Ii4uL2RyaXZlci1vcGVyYXRpb24tZGF0YVtsYXN0KCldL3JlcXVlc3RbbGFzdCgpXS92YWx1ZSI+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLXN0cmluZz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8dG9rZW4tbG9jYWwtdmFyaWFibGUgbmFtZT0iYXBwbGljYXRpb25Db250ZW50Ii8+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8L2FyZy1zdHJpbmc+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCTwvZG8tYXBwZW5kLXhtbC10ZXh0PgoJCQkJCQkJCQkJCQkJCQkJCQkJCQk8ZG8tc2V0LWxvY2FsLXZhcmlhYmxlIG5hbWU9InNlYXJjaEF0dHJzIiBzY29wZT0icG9saWN5Ij4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTxhcmctbm9kZS1zZXQ+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPHRva2VuLXhwYXRoIGV4cHJlc3Npb249IiRjdXJyZW50LW9wL3NlYXJjaC1hdHRyIi8+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8L2FyZy1ub2RlLXNldD4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJPC9kby1zZXQtbG9jYWwtdmFyaWFibGU+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCTxkby1mb3ItZWFjaD4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTxhcmctbm9kZS1zZXQ+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPHRva2VuLWxvY2FsLXZhcmlhYmxlIG5hbWU9InNlYXJjaEF0dHJzIi8+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8L2FyZy1ub2RlLXNldD4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTxhcmctYWN0aW9ucz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8ZG8taWY+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTxhcmctY29uZGl0aW9ucz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTxhbmQ+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPGlmLWxvY2FsLXZhcmlhYmxlIG5hbWU9ImZpbHRlclRleHQiIG9wPSJhdmFpbGFibGUiLz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTwvYW5kPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8L2FyZy1jb25kaXRpb25zPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLWFjdGlvbnM+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8ZG8tc2V0LWxvY2FsLXZhcmlhYmxlIG5hbWU9ImZpbHRlclRleHQiIHNjb3BlPSJwb2xpY3kiPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTxhcmctc3RyaW5nPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8dG9rZW4teHBhdGggZXhwcmVzc2lvbj0iJGN1cnJlbnQtbm9kZS9AYXR0ci1uYW1lIi8+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTx0b2tlbi10ZXh0IHhtbDpzcGFjZT0icHJlc2VydmUiPiBlcSAnPC90b2tlbi10ZXh0PgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8dG9rZW4teHBhdGggZXhwcmVzc2lvbj0iJGN1cnJlbnQtbm9kZS92YWx1ZS90ZXh0KCkiLz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPHRva2VuLXRleHQgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+JzwvdG9rZW4tdGV4dD4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPHRva2VuLXRleHQgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+IGFuZCA8L3Rva2VuLXRleHQ+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTx0b2tlbi1sb2NhbC12YXJpYWJsZSBuYW1lPSJmaWx0ZXJUZXh0Ii8+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPC9hcmctc3RyaW5nPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPC9kby1zZXQtbG9jYWwtdmFyaWFibGU+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTwvYXJnLWFjdGlvbnM+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTxhcmctYWN0aW9ucz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTxkby1zZXQtbG9jYWwtdmFyaWFibGUgbmFtZT0iZmlsdGVyVGV4dCIgc2NvcGU9InBvbGljeSI+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPGFyZy1zdHJpbmc+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTx0b2tlbi14cGF0aCBleHByZXNzaW9uPSIkY3VycmVudC1ub2RlL0BhdHRyLW5hbWUiLz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPHRva2VuLXRleHQgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+IGVxICc8L3Rva2VuLXRleHQ+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTx0b2tlbi14cGF0aCBleHByZXNzaW9uPSIkY3VycmVudC1ub2RlL3ZhbHVlL3RleHQoKSIvPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8dG9rZW4tdGV4dCB4bWw6c3BhY2U9InByZXNlcnZlIj4nPC90b2tlbi10ZXh0PgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTwvYXJnLXN0cmluZz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTwvZG8tc2V0LWxvY2FsLXZhcmlhYmxlPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8L2FyZy1hY3Rpb25zPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTwvZG8taWY+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8L2FyZy1hY3Rpb25zPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQk8L2RvLWZvci1lYWNoPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQk8ZG8tc2V0LWxvY2FsLXZhcmlhYmxlIG5hbWU9ImZpbHRlclRleHQiIHNjb3BlPSJwb2xpY3kiPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPGFyZy1zdHJpbmc+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPHRva2VuLXhwYXRoIGV4cHJlc3Npb249J3JzOnVybEVuY29kZSgkZmlsdGVyVGV4dCwiVVRGLTgiKScvPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPC9hcmctc3RyaW5nPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQk8L2RvLXNldC1sb2NhbC12YXJpYWJsZT4KCQkJCQkJCQkJCQkJCQkJCQkJCQk8L2FyZy1hY3Rpb25zPgoJCQkJCQkJCQkJCQkJCQkJCQkJPC9kby1mb3ItZWFjaD4KCQkJCQkJCQkJCQkJCQkJCQkJPC9hcmctYWN0aW9ucz4KCQkJCQkJCQkJCQkJCQkJCQk8L2RvLWlmPgoJCQkJCQkJCQkJCQkJCQkJCTxkby1zZXQtbG9jYWwtdmFyaWFibGUgbmFtZT0icmVhZEF0dHJzIiBzY29wZT0icG9saWN5Ij4KCQkJCQkJCQkJCQkJCQkJCQkJPGFyZy1ub2RlLXNldD4KCQkJCQkJCQkJCQkJCQkJCQkJCTx0b2tlbi14cGF0aCBleHByZXNzaW9uPSIkY3VycmVudC1vcC9yZWFkLWF0dHIiLz4KCQkJCQkJCQkJCQkJCQkJCQkJPC9hcmctbm9kZS1zZXQ+CgkJCQkJCQkJCQkJCQkJCQkJPC9kby1zZXQtbG9jYWwtdmFyaWFibGU+CgkJCQkJCQkJCQkJCQkJCQkJPGRvLWlmPgoJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLWNvbmRpdGlvbnM+CgkJCQkJCQkJCQkJCQkJCQkJCQk8YW5kPgoJCQkJCQkJCQkJCQkJCQkJCQkJCTxpZi14cGF0aCBvcD0idHJ1ZSI+Y291bnQoJHJlYWRBdHRycyk+MDwvaWYteHBhdGg+CgkJCQkJCQkJCQkJCQkJCQkJCQk8L2FuZD4KCQkJCQkJCQkJCQkJCQkJCQkJPC9hcmctY29uZGl0aW9ucz4KCQkJCQkJCQkJCQkJCQkJCQkJPGFyZy1hY3Rpb25zPgoJCQkJCQkJCQkJCQkJCQkJCQkJPGRvLWZvci1lYWNoPgoJCQkJCQkJCQkJCQkJCQkJCQkJCTxhcmctbm9kZS1zZXQ+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCTx0b2tlbi1sb2NhbC12YXJpYWJsZSBuYW1lPSJyZWFkQXR0cnMiLz4KCQkJCQkJCQkJCQkJCQkJCQkJCQk8L2FyZy1ub2RlLXNldD4KCQkJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLWFjdGlvbnM+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCTxkby1pZj4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTxhcmctY29uZGl0aW9ucz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8YW5kPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8aWYtbG9jYWwtdmFyaWFibGUgbmFtZT0icmVhZEF0dHJUZXh0IiBvcD0ibm90LWF2YWlsYWJsZSIvPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTwvYW5kPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPC9hcmctY29uZGl0aW9ucz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTxhcmctYWN0aW9ucz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8ZG8tc2V0LWxvY2FsLXZhcmlhYmxlIG5hbWU9InJlYWRBdHRyVGV4dCIgc2NvcGU9InBvbGljeSI+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTxhcmctc3RyaW5nPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPHRva2VuLXRleHQgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+JzwvdG9rZW4tdGV4dD4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTx0b2tlbi14cGF0aCBleHByZXNzaW9uPSIkY3VycmVudC1ub2RlL0BhdHRyLW5hbWUiLz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTx0b2tlbi10ZXh0IHhtbDpzcGFjZT0icHJlc2VydmUiPic8L3Rva2VuLXRleHQ+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTwvYXJnLXN0cmluZz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8L2RvLXNldC1sb2NhbC12YXJpYWJsZT4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTwvYXJnLWFjdGlvbnM+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLWFjdGlvbnM+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPGRvLXNldC1sb2NhbC12YXJpYWJsZSBuYW1lPSJyZWFkQXR0clRleHQiIHNjb3BlPSJwb2xpY3kiPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLXN0cmluZz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTx0b2tlbi10ZXh0IHhtbDpzcGFjZT0icHJlc2VydmUiPic8L3Rva2VuLXRleHQ+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8dG9rZW4teHBhdGggZXhwcmVzc2lvbj0iJGN1cnJlbnQtbm9kZS9AYXR0ci1uYW1lIi8+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8dG9rZW4tdGV4dCB4bWw6c3BhY2U9InByZXNlcnZlIj4nPC90b2tlbi10ZXh0PgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPHRva2VuLXRleHQgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+YW5kPC90b2tlbi10ZXh0PgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPHRva2VuLWxvY2FsLXZhcmlhYmxlIG5hbWU9InJlYWRBdHRyVGV4dCIvPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8L2FyZy1zdHJpbmc+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPC9kby1zZXQtbG9jYWwtdmFyaWFibGU+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8L2FyZy1hY3Rpb25zPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQk8L2RvLWlmPgoJCQkJCQkJCQkJCQkJCQkJCQkJCTwvYXJnLWFjdGlvbnM+CgkJCQkJCQkJCQkJCQkJCQkJCQk8L2RvLWZvci1lYWNoPgoJCQkJCQkJCQkJCQkJCQkJCQkJPGRvLWlmPgoJCQkJCQkJCQkJCQkJCQkJCQkJCTxhcmctY29uZGl0aW9ucz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJPGFuZD4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTxpZi1sb2NhbC12YXJpYWJsZSBtb2RlPSJjYXNlIiBuYW1lPSJyZWFkQXR0clRleHQiIG9wPSJub3QtZXF1YWwiPicnPC9pZi1sb2NhbC12YXJpYWJsZT4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJPC9hbmQ+CgkJCQkJCQkJCQkJCQkJCQkJCQkJPC9hcmctY29uZGl0aW9ucz4KCQkJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLWFjdGlvbnM+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCTxkby1zZXQtbG9jYWwtdmFyaWFibGUgbmFtZT0icmVhZEF0dHJUZXh0IiBzY29wZT0icG9saWN5Ij4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTxhcmctc3RyaW5nPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTx0b2tlbi14cGF0aCBleHByZXNzaW9uPSdyczp1cmxFbmNvZGUoJHJlYWRBdHRyVGV4dCwiVVRGLTgiKScvPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPC9hcmctc3RyaW5nPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQk8L2RvLXNldC1sb2NhbC12YXJpYWJsZT4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJPGRvLWlmPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPGFyZy1jb25kaXRpb25zPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTxhbmQ+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTxpZi14cGF0aCBvcD0idHJ1ZSI+JGN1cnJlbnQtb3AvQHNjb3BlPSJlbnRyeSI8L2lmLXhwYXRoPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTwvYW5kPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPC9hcmctY29uZGl0aW9ucz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTxhcmctYWN0aW9ucz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8ZG8tc2V0LXhtbC1hdHRyIGV4cHJlc3Npb249Ii4uL2RyaXZlci1vcGVyYXRpb24tZGF0YVtsYXN0KCldL3JlcXVlc3RbbGFzdCgpXS91cmwtdG9rZW4iIG5hbWU9ImZpbHRlciI+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTxhcmctc3RyaW5nPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPHRva2VuLXRleHQgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+P3JlYWQtYXR0cj08L3Rva2VuLXRleHQ+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8dG9rZW4tbG9jYWwtdmFyaWFibGUgbmFtZT0icmVhZEF0dHJUZXh0Ii8+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTwvYXJnLXN0cmluZz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8L2RvLXNldC14bWwtYXR0cj4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTwvYXJnLWFjdGlvbnM+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLWFjdGlvbnM+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPGRvLXNldC14bWwtYXR0ciBleHByZXNzaW9uPSIuLi9kcml2ZXItb3BlcmF0aW9uLWRhdGFbbGFzdCgpXS9yZXF1ZXN0W2xhc3QoKV0vdXJsLXRva2VuIiBuYW1lPSJmaWx0ZXIiPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLXN0cmluZz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTx0b2tlbi10ZXh0IHhtbDpzcGFjZT0icHJlc2VydmUiPj9zZWFyY2gtYXR0cj08L3Rva2VuLXRleHQ+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8dG9rZW4tbG9jYWwtdmFyaWFibGUgbmFtZT0iZmlsdGVyVGV4dCIvPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPHRva2VuLXRleHQgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+JmFtcDtyZWFkLWF0dHI9PC90b2tlbi10ZXh0PgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPHRva2VuLWxvY2FsLXZhcmlhYmxlIG5hbWU9InJlYWRBdHRyVGV4dCIvPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8L2FyZy1zdHJpbmc+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPC9kby1zZXQteG1sLWF0dHI+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8L2FyZy1hY3Rpb25zPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQk8L2RvLWlmPgoJCQkJCQkJCQkJCQkJCQkJCQkJCTwvYXJnLWFjdGlvbnM+CgkJCQkJCQkJCQkJCQkJCQkJCQkJPGFyZy1hY3Rpb25zPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQk8ZG8tc2V0LWxvY2FsLXZhcmlhYmxlIG5hbWU9InJlYWRBdHRyVGV4dCIgc2NvcGU9InBvbGljeSI+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLXN0cmluZz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8dG9rZW4teHBhdGggZXhwcmVzc2lvbj0ncnM6dXJsRW5jb2RlKCIiLCJVVEYtOCIpJy8+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8L2FyZy1zdHJpbmc+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCTwvZG8tc2V0LWxvY2FsLXZhcmlhYmxlPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQk8ZG8taWY+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLWNvbmRpdGlvbnM+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPGFuZD4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPGlmLXhwYXRoIG9wPSJ0cnVlIj4kY3VycmVudC1vcC9Ac2NvcGU9ImVudHJ5IjwvaWYteHBhdGg+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPC9hbmQ+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8L2FyZy1jb25kaXRpb25zPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPGFyZy1hY3Rpb25zPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTxkby1zZXQteG1sLWF0dHIgZXhwcmVzc2lvbj0iLi4vZHJpdmVyLW9wZXJhdGlvbi1kYXRhW2xhc3QoKV0vcmVxdWVzdFtsYXN0KCldL3VybC10b2tlbiIgbmFtZT0iZmlsdGVyIj4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPGFyZy1zdHJpbmc+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8dG9rZW4tdGV4dCB4bWw6c3BhY2U9InByZXNlcnZlIj4/cmVhZC1hdHRyPTwvdG9rZW4tdGV4dD4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTx0b2tlbi1sb2NhbC12YXJpYWJsZSBuYW1lPSJyZWFkQXR0clRleHQiLz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPC9hcmctc3RyaW5nPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTwvZG8tc2V0LXhtbC1hdHRyPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPC9hcmctYWN0aW9ucz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTxhcmctYWN0aW9ucz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8ZG8tc2V0LXhtbC1hdHRyIGV4cHJlc3Npb249Ii4uL2RyaXZlci1vcGVyYXRpb24tZGF0YVtsYXN0KCldL3JlcXVlc3RbbGFzdCgpXS91cmwtdG9rZW4iIG5hbWU9ImZpbHRlciI+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTxhcmctc3RyaW5nPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJPHRva2VuLXRleHQgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+P3NlYXJjaC1hdHRyPTwvdG9rZW4tdGV4dD4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTx0b2tlbi1sb2NhbC12YXJpYWJsZSBuYW1lPSJmaWx0ZXJUZXh0Ii8+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8dG9rZW4tdGV4dCB4bWw6c3BhY2U9InByZXNlcnZlIj4mYW1wO3JlYWQtYXR0cj08L3Rva2VuLXRleHQ+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8dG9rZW4tbG9jYWwtdmFyaWFibGUgbmFtZT0icmVhZEF0dHJUZXh0Ii8+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTwvYXJnLXN0cmluZz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk8L2RvLXNldC14bWwtYXR0cj4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJCTwvYXJnLWFjdGlvbnM+CgkJCQkJCQkJCQkJCQkJCQkJCQkJCTwvZG8taWY+CgkJCQkJCQkJCQkJCQkJCQkJCQkJPC9hcmctYWN0aW9ucz4KCQkJCQkJCQkJCQkJCQkJCQkJCTwvZG8taWY+CgkJCQkJCQkJCQkJCQkJCQkJCTwvYXJnLWFjdGlvbnM+CgkJCQkJCQkJCQkJCQkJCQkJCTxhcmctYWN0aW9ucz4KCQkJCQkJCQkJCQkJCQkJCQkJCTxkby1zZXQtbG9jYWwtdmFyaWFibGUgbmFtZT0icmVhZEF0dHJUZXh0IiBzY29wZT0icG9saWN5Ij4KCQkJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLXN0cmluZz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJPHRva2VuLXhwYXRoIGV4cHJlc3Npb249J3JzOnVybEVuY29kZSgiKiIsIlVURi04IiknLz4KCQkJCQkJCQkJCQkJCQkJCQkJCQk8L2FyZy1zdHJpbmc+CgkJCQkJCQkJCQkJCQkJCQkJCQk8L2RvLXNldC1sb2NhbC12YXJpYWJsZT4KCQkJCQkJCQkJCQkJCQkJCQkJCTxkby1zZXQteG1sLWF0dHIgZXhwcmVzc2lvbj0iLi4vZHJpdmVyLW9wZXJhdGlvbi1kYXRhW2xhc3QoKV0vcmVxdWVzdFtsYXN0KCldL3VybC10b2tlbiIgbmFtZT0iZmlsdGVyIj4KCQkJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLXN0cmluZz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJPHRva2VuLXRleHQgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+P3NlYXJjaC1hdHRyPTwvdG9rZW4tdGV4dD4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJPHRva2VuLWxvY2FsLXZhcmlhYmxlIG5hbWU9ImZpbHRlclRleHQiLz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJPHRva2VuLXRleHQgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+JmFtcDtyZWFkLWF0dHI9PC90b2tlbi10ZXh0PgoJCQkJCQkJCQkJCQkJCQkJCQkJCQk8dG9rZW4tbG9jYWwtdmFyaWFibGUgbmFtZT0icmVhZEF0dHJUZXh0Ii8+CgkJCQkJCQkJCQkJCQkJCQkJCQkJPC9hcmctc3RyaW5nPgoJCQkJCQkJCQkJCQkJCQkJCQkJPC9kby1zZXQteG1sLWF0dHI+CgkJCQkJCQkJCQkJCQkJCQkJCTwvYXJnLWFjdGlvbnM+CgkJCQkJCQkJCQkJCQkJCQkJPC9kby1pZj4KCQkJCQkJCQkJCQkJCQkJCTwvYXJnLWFjdGlvbnM+CgkJCQkJCQkJCQkJCQkJCTwvZG8taWY+CgkJCQkJCQkJCQkJCQkJPC9hcmctYWN0aW9ucz4KCQkJCQkJCQkJCQkJCQk8YXJnLWFjdGlvbnM+CgkJCQkJCQkJCQkJCQkJCTxkby1pZj4KCQkJCQkJCQkJCQkJCQkJCTxhcmctY29uZGl0aW9ucz4KCQkJCQkJCQkJCQkJCQkJCQk8YW5kPgoJCQkJCQkJCQkJCQkJCQkJCQk8aWYtb3BlcmF0aW9uIG1vZGU9InJlZ2V4IiBvcD0iZXF1YWwiPmRlbGV0ZXxtb2RpZnktcGFzc3dvcmQ8L2lmLW9wZXJhdGlvbj4KCQkJCQkJCQkJCQkJCQkJCQk8L2FuZD4KCQkJCQkJCQkJCQkJCQkJCTwvYXJnLWNvbmRpdGlvbnM+CgkJCQkJCQkJCQkJCQkJCQk8YXJnLWFjdGlvbnM+CgkJCQkJCQkJCQkJCQkJCQkJPGRvLWFwcGVuZC14bWwtZWxlbWVudCBleHByZXNzaW9uPSIuLiIgbmFtZT0iZHJpdmVyLW9wZXJhdGlvbi1kYXRhIi8+CgkJCQkJCQkJCQkJCQkJCQkJPGRvLWlmPgoJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLWNvbmRpdGlvbnM+CgkJCQkJCQkJCQkJCQkJCQkJCQk8YW5kPgoJCQkJCQkJCQkJCQkJCQkJCQkJCTxpZi1wYXNzd29yZCBvcD0iYXZhaWxhYmxlIi8+CgkJCQkJCQkJCQkJCQkJCQkJCQk8L2FuZD4KCQkJCQkJCQkJCQkJCQkJCQkJPC9hcmctY29uZGl0aW9ucz4KCQkJCQkJCQkJCQkJCQkJCQkJPGFyZy1hY3Rpb25zPgoJCQkJCQkJCQkJCQkJCQkJCQkJPGRvLXNldC14bWwtYXR0ciBleHByZXNzaW9uPSIuLi9kcml2ZXItb3BlcmF0aW9uLWRhdGFbbGFzdCgpXSIgbmFtZT0iaXMtc2Vuc2l0aXZlIj4KCQkJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLXN0cmluZz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJPHRva2VuLXRleHQgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+dHJ1ZTwvdG9rZW4tdGV4dD4KCQkJCQkJCQkJCQkJCQkJCQkJCQk8L2FyZy1zdHJpbmc+CgkJCQkJCQkJCQkJCQkJCQkJCQk8L2RvLXNldC14bWwtYXR0cj4KCQkJCQkJCQkJCQkJCQkJCQkJPC9hcmctYWN0aW9ucz4KCQkJCQkJCQkJCQkJCQkJCQkJPGFyZy1hY3Rpb25zLz4KCQkJCQkJCQkJCQkJCQkJCQk8L2RvLWlmPgoJCQkJCQkJCQkJCQkJCQkJCTxkby1zZXQteG1sLWF0dHIgZXhwcmVzc2lvbj0iLi4vZHJpdmVyLW9wZXJhdGlvbi1kYXRhW2xhc3QoKV0iIG5hbWU9ImNsYXNzLW5hbWUiPgoJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLXN0cmluZz4KCQkJCQkJCQkJCQkJCQkJCQkJCTx0b2tlbi1jbGFzcy1uYW1lLz4KCQkJCQkJCQkJCQkJCQkJCQkJPC9hcmctc3RyaW5nPgoJCQkJCQkJCQkJCQkJCQkJCTwvZG8tc2V0LXhtbC1hdHRyPgoJCQkJCQkJCQkJCQkJCQkJCTxkby1pZj4KCQkJCQkJCQkJCQkJCQkJCQkJPGFyZy1jb25kaXRpb25zPgoJCQkJCQkJCQkJCQkJCQkJCQkJPGFuZD4KCQkJCQkJCQkJCQkJCQkJCQkJCQk8aWYtb3BlcmF0aW9uIG1vZGU9Im5vY2FzZSIgb3A9ImVxdWFsIj5tb2RpZnktcGFzc3dvcmQ8L2lmLW9wZXJhdGlvbj4KCQkJCQkJCQkJCQkJCQkJCQkJCTwvYW5kPgoJCQkJCQkJCQkJCQkJCQkJCQk8L2FyZy1jb25kaXRpb25zPgoJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLWFjdGlvbnM+CgkJCQkJCQkJCQkJCQkJCQkJCQk8ZG8tc2V0LXhtbC1hdHRyIGV4cHJlc3Npb249Ii4uL2RyaXZlci1vcGVyYXRpb24tZGF0YVtsYXN0KCldIiBuYW1lPSJjb21tYW5kIj4KCQkJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLXN0cmluZz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJPHRva2VuLXRleHQgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+bW9kaWZ5PC90b2tlbi10ZXh0PgoJCQkJCQkJCQkJCQkJCQkJCQkJCTwvYXJnLXN0cmluZz4KCQkJCQkJCQkJCQkJCQkJCQkJCTwvZG8tc2V0LXhtbC1hdHRyPgoJCQkJCQkJCQkJCQkJCQkJCQk8L2FyZy1hY3Rpb25zPgoJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLWFjdGlvbnM+CgkJCQkJCQkJCQkJCQkJCQkJCQk8ZG8tc2V0LXhtbC1hdHRyIGV4cHJlc3Npb249Ii4uL2RyaXZlci1vcGVyYXRpb24tZGF0YVtsYXN0KCldIiBuYW1lPSJjb21tYW5kIj4KCQkJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLXN0cmluZz4KCQkJCQkJCQkJCQkJCQkJCQkJCQkJPHRva2VuLW9wZXJhdGlvbi8+CgkJCQkJCQkJCQkJCQkJCQkJCQkJPC9hcmctc3RyaW5nPgoJCQkJCQkJCQkJCQkJCQkJCQkJPC9kby1zZXQteG1sLWF0dHI+CgkJCQkJCQkJCQkJCQkJCQkJCTwvYXJnLWFjdGlvbnM+CgkJCQkJCQkJCQkJCQkJCQkJPC9kby1pZj4KCQkJCQkJCQkJCQkJCQkJCQk8ZG8tYXBwZW5kLXhtbC1lbGVtZW50IGV4cHJlc3Npb249Ii4uL2RyaXZlci1vcGVyYXRpb24tZGF0YVtsYXN0KCldIiBuYW1lPSJyZXF1ZXN0Ii8+CgkJCQkJCQkJCQkJCQkJCQkJPGRvLWFwcGVuZC14bWwtZWxlbWVudCBleHByZXNzaW9uPSIuLi9kcml2ZXItb3BlcmF0aW9uLWRhdGFbbGFzdCgpXS9yZXF1ZXN0W2xhc3QoKV0iIG5hbWU9InVybC10b2tlbiIvPgoJCQkJCQkJCQkJCQkJCQkJCTxkby1pZj4KCQkJCQkJCQkJCQkJCQkJCQkJPGFyZy1jb25kaXRpb25zPgoJCQkJCQkJCQkJCQkJCQkJCQkJPGFuZD4KCQkJCQkJCQkJCQkJCQkJCQkJCQk8aWYtYXNzb2NpYXRpb24gb3A9ImF2YWlsYWJsZSIvPgoJCQkJCQkJCQkJCQkJCQkJCQkJPC9hbmQ+CgkJCQkJCQkJCQkJCQkJCQkJCTwvYXJnLWNvbmRpdGlvbnM+CgkJCQkJCQkJCQkJCQkJCQkJCTxhcmctYWN0aW9ucz4KCQkJCQkJCQkJCQkJCQkJCQkJCTxkby1zZXQteG1sLWF0dHIgZXhwcmVzc2lvbj0iLi4vZHJpdmVyLW9wZXJhdGlvbi1kYXRhW2xhc3QoKV0vcmVxdWVzdFtsYXN0KCldL3VybC10b2tlbiIgbmFtZT0iYXNzb2NpYXRpb24iPgoJCQkJCQkJCQkJCQkJCQkJCQkJCTxhcmctc3RyaW5nPgoJCQkJCQkJCQkJCQkJCQkJCQkJCQk8dG9rZW4tYXNzb2NpYXRpb24vPgoJCQkJCQkJCQkJCQkJCQkJCQkJCTwvYXJnLXN0cmluZz4KCQkJCQkJCQkJCQkJCQkJCQkJCTwvZG8tc2V0LXhtbC1hdHRyPgoJCQkJCQkJCQkJCQkJCQkJCQk8L2FyZy1hY3Rpb25zPgoJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLWFjdGlvbnMvPgoJCQkJCQkJCQkJCQkJCQkJCTwvZG8taWY+CgkJCQkJCQkJCQkJCQkJCQkJPGRvLWFwcGVuZC14bWwtZWxlbWVudCBleHByZXNzaW9uPSIuLi9kcml2ZXItb3BlcmF0aW9uLWRhdGFbbGFzdCgpXS9yZXF1ZXN0W2xhc3QoKV0iIG5hbWU9ImhlYWRlciIvPgoJCQkJCQkJCQkJCQkJCQkJCTxkby1zZXQteG1sLWF0dHIgZXhwcmVzc2lvbj0iLi4vZHJpdmVyLW9wZXJhdGlvbi1kYXRhW2xhc3QoKV0vcmVxdWVzdFtsYXN0KCldL2hlYWRlciIgbmFtZT0iY29udGVudC10eXBlIj4KCQkJCQkJCQkJCQkJCQkJCQkJPGFyZy1zdHJpbmc+CgkJCQkJCQkJCQkJCQkJCQkJCQk8dG9rZW4tdGV4dCB4bWw6c3BhY2U9InByZXNlcnZlIj5hcHBsaWNhdGlvbi9qc29uPC90b2tlbi10ZXh0PgoJCQkJCQkJCQkJCQkJCQkJCQk8L2FyZy1zdHJpbmc+CgkJCQkJCQkJCQkJCQkJCQkJPC9kby1zZXQteG1sLWF0dHI+CgkJCQkJCQkJCQkJCQkJCQkJPGRvLWFwcGVuZC14bWwtZWxlbWVudCBleHByZXNzaW9uPSIuLi9kcml2ZXItb3BlcmF0aW9uLWRhdGFbbGFzdCgpXS9yZXF1ZXN0W2xhc3QoKV0iIG5hbWU9InZhbHVlIi8+CgkJCQkJCQkJCQkJCQkJCQkJPGRvLWFwcGVuZC14bWwtdGV4dCBleHByZXNzaW9uPSIuLi9kcml2ZXItb3BlcmF0aW9uLWRhdGFbbGFzdCgpXS9yZXF1ZXN0W2xhc3QoKV0vdmFsdWUiPgoJCQkJCQkJCQkJCQkJCQkJCQk8YXJnLXN0cmluZz4KCQkJCQkJCQkJCQkJCQkJCQkJCTx0b2tlbi1sb2NhbC12YXJpYWJsZSBuYW1lPSJhcHBsaWNhdGlvbkNvbnRlbnQiLz4KCQkJCQkJCQkJCQkJCQkJCQkJPC9hcmctc3RyaW5nPgoJCQkJCQkJCQkJCQkJCQkJCTwvZG8tYXBwZW5kLXhtbC10ZXh0PgoJCQkJCQkJCQkJCQkJCQkJPC9hcmctYWN0aW9ucz4KCQkJCQkJCQkJCQkJCQkJCTxhcmctYWN0aW9ucy8+CgkJCQkJCQkJCQkJCQkJCTwvZG8taWY+CgkJCQkJCQkJCQkJCQkJPC9hcmctYWN0aW9ucz4KCQkJCQkJCQkJCQkJCTwvZG8taWY+CgkJCQkJCQkJCQkJCQk8ZG8tY2xvbmUteHBhdGggZGVzdC1leHByZXNzaW9uPSIuLi9kcml2ZXItb3BlcmF0aW9uLWRhdGFbbGFzdCgpXSIgbm90cmFjZT0idHJ1ZSIgc3JjLWV4cHJlc3Npb249IiRjdXJyZW50LW9wL29wZXJhdGlvbi1kYXRhIi8+CgkJCQkJCQkJCQkJCQk8ZG8tc3RyaXAteHBhdGggZXhwcmVzc2lvbj0iJGN1cnJlbnQtb3AiIG5vdHJhY2U9InRydWUiLz4KCQkJCQkJCQkJCQkJPC9hcmctYWN0aW9ucz4KCQkJCQkJCQkJCQk8L2RvLWZvci1lYWNoPgoJCQkJCQkJCQkJPC9hcmctYWN0aW9ucz4KCQkJCQkJCQkJCTxhcmctYWN0aW9ucy8+CgkJCQkJCQkJCTwvZG8taWY+CgkJCQkJCQkJPC9hcmctYWN0aW9ucz4KCQkJCQkJCTwvZG8taWY+CgkJCQkJCTwvYWN0aW9ucz4KCQkJCQk8L3J1bGU+CgkJCQk8L3BvbGljeT4KCQkJPC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iaWRtLWluc3RhbGxhdGlvbmRpcmVjdGl2ZSI+CgkJCTxkcy12YWx1ZT5QRDk0Yld3Z2RtVnljMmx2YmowaU1TNHdJaUJsYm1OdlpHbHVaejBpVlZSR0xUZ2lQejQ4YVc1emRHRnNiR0YwYVc5dUxXUnBjbVZqZEdsMlpUNEtDVHh3YkdGalpXMWxiblFnYkc5allYUnBiMjQ5SW5OMVluTmpjbWxpWlhJaUx6NEtDVHhrY3kxaGRIUnlhV0oxZEdWekx6NEtDVHh3YjJ4cFkza3RiR2x1YTJGblpUNEtDUWs4Y0c5c2FXTjVMWE5sZENCdVlXMWxQU0p2ZFhSd2RYUWlJRzl5WkdWeVBTSjNaV2xuYUhRaUlIWmhiSFZsUFNJNU1EQWlMejRLQ1R3dmNHOXNhV041TFd4cGJtdGhaMlUrQ2p3dmFXNXpkR0ZzYkdGMGFXOXVMV1JwY21WamRHbDJaVDQ9PC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iaWRtLWRpcmVjdGl2ZWNoZWNrc3VtIj4KCQkJPGRzLXZhbHVlPjM5MjkzMzAxNTM8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0tcGFja2FnZWFzc29jZ3VpZCI+CgkJCTxkcy12YWx1ZT40Q0JUN1UwMF8yMDE1MDUxMjEyNTAwNzA2OTU8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0tcGFja2FnZWd1aWQiPgoJCQk8ZHMtdmFsdWU+Q1AzMlJGV1VfMjAxNTA1MTIxMjUwMDcwNjk1PC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iaWRtLWNvbnRlbnRjaGVja3N1bSI+CgkJCTxkcy12YWx1ZT4zMjM2MTcxMjk8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJPC9kcy1hdHRyaWJ1dGVzPgo8L2RzLW9iamVjdD4=</pkg-initial-state>
			<pkg-initial-state package-id="XTEF1YO3_201006231733410161" pkg-assoc-id="FN6AXELS_201006231801080931" version="2.1.2.20190806140123">PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48ZHMtb2JqZWN0IGRzLW9iamVjdC1jbGFzcz0iRGlyWE1MLVJ1bGUiIGRzLW9iamVjdC1uYW1lPSJOT1ZMUFdEU1lOQy1zdWItY3RwLUFkZFB3ZFBheWxvYWQiIG5hbWU9Ik5PVkxQV0RTWU5DLXN1Yi1jdHAtQWRkUHdkUGF5bG9hZCI+Cgk8ZHMtYXR0cmlidXRlcz4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iWG1sRGF0YSI+CgkJCTxkcy12YWx1ZT4KCQkJCTxwb2xpY3k+CgkJCQkJPGRlc2NyaXB0aW9uPlBheWxvYWRzIGZvciBzdWJzY3JpYmUgdG8gcGFzc3dvcmQgY2hhbmdlczwvZGVzY3JpcHRpb24+CgkJCQkJPHJ1bGU+CgkJCQkJCTxkZXNjcmlwdGlvbj5BZGQgb3BlcmF0aW9uLWRhdGEgZWxlbWVudCB0byBwYXNzd29yZCBzdWJzY3JpYmUgb3BlcmF0aW9uczwvZGVzY3JpcHRpb24+CgkJCQkJCTxjb25kaXRpb25zPgoJCQkJCQkJPGFuZD4KCQkJCQkJCQk8aWYtb3BlcmF0aW9uIG9wPSJlcXVhbCI+YWRkPC9pZi1vcGVyYXRpb24+CgkJCQkJCQkJPGlmLXBhc3N3b3JkIG9wPSJhdmFpbGFibGUiLz4KCQkJCQkJCQk8aWYteHBhdGggb3A9Im5vdC10cnVlIj5vcGVyYXRpb24tZGF0YTwvaWYteHBhdGg+CgkJCQkJCQk8L2FuZD4KCQkJCQkJCTxhbmQ+CgkJCQkJCQkJPGlmLW9wZXJhdGlvbiBvcD0iZXF1YWwiPm1vZGlmeS1wYXNzd29yZDwvaWYtb3BlcmF0aW9uPgoJCQkJCQkJCTxpZi14cGF0aCBvcD0ibm90LXRydWUiPm9wZXJhdGlvbi1kYXRhPC9pZi14cGF0aD4KCQkJCQkJCTwvYW5kPgoJCQkJCQk8L2NvbmRpdGlvbnM+CgkJCQkJCTxhY3Rpb25zPgoJCQkJCQkJPCEtLSBBZGQgYSBvcGVyYXRpb24gZGF0YSBwYXlsb2FkIGVsZW1lbnQgdG8gcGljayB1cCByZXN1bHQgb2YgYSBwYXNzd29yZCBvcGVyYXRpb24gLS0+CgkJCQkJCQk8ZG8tYXBwZW5kLXhtbC1lbGVtZW50IGV4cHJlc3Npb249Ii4iIG5hbWU9Im9wZXJhdGlvbi1kYXRhIi8+CgkJCQkJCTwvYWN0aW9ucz4KCQkJCQk8L3J1bGU+CgkJCQkJPHJ1bGU+CgkJCQkJCTxkZXNjcmlwdGlvbj5BZGQgcGF5bG9hZCBkYXRhIHRvIGEgcmVzZXQgcGFzc3dvcmQgZnJvbSBhIGZhaWxlZCBwYXNzd29yZCBwdWJsaXNoIG9wZXJhdGlvbjwvZGVzY3JpcHRpb24+CgkJCQkJCTxjb25kaXRpb25zPgoJCQkJCQkJPGFuZD4KCQkJCQkJCQk8aWYtb3BlcmF0aW9uIG9wPSJlcXVhbCI+bW9kaWZ5LXBhc3N3b3JkPC9pZi1vcGVyYXRpb24+CgkJCQkJCQkJPGlmLXhwYXRoIG9wPSJ0cnVlIj5zZWxmOjptb2RpZnktcGFzc3dvcmRbQGV2ZW50LWlkID0gJ3B3ZC1wdWJsaXNoLWZhaWxlZCddPC9pZi14cGF0aD4KCQkJCQkJCTwvYW5kPgoJCQkJCQk8L2NvbmRpdGlvbnM+CgkJCQkJCTxhY3Rpb25zPgoJCQkJCQkJPCEtLSBBZGQgYSBvcGVyYXRpb24gZGF0YSBwYXlsb2FkIGVsZW1lbnQgdG8gcGljayB1cCByZXN1bHQgb2YgYSBwYXNzd29yZCBvcGVyYXRpb24gLS0+CgkJCQkJCQk8ZG8tYXBwZW5kLXhtbC1lbGVtZW50IGV4cHJlc3Npb249Im9wZXJhdGlvbi1kYXRhIiBuYW1lPSJwYXNzd29yZC1yZXNldC1zdGF0dXMiLz4KCQkJCQkJCTxkby1hcHBlbmQteG1sLWVsZW1lbnQgZXhwcmVzc2lvbj0ib3BlcmF0aW9uLWRhdGEvcGFzc3dvcmQtcmVzZXQtc3RhdHVzIiBuYW1lPSJhc3NvY2lhdGlvbiIvPgoJCQkJCQkJPGRvLWFwcGVuZC14bWwtdGV4dCBleHByZXNzaW9uPSJvcGVyYXRpb24tZGF0YS9wYXNzd29yZC1yZXNldC1zdGF0dXMvYXNzb2NpYXRpb24iPgoJCQkJCQkJCTxhcmctc3RyaW5nPgoJCQkJCQkJCQk8dG9rZW4tYXNzb2NpYXRpb24vPgoJCQkJCQkJCTwvYXJnLXN0cmluZz4KCQkJCQkJCTwvZG8tYXBwZW5kLXhtbC10ZXh0PgoJCQkJCQk8L2FjdGlvbnM+CgkJCQkJPC9ydWxlPgoJCQkJCTxydWxlPgoJCQkJCQk8ZGVzY3JpcHRpb24+QWRkIHBheWxvYWQgZGF0YSB0byBwYXNzd29yZCBzdWJzY3JpYmUgb3BlcmF0aW9uczwvZGVzY3JpcHRpb24+CgkJCQkJCTxjb25kaXRpb25zPgoJCQkJCQkJPGFuZD4KCQkJCQkJCQk8aWYtb3BlcmF0aW9uIG9wPSJlcXVhbCI+YWRkPC9pZi1vcGVyYXRpb24+CgkJCQkJCQkJPGlmLXBhc3N3b3JkIG9wPSJhdmFpbGFibGUiLz4KCQkJCQkJCTwvYW5kPgoJCQkJCQkJPGFuZD4KCQkJCQkJCQk8aWYtb3BlcmF0aW9uIG9wPSJlcXVhbCI+bW9kaWZ5LXBhc3N3b3JkPC9pZi1vcGVyYXRpb24+CgkJCQkJCQkJPGlmLXhwYXRoIG9wPSJ0cnVlIj5zZWxmOjptb2RpZnktcGFzc3dvcmRbQGV2ZW50LWlkICE9ICdwd2QtcHVibGlzaC1mYWlsZWQnXTwvaWYteHBhdGg+CgkJCQkJCQk8L2FuZD4KCQkJCQkJPC9jb25kaXRpb25zPgoJCQkJCQk8YWN0aW9ucz4KCQkJCQkJCTwhLS0gQWRkIGEgb3BlcmF0aW9uIGRhdGEgcGF5bG9hZCBlbGVtZW50IHRvIHBpY2sgdXAgcmVzdWx0IG9mIGEgcGFzc3dvcmQgb3BlcmF0aW9uIC0tPgoJCQkJCQkJPGRvLWFwcGVuZC14bWwtZWxlbWVudCBleHByZXNzaW9uPSJvcGVyYXRpb24tZGF0YSIgbmFtZT0icGFzc3dvcmQtc3Vic2NyaWJlLXN0YXR1cyIvPgoJCQkJCQkJPGRvLWFwcGVuZC14bWwtZWxlbWVudCBleHByZXNzaW9uPSJvcGVyYXRpb24tZGF0YS9wYXNzd29yZC1zdWJzY3JpYmUtc3RhdHVzIiBuYW1lPSJhc3NvY2lhdGlvbiIvPgoJCQkJCQkJPGRvLWFwcGVuZC14bWwtdGV4dCBleHByZXNzaW9uPSJvcGVyYXRpb24tZGF0YS9wYXNzd29yZC1zdWJzY3JpYmUtc3RhdHVzL2Fzc29jaWF0aW9uIj4KCQkJCQkJCQk8YXJnLXN0cmluZz4KCQkJCQkJCQkJPHRva2VuLWFzc29jaWF0aW9uLz4KCQkJCQkJCQk8L2FyZy1zdHJpbmc+CgkJCQkJCQk8L2RvLWFwcGVuZC14bWwtdGV4dD4KCQkJCQkJPC9hY3Rpb25zPgoJCQkJCTwvcnVsZT4KCQkJCTwvcG9saWN5PgoJCQk8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0taW5zdGFsbGF0aW9uZGlyZWN0aXZlIj4KCQkJPGRzLXZhbHVlPlBEOTRiV3dnZG1WeWMybHZiajBpTVM0d0lpQmxibU52WkdsdVp6MGlWVlJHTFRnaVB6NDhhVzV6ZEdGc2JHRjBhVzl1TFdScGNtVmpkR2wyWlQ0S0NUeHdiR0ZqWlcxbGJuUWdiRzlqWVhScGIyNDlJbk4xWW5OamNtbGlaWElpTHo0S0NUeGtjeTFoZEhSeWFXSjFkR1Z6THo0S0NUeHdiMnhwWTNrdGJHbHVhMkZuWlM4K0Nqd3ZhVzV6ZEdGc2JHRjBhVzl1TFdScGNtVmpkR2wyWlQ0PTwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9ImlkbS1kaXJlY3RpdmVjaGVja3N1bSI+CgkJCTxkcy12YWx1ZT40OTYzNzk4MzY8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0tcGFja2FnZWFzc29jZ3VpZCI+CgkJCTxkcy12YWx1ZT5GTjZBWEVMU18yMDEwMDYyMzE4MDEwODA5MzE8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0tcGFja2FnZWd1aWQiPgoJCQk8ZHMtdmFsdWU+WFRFRjFZTzNfMjAxMDA2MjMxNzMzNDEwMTYxPC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iaWRtLWNvbnRlbnRjaGVja3N1bSI+CgkJCTxkcy12YWx1ZT4xNjQyMzU5MDc4PC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCTwvZHMtYXR0cmlidXRlcz4KPC9kcy1vYmplY3Q+</pkg-initial-state>
			<pkg-initial-state package-id="XTEF1YO3_201006231733410161" pkg-assoc-id="YX3KVQAI_201006231802110178" version="2.1.2.20190806140123">PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48ZHMtb2JqZWN0IGRzLW9iamVjdC1jbGFzcz0iRGlyWE1MLVJ1bGUiIGRzLW9iamVjdC1uYW1lPSJOT1ZMUFdEU1lOQy1zdWItY3RwLUNoZWNrUHdkR0NWIiBuYW1lPSJOT1ZMUFdEU1lOQy1zdWItY3RwLUNoZWNrUHdkR0NWIj4KCTxkcy1hdHRyaWJ1dGVzPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJYbWxEYXRhIj4KCQkJPGRzLXZhbHVlPgoJCQkJPHBvbGljeT4KCQkJCQk8ZGVzY3JpcHRpb24+U3Vic2NyaWJlIHRvIHBhc3N3b3JkIGNoYW5nZXM8L2Rlc2NyaXB0aW9uPgoJCQkJCTxydWxlPgoJCQkJCQk8ZGVzY3JpcHRpb24+QmxvY2sgc3Vic2NyaWJpbmcgdG8gcGFzc3dvcmRzIHdoZW4gb2JqZWN0cyBhcmUgYWRkZWQ8L2Rlc2NyaXB0aW9uPgoJCQkJCQk8Y29uZGl0aW9ucz4KCQkJCQkJCTxhbmQ+CgkJCQkJCQkJPGlmLWdsb2JhbC12YXJpYWJsZSBtb2RlPSJub2Nhc2UiIG5hbWU9ImVuYWJsZS1wYXNzd29yZC1zdWJzY3JpYmUiIG9wPSJlcXVhbCI+ZmFsc2U8L2lmLWdsb2JhbC12YXJpYWJsZT4KCQkJCQkJCQk8aWYtb3BlcmF0aW9uIG9wPSJlcXVhbCI+YWRkPC9pZi1vcGVyYXRpb24+CgkJCQkJCQk8L2FuZD4KCQkJCQkJPC9jb25kaXRpb25zPgoJCQkJCQk8YWN0aW9ucz4KCQkJCQkJCTwhLS0gUmVtb3ZlIGFsbCBwYXNzd29yZCBlbGVtZW50cyBmcm9tIGFkZCAtLT4KCQkJCQkJCTxkby1zdHJpcC14cGF0aCBleHByZXNzaW9uPSJwYXNzd29yZCIvPgoJCQkJCQk8L2FjdGlvbnM+CgkJCQkJPC9ydWxlPgoJCQkJCTxydWxlPgoJCQkJCQk8ZGVzY3JpcHRpb24+QmxvY2sgc3Vic2NyaWJpbmcgdG8gcGFzc3dvcmQgbW9kaWZpY2F0aW9uczwvZGVzY3JpcHRpb24+CgkJCQkJCTxjb25kaXRpb25zPgoJCQkJCQkJPGFuZD4KCQkJCQkJCQk8aWYtZ2xvYmFsLXZhcmlhYmxlIG1vZGU9Im5vY2FzZSIgbmFtZT0iZW5hYmxlLXBhc3N3b3JkLXN1YnNjcmliZSIgb3A9ImVxdWFsIj5mYWxzZTwvaWYtZ2xvYmFsLXZhcmlhYmxlPgoJCQkJCQkJCTxpZi1vcGVyYXRpb24gb3A9ImVxdWFsIj5tb2RpZnktcGFzc3dvcmQ8L2lmLW9wZXJhdGlvbj4KCQkJCQkJCTwvYW5kPgoJCQkJCQk8L2NvbmRpdGlvbnM+CgkJCQkJCTxhY3Rpb25zPgoJCQkJCQkJPCEtLSBCbG9jayBhbGwgbW9kaWZ5LXBhc3N3b3JkcyAtLT4KCQkJCQkJCTxkby12ZXRvLz4KCQkJCQkJPC9hY3Rpb25zPgoJCQkJCTwvcnVsZT4KCQkJCTwvcG9saWN5PgoJCQk8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0taW5zdGFsbGF0aW9uZGlyZWN0aXZlIj4KCQkJPGRzLXZhbHVlPlBEOTRiV3dnZG1WeWMybHZiajBpTVM0d0lpQmxibU52WkdsdVp6MGlWVlJHTFRnaVB6NDhhVzV6ZEdGc2JHRjBhVzl1TFdScGNtVmpkR2wyWlQ0S0NUeHdiR0ZqWlcxbGJuUWdiRzlqWVhScGIyNDlJbk4xWW5OamNtbGlaWElpTHo0S0NUeGtjeTFoZEhSeWFXSjFkR1Z6THo0S0NUeHdiMnhwWTNrdGJHbHVhMkZuWlM4K0Nqd3ZhVzV6ZEdGc2JHRjBhVzl1TFdScGNtVmpkR2wyWlQ0PTwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9ImlkbS1kaXJlY3RpdmVjaGVja3N1bSI+CgkJCTxkcy12YWx1ZT40OTYzNzk4MzY8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0tcGFja2FnZWFzc29jZ3VpZCI+CgkJCTxkcy12YWx1ZT5ZWDNLVlFBSV8yMDEwMDYyMzE4MDIxMTAxNzg8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0tcGFja2FnZWd1aWQiPgoJCQk8ZHMtdmFsdWU+WFRFRjFZTzNfMjAxMDA2MjMxNzMzNDEwMTYxPC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iaWRtLWNvbnRlbnRjaGVja3N1bSI+CgkJCTxkcy12YWx1ZT4xNTc1NTg4Njk0PC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCTwvZHMtYXR0cmlidXRlcz4KPC9kcy1vYmplY3Q+</pkg-initial-state>
			<pkg-initial-state package-id="XTEF1YO3_201006231733410161" pkg-assoc-id="CXO45XW7_201006231803270112" version="2.1.2.20190806140123">PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48ZHMtb2JqZWN0IGRzLW9iamVjdC1jbGFzcz0iRGlyWE1MLVJ1bGUiIGRzLW9iamVjdC1uYW1lPSJOT1ZMUFdEU1lOQy1zdWItY3AtRGVmYXVsdFB3ZCIgbmFtZT0iTk9WTFBXRFNZTkMtc3ViLWNwLURlZmF1bHRQd2QiPgoJPGRzLWF0dHJpYnV0ZXM+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9IlhtbERhdGEiPgoJCQk8ZHMtdmFsdWU+CgkJCQk8cG9saWN5PgoJCQkJCTxydWxlPgoJCQkJCQk8ZGVzY3JpcHRpb24+T24gVXNlciBhZGQsIHByb3ZpZGUgZGVmYXVsdCBwYXNzd29yZCBpZiBubyBwYXNzd29yZCBleGlzdHM8L2Rlc2NyaXB0aW9uPgoJCQkJCQk8Y29uZGl0aW9ucz4KCQkJCQkJCTxhbmQ+CgkJCQkJCQkJPGlmLW9wZXJhdGlvbiBvcD0iZXF1YWwiPmFkZDwvaWYtb3BlcmF0aW9uPgoJCQkJCQkJCTxpZi1jbGFzcy1uYW1lIG9wPSJlcXVhbCI+VXNlcjwvaWYtY2xhc3MtbmFtZT4KCQkJCQkJCQk8aWYtcGFzc3dvcmQgb3A9Im5vdC1hdmFpbGFibGUiLz4KCQkJCQkJCQk8aWYtb3AtYXR0ciBuYW1lPSJuc3BtRGlzdHJpYnV0aW9uUGFzc3dvcmQiIG9wPSJub3QtYXZhaWxhYmxlIi8+CgkJCQkJCQk8L2FuZD4KCQkJCQkJPC9jb25kaXRpb25zPgoJCQkJCQk8YWN0aW9ucz4KCQkJCQkJCTxkby1pZj4KCQkJCQkJCQk8YXJnLWNvbmRpdGlvbnM+CgkJCQkJCQkJCTxhbmQ+CgkJCQkJCQkJCQk8aWYtZ2xvYmFsLXZhcmlhYmxlIG1vZGU9Im5vY2FzZSIgbmFtZT0iZGVmYXVsdFBhc3N3b3JkLmVuYWJsZSIgb3A9ImVxdWFsIj55ZXM8L2lmLWdsb2JhbC12YXJpYWJsZT4KCQkJCQkJCQkJPC9hbmQ+CgkJCQkJCQkJPC9hcmctY29uZGl0aW9ucz4KCQkJCQkJCQk8YXJnLWFjdGlvbnM+CgkJCQkJCQkJCTxkby1zZXQtZGVzdC1wYXNzd29yZD4KCQkJCQkJCQkJCTxhcmctc3RyaW5nPgoJCQkJCQkJCQkJCTx0b2tlbi10ZXh0IHhtbDpzcGFjZT0icHJlc2VydmUiPkBEaXJYbWwxPC90b2tlbi10ZXh0PgoJCQkJCQkJCQkJPC9hcmctc3RyaW5nPgoJCQkJCQkJCQk8L2RvLXNldC1kZXN0LXBhc3N3b3JkPgoJCQkJCQkJCTwvYXJnLWFjdGlvbnM+CgkJCQkJCQkJPGFyZy1hY3Rpb25zPgoJCQkJCQkJCQk8ZG8tdmV0by8+CgkJCQkJCQkJPC9hcmctYWN0aW9ucz4KCQkJCQkJCTwvZG8taWY+CgkJCQkJCTwvYWN0aW9ucz4KCQkJCQk8L3J1bGU+CgkJCQk8L3BvbGljeT4KCQkJPC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iaWRtLWluc3RhbGxhdGlvbmRpcmVjdGl2ZSI+CgkJCTxkcy12YWx1ZT5QRDk0Yld3Z2RtVnljMmx2YmowaU1TNHdJaUJsYm1OdlpHbHVaejBpVlZSR0xUZ2lQejQ4YVc1emRHRnNiR0YwYVc5dUxXUnBjbVZqZEdsMlpUNEtDVHh3YkdGalpXMWxiblFnYkc5allYUnBiMjQ5SW5OMVluTmpjbWxpWlhJaUx6NEtDVHhrY3kxaGRIUnlhV0oxZEdWekx6NEtDVHh3YjJ4cFkza3RiR2x1YTJGblpTOCtDand2YVc1emRHRnNiR0YwYVc5dUxXUnBjbVZqZEdsMlpUND08L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0tZGlyZWN0aXZlY2hlY2tzdW0iPgoJCQk8ZHMtdmFsdWU+NDk2Mzc5ODM2PC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iaWRtLXBhY2thZ2Vhc3NvY2d1aWQiPgoJCQk8ZHMtdmFsdWU+Q1hPNDVYVzdfMjAxMDA2MjMxODAzMjcwMTEyPC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iaWRtLXBhY2thZ2VndWlkIj4KCQkJPGRzLXZhbHVlPlhURUYxWU8zXzIwMTAwNjIzMTczMzQxMDE2MTwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9ImlkbS1jb250ZW50Y2hlY2tzdW0iPgoJCQk8ZHMtdmFsdWU+ODI5NzE2Mjk3PC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCTwvZHMtYXR0cmlidXRlcz4KPC9kcy1vYmplY3Q+</pkg-initial-state>
			<pkg-initial-state package-id="XTEF1YO3_201006231733410161" pkg-assoc-id="8CK6CZJW_201006231804290701" version="2.1.2.20190806140123">PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48ZHMtb2JqZWN0IGRzLW9iamVjdC1jbGFzcz0iRGlyWE1MLVJ1bGUiIGRzLW9iamVjdC1uYW1lPSJOT1ZMUFdEU1lOQy1zdWItY3RwLVRyYW5zZm9ybURpc3RQd2QiIG5hbWU9Ik5PVkxQV0RTWU5DLXN1Yi1jdHAtVHJhbnNmb3JtRGlzdFB3ZCI+Cgk8ZHMtYXR0cmlidXRlcz4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iWG1sRGF0YSI+CgkJCTxkcy12YWx1ZT4KCQkJCTxwb2xpY3k+CgkJCQkJPGRlc2NyaXB0aW9uPlRyYW5zZm9ybSBOTUFTIGF0dHJpYnV0ZSB0byBwYXNzd29yZCBlbGVtZW50czwvZGVzY3JpcHRpb24+CgkJCQkJPHJ1bGU+CgkJCQkJCTxkZXNjcmlwdGlvbj5Db252ZXJ0IGFkZHMgb2YgdGhlIG5zcG1EaXN0cmlidXRpb25QYXNzd29yZCBhdHRyaWJ1dGUgdG8gcGFzc3dvcmQgZWxlbWVudHM8L2Rlc2NyaXB0aW9uPgoJCQkJCQk8Y29uZGl0aW9ucz4KCQkJCQkJCTxhbmQ+CgkJCQkJCQkJPGlmLW9wZXJhdGlvbiBvcD0iZXF1YWwiPmFkZDwvaWYtb3BlcmF0aW9uPgoJCQkJCQkJCTxpZi1vcC1hdHRyIG5hbWU9Im5zcG1EaXN0cmlidXRpb25QYXNzd29yZCIgb3A9ImF2YWlsYWJsZSIvPgoJCQkJCQkJPC9hbmQ+CgkJCQkJCTwvY29uZGl0aW9ucz4KCQkJCQkJPGFjdGlvbnM+CgkJCQkJCQk8IS0tIENoYW5nZSBhbGwgYWRkLWF0dHIgZWxlbWVudHMgZm9yIHRoZSBuc3BtRGlzdHJpYnV0aW9uUGFzc3dvcmQgYXR0cmlidXRlIHRvIHBhc3N3b3JkIGVsZW1lbnRzLS0+CgkJCQkJCQk8ZG8tc2V0LWRlc3QtcGFzc3dvcmQ+CgkJCQkJCQkJPGFyZy1zdHJpbmc+CgkJCQkJCQkJCTx0b2tlbi14cGF0aCBleHByZXNzaW9uPSJhZGQtYXR0cltAYXR0ci1uYW1lPSduc3BtRGlzdHJpYnV0aW9uUGFzc3dvcmQnXS8vdmFsdWUiLz4KCQkJCQkJCQk8L2FyZy1zdHJpbmc+CgkJCQkJCQk8L2RvLXNldC1kZXN0LXBhc3N3b3JkPgoJCQkJCQkJPCEtLSBSZW1vdmUgYWxsIGFkZC1hdHRyIGVsZW1lbnRzIGZvciB0aGUgbnNwbURpc3RyaWJ1dGlvblBhc3N3b3JkIGF0dHJpYnV0ZSAtLT4KCQkJCQkJCTxkby1zdHJpcC1vcC1hdHRyIG5hbWU9Im5zcG1EaXN0cmlidXRpb25QYXNzd29yZCIvPgoJCQkJCQk8L2FjdGlvbnM+CgkJCQkJPC9ydWxlPgoJCQkJCTxydWxlPgoJCQkJCQk8ZGVzY3JpcHRpb24+QmxvY2sgbW9kaWZpZXMgZm9yIGZhaWxlZCBwYXNzd29yZCBwdWJsaXNoIG9wZXJhdGlvbnMgaWYgcmVzZXQgcGFzc3dvcmQgaXMgZmFsc2U8L2Rlc2NyaXB0aW9uPgoJCQkJCQk8Y29uZGl0aW9ucz4KCQkJCQkJCTxhbmQ+CgkJCQkJCQkJPGlmLWdsb2JhbC12YXJpYWJsZSBtb2RlPSJub2Nhc2UiIG5hbWU9InJlc2V0LWV4dGVybmFsLXBhc3N3b3JkLW9uLWZhaWx1cmUiIG9wPSJlcXVhbCI+ZmFsc2U8L2lmLWdsb2JhbC12YXJpYWJsZT4KCQkJCQkJCQk8aWYtb3BlcmF0aW9uIG9wPSJlcXVhbCI+bW9kaWZ5PC9pZi1vcGVyYXRpb24+CgkJCQkJCQkJPGlmLXhwYXRoIG9wPSJ0cnVlIj5tb2RpZnktYXR0cltAYXR0ci1uYW1lPSduc3BtRGlzdHJpYnV0aW9uUGFzc3dvcmQnIGFuZCBAZmFpbGVkLXN5bmM9J3RydWUnXTwvaWYteHBhdGg+CgkJCQkJCQk8L2FuZD4KCQkJCQkJPC9jb25kaXRpb25zPgoJCQkJCQk8YWN0aW9ucz4KCQkJCQkJCTwhLS0gQmxvY2sgYSBwYXNzd29yZCByZXNldCAtLT4KCQkJCQkJCTxkby12ZXRvLz4KCQkJCQkJPC9hY3Rpb25zPgoJCQkJCTwvcnVsZT4KCQkJCQk8cnVsZT4KCQkJCQkJPGRlc2NyaXB0aW9uPkNvbnZlcnQgbW9kaWZpZXMgb2YgYSBuc3BtRGlzdHJpYnV0aW9uUGFzc3dvcmQgYXR0cmlidXRlIHRvIGEgbW9kaWZ5IHBhc3N3b3JkIG9wZXJhdGlvbjwvZGVzY3JpcHRpb24+CgkJCQkJCTxjb25kaXRpb25zPgoJCQkJCQkJPGFuZD4KCQkJCQkJCQk8aWYtb3BlcmF0aW9uIG9wPSJlcXVhbCI+bW9kaWZ5PC9pZi1vcGVyYXRpb24+CgkJCQkJCQkJPGlmLW9wLWF0dHIgbmFtZT0ibnNwbURpc3RyaWJ1dGlvblBhc3N3b3JkIiBvcD0iYXZhaWxhYmxlIi8+CgkJCQkJCQk8L2FuZD4KCQkJCQkJPC9jb25kaXRpb25zPgoJCQkJCQk8YWN0aW9ucz4KCQkJCQkJCTwhLS0gQ2hhbmdlIGFsbCBtb2RpZnktYXR0ciBlbGVtZW50cyBmb3IgdGhlIG5zcG1EaXN0cmlidXRpb25QYXNzd29yZCBhdHRyaWJ1dGUgdG8gbW9kaWZ5LXBhc3N3b3JkIGVsZW1lbnRzLS0+CgkJCQkJCQk8ZG8tc2V0LWRlc3QtcGFzc3dvcmQ+CgkJCQkJCQkJPGFyZy1zdHJpbmc+CgkJCQkJCQkJCTx0b2tlbi14cGF0aCBleHByZXNzaW9uPSJtb2RpZnktYXR0cltAYXR0ci1uYW1lPSduc3BtRGlzdHJpYnV0aW9uUGFzc3dvcmQnXS8vYWRkLXZhbHVlLy92YWx1ZSIvPgoJCQkJCQkJCTwvYXJnLXN0cmluZz4KCQkJCQkJCTwvZG8tc2V0LWRlc3QtcGFzc3dvcmQ+CgkJCQkJCQk8IS0tIFJlbW92ZSBhbGwgYWRkLWF0dHIgZWxlbWVudHMgZm9yIHRoZSBuc3BtRGlzdHJpYnV0aW9uUGFzc3dvcmQgYXR0cmlidXRlIC0tPgoJCQkJCQkJPGRvLWlmPgoJCQkJCQkJCTxhcmctY29uZGl0aW9ucz4KCQkJCQkJCQkJPGFuZD4KCQkJCQkJCQkJCTxpZi1vcC1hdHRyIG1vZGU9InJlZ2V4IiBuYW1lPSJuc3BtRGlzdHJpYnV0aW9uUGFzc3dvcmQiIG9wPSJjaGFuZ2luZy1mcm9tIj4uKzwvaWYtb3AtYXR0cj4KCQkJCQkJCQkJPC9hbmQ+CgkJCQkJCQkJPC9hcmctY29uZGl0aW9ucz4KCQkJCQkJCQk8YXJnLWFjdGlvbnM+CgkJCQkJCQkJCTxkby1hcHBlbmQteG1sLWVsZW1lbnQgYmVmb3JlPSIuLi9tb2RpZnktcGFzc3dvcmQvcGFzc3dvcmQiIGV4cHJlc3Npb249Ii4uL21vZGlmeS1wYXNzd29yZCIgbmFtZT0ib2xkLXBhc3N3b3JkIi8+CgkJCQkJCQkJCTxkby1hcHBlbmQteG1sLXRleHQgZXhwcmVzc2lvbj0iLi4vbW9kaWZ5LXBhc3N3b3JkL29sZC1wYXNzd29yZCI+CgkJCQkJCQkJCQk8YXJnLXN0cmluZz4KCQkJCQkJCQkJCQk8dG9rZW4tcmVtb3ZlZC1hdHRyIG5hbWU9Im5zcG1EaXN0cmlidXRpb25QYXNzd29yZCIvPgoJCQkJCQkJCQkJPC9hcmctc3RyaW5nPgoJCQkJCQkJCQk8L2RvLWFwcGVuZC14bWwtdGV4dD4KCQkJCQkJCQk8L2FyZy1hY3Rpb25zPgoJCQkJCQkJPC9kby1pZj4KCQkJCQkJCTwhLS0gUmV0YWluIGZhaWxlZC1zeW5jIHN0YXR1cyBpbiB0aGUgbW9kaWZ5LXBhc3N3b3JkIGV2ZW50LS0+CgkJCQkJCQk8ZG8taWY+CgkJCQkJCQkJPGFyZy1jb25kaXRpb25zPgoJCQkJCQkJCQk8YW5kPgoJCQkJCQkJCQkJPGlmLXhwYXRoIG9wPSJ0cnVlIj5tb2RpZnktYXR0cltAYXR0ci1uYW1lPSduc3BtRGlzdHJpYnV0aW9uUGFzc3dvcmQnIGFuZCBAZmFpbGVkLXN5bmM9J3RydWUnXTwvaWYteHBhdGg+CgkJCQkJCQkJCTwvYW5kPgoJCQkJCQkJCTwvYXJnLWNvbmRpdGlvbnM+CgkJCQkJCQkJPGFyZy1hY3Rpb25zPgoJCQkJCQkJCQk8ZG8tc2V0LXhtbC1hdHRyIGV4cHJlc3Npb249Ii4uL21vZGlmeS1wYXNzd29yZCIgbmFtZT0iZmFpbGVkLXN5bmMiPgoJCQkJCQkJCQkJPGFyZy1zdHJpbmc+CgkJCQkJCQkJCQkJPHRva2VuLXRleHQgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+dHJ1ZTwvdG9rZW4tdGV4dD4KCQkJCQkJCQkJCTwvYXJnLXN0cmluZz4KCQkJCQkJCQkJPC9kby1zZXQteG1sLWF0dHI+CgkJCQkJCQkJPC9hcmctYWN0aW9ucz4KCQkJCQkJCQk8YXJnLWFjdGlvbnMvPgoJCQkJCQkJPC9kby1pZj4KCQkJCQkJCTxkby1zdHJpcC1vcC1hdHRyIG5hbWU9Im5zcG1EaXN0cmlidXRpb25QYXNzd29yZCIvPgoJCQkJCQkJPCEtLSBBZGQgYW4gZXZlbnQtaWQgYXR0cmlidXRlIHRvIHRoZSBtb2RpZnktcGFzc3dvcmQgY29tbWFuZCB3ZSBqdXN0IGFkZGVkLCByZXF1aXJlZCBmb3Igb3BlcmF0aW9uIGRhdGEgLS0+CgkJCQkJCQk8ZG8tc2V0LXhtbC1hdHRyIGV4cHJlc3Npb249Ii4uL21vZGlmeS1wYXNzd29yZCIgbmFtZT0iZXZlbnQtaWQiPgoJCQkJCQkJCTxhcmctc3RyaW5nPgoJCQkJCQkJCQk8dG9rZW4tdGV4dD5wd2Qtc3Vic2NyaWJlPC90b2tlbi10ZXh0PgoJCQkJCQkJCTwvYXJnLXN0cmluZz4KCQkJCQkJCTwvZG8tc2V0LXhtbC1hdHRyPgoJCQkJCQk8L2FjdGlvbnM+CgkJCQkJPC9ydWxlPgoJCQkJCTxydWxlPgoJCQkJCQk8ZGVzY3JpcHRpb24+QmxvY2sgZW1wdHkgbW9kaWZ5IG9wZXJhdGlvbnM8L2Rlc2NyaXB0aW9uPgoJCQkJCQk8Y29uZGl0aW9ucz4KCQkJCQkJCTxhbmQ+CgkJCQkJCQkJPGlmLW9wZXJhdGlvbiBvcD0iZXF1YWwiPm1vZGlmeTwvaWYtb3BlcmF0aW9uPgoJCQkJCQkJCTxpZi14cGF0aCBvcD0ibm90LXRydWUiPm1vZGlmeS1hdHRyPC9pZi14cGF0aD4KCQkJCQkJCTwvYW5kPgoJCQkJCQk8L2NvbmRpdGlvbnM+CgkJCQkJCTxhY3Rpb25zPgoJCQkJCQkJPCEtLSBWZXRvIGVtcHR5IG1vZGlmeSAtLT4KCQkJCQkJCTxkby12ZXRvLz4KCQkJCQkJPC9hY3Rpb25zPgoJCQkJCTwvcnVsZT4KCQkJCTwvcG9saWN5PgoJCQk8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0taW5zdGFsbGF0aW9uZGlyZWN0aXZlIj4KCQkJPGRzLXZhbHVlPlBEOTRiV3dnZG1WeWMybHZiajBpTVM0d0lpQmxibU52WkdsdVp6MGlWVlJHTFRnaVB6NDhhVzV6ZEdGc2JHRjBhVzl1TFdScGNtVmpkR2wyWlQ0S0NUeHdiR0ZqWlcxbGJuUWdiRzlqWVhScGIyNDlJbk4xWW5OamNtbGlaWElpTHo0S0NUeGtjeTFoZEhSeWFXSjFkR1Z6THo0S0NUeHdiMnhwWTNrdGJHbHVhMkZuWlM4K0Nqd3ZhVzV6ZEdGc2JHRjBhVzl1TFdScGNtVmpkR2wyWlQ0PTwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9ImlkbS1kaXJlY3RpdmVjaGVja3N1bSI+CgkJCTxkcy12YWx1ZT40OTYzNzk4MzY8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0tcGFja2FnZWFzc29jZ3VpZCI+CgkJCTxkcy12YWx1ZT44Q0s2Q1pKV18yMDEwMDYyMzE4MDQyOTA3MDE8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0tcGFja2FnZWd1aWQiPgoJCQk8ZHMtdmFsdWU+WFRFRjFZTzNfMjAxMDA2MjMxNzMzNDEwMTYxPC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iaWRtLWNvbnRlbnRjaGVja3N1bSI+CgkJCTxkcy12YWx1ZT4yNDM3NzcwOTIxPC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCTwvZHMtYXR0cmlidXRlcz4KPC9kcy1vYmplY3Q+</pkg-initial-state>
			<pkg-initial-state package-id="3V750MRQ_201504031637130312" pkg-assoc-id="5GF18XJN_201505170105340535" version="1.0.0.20171211151747">PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48ZHMtb2JqZWN0IGRzLW9iamVjdC1jbGFzcz0iRGlyWE1MLVJ1bGUiIGRzLW9iamVjdC1uYW1lPSJORVRRUFdEU1lOQy1zdWItY3AtVXNlclB3ZENoZWNrIiBuYW1lPSJORVRRUFdEU1lOQy1zdWItY3AtVXNlclB3ZENoZWNrIj4KCTxkcy1hdHRyaWJ1dGVzPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJYbWxEYXRhIj4KCQkJPGRzLXZhbHVlPgoJCQkJPHBvbGljeT4KCQkJCQk8cnVsZT4KCQkJCQkJPGRlc2NyaXB0aW9uPlZldG8gaWYgbnNwbURpc3RyaWJ1dGlvblBhc3N3b3JkIGlzIG5vdCBhdmFpbGFibGU8L2Rlc2NyaXB0aW9uPgoJCQkJCQk8Y29uZGl0aW9ucz4KCQkJCQkJCTxhbmQ+CgkJCQkJCQkJPGlmLWNsYXNzLW5hbWUgbW9kZT0ibm9jYXNlIiBvcD0iZXF1YWwiPlVzZXI8L2lmLWNsYXNzLW5hbWU+CgkJCQkJCQk8L2FuZD4KCQkJCQkJPC9jb25kaXRpb25zPgoJCQkJCQk8YWN0aW9ucz4KCQkJCQkJCTxkby12ZXRvLWlmLW9wLWF0dHItbm90LWF2YWlsYWJsZSBuYW1lPSJuc3BtRGlzdHJpYnV0aW9uUGFzc3dvcmQiLz4KCQkJCQkJPC9hY3Rpb25zPgoJCQkJCTwvcnVsZT4KCQkJCTwvcG9saWN5PgoJCQk8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0taW5zdGFsbGF0aW9uZGlyZWN0aXZlIj4KCQkJPGRzLXZhbHVlPlBEOTRiV3dnZG1WeWMybHZiajBpTVM0d0lpQmxibU52WkdsdVp6MGlWVlJHTFRnaVB6NDhhVzV6ZEdGc2JHRjBhVzl1TFdScGNtVmpkR2wyWlQ0S0NUeHdiR0ZqWlcxbGJuUWdiRzlqWVhScGIyNDlJbk4xWW5OamNtbGlaWElpTHo0S0NUeGtjeTFoZEhSeWFXSjFkR1Z6THo0S0NUeHdiMnhwWTNrdGJHbHVhMkZuWlQ0S0NRazhjRzlzYVdONUxYTmxkQ0JqYUdGdWJtVnNQU0p6ZFdKelkzSnBZbVZ5SWlCdVlXMWxQU0pqY21WaGRHbHZiaUlnYjNKa1pYSTlJbGRsYVdkb2RDSWdkbUZzZFdVOUlqVXdNQ0l2UGdvSlBDOXdiMnhwWTNrdGJHbHVhMkZuWlQ0S1BDOXBibk4wWVd4c1lYUnBiMjR0WkdseVpXTjBhWFpsUGc9PTwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9ImlkbS1kaXJlY3RpdmVjaGVja3N1bSI+CgkJCTxkcy12YWx1ZT42MTE1MDU4OTE8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0tcGFja2FnZWFzc29jZ3VpZCI+CgkJCTxkcy12YWx1ZT41R0YxOFhKTl8yMDE1MDUxNzAxMDUzNDA1MzU8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0tcGFja2FnZWd1aWQiPgoJCQk8ZHMtdmFsdWU+M1Y3NTBNUlFfMjAxNTA0MDMxNjM3MTMwMzEyPC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iaWRtLWNvbnRlbnRjaGVja3N1bSI+CgkJCTxkcy12YWx1ZT42NTQzMTc5NzU8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJPC9kcy1hdHRyaWJ1dGVzPgo8L2RzLW9iamVjdD4=</pkg-initial-state>
			<pkg-initial-state package-id="DQ3ZPHXF_201505121302320165" pkg-assoc-id="1F50OXYM_201505121304050581" version="1.0.1.20180613142919">PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48ZHMtb2JqZWN0IGRzLW9iamVjdC1jbGFzcz0iRGlyWE1MLVJ1bGUiIGRzLW9iamVjdC1uYW1lPSJORVRRUkVTVERDRkctaXRwLUFkZEFzc29jaWF0aW9uIiBuYW1lPSJORVRRUkVTVERDRkctaXRwLUFkZEFzc29jaWF0aW9uIj4KCTxkcy1hdHRyaWJ1dGVzPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJYbWxEYXRhIj4KCQkJPGRzLXZhbHVlPgoJCQkJPHBvbGljeT4KCQkJCQk8cnVsZT4KCQkJCQkJPGRlc2NyaXB0aW9uPkNoZWNrIGZvciBhc3NvY2lhdGlvbiAtQUREPC9kZXNjcmlwdGlvbj4KCQkJCQkJPGNvbmRpdGlvbnM+CgkJCQkJCQk8YW5kPgoJCQkJCQkJCTxpZi1vcGVyYXRpb24gbW9kZT0icmVnZXgiIG9wPSJlcXVhbCI+c3RhdHVzPC9pZi1vcGVyYXRpb24+CgkJCQkJCQkJPGlmLXhtbC1hdHRyIG1vZGU9InJlZ2V4IiBuYW1lPSJsZXZlbCIgb3A9ImVxdWFsIj5zdWNjZXNzPC9pZi14bWwtYXR0cj4KCQkJCQkJCQk8aWYtb3AtcHJvcGVydHkgbmFtZT0iYXNzb2NpYXRpb24iIG9wPSJhdmFpbGFibGUiLz4KCQkJCQkJCQk8aWYtb3AtcHJvcGVydHkgbmFtZT0ic3JjLWRuIiBvcD0iYXZhaWxhYmxlIi8+CgkJCQkJCQk8L2FuZD4KCQkJCQkJPC9jb25kaXRpb25zPgoJCQkJCQk8YWN0aW9ucz4KCQkJCQkJCTxkby1hZGQtYXNzb2NpYXRpb24+CgkJCQkJCQkJPGFyZy1kbj4KCQkJCQkJCQkJPHRva2VuLW9wLXByb3BlcnR5IG5hbWU9InNyYy1kbiIvPgoJCQkJCQkJCTwvYXJnLWRuPgoJCQkJCQkJCTxhcmctYXNzb2NpYXRpb24+CgkJCQkJCQkJCTx0b2tlbi1vcC1wcm9wZXJ0eSBuYW1lPSJhc3NvY2lhdGlvbiIvPgoJCQkJCQkJCTwvYXJnLWFzc29jaWF0aW9uPgoJCQkJCQkJPC9kby1hZGQtYXNzb2NpYXRpb24+CgkJCQkJCTwvYWN0aW9ucz4KCQkJCQk8L3J1bGU+CgkJCQkJPHJ1bGU+CgkJCQkJCTxkZXNjcmlwdGlvbj5DaGVjayBmb3IgYXNzb2NpYXRpb24gLSBNT0RJRlk8L2Rlc2NyaXB0aW9uPgoJCQkJCQk8Y29uZGl0aW9ucz4KCQkJCQkJCTxhbmQ+CgkJCQkJCQkJPGlmLW9wZXJhdGlvbiBtb2RlPSJyZWdleCIgb3A9ImVxdWFsIj5tb2RpZnk8L2lmLW9wZXJhdGlvbj4KCQkJCQkJCQk8aWYtYXNzb2NpYXRpb24gb3A9Im5vdC1hdmFpbGFibGUiLz4KCQkJCQkJCTwvYW5kPgoJCQkJCQk8L2NvbmRpdGlvbnM+CgkJCQkJCTxhY3Rpb25zPgoJCQkJCQkJPGRvLXNldC1vcC1hc3NvY2lhdGlvbj4KCQkJCQkJCQk8YXJnLWFzc29jaWF0aW9uPgoJCQkJCQkJCQk8dG9rZW4tb3AtYXR0ciBuYW1lPSIkZHJ2LmFzc29jaWF0aW9uJCIvPgoJCQkJCQkJCTwvYXJnLWFzc29jaWF0aW9uPgoJCQkJCQkJPC9kby1zZXQtb3AtYXNzb2NpYXRpb24+CgkJCQkJCTwvYWN0aW9ucz4KCQkJCQk8L3J1bGU+CgkJCQk8L3BvbGljeT4KCQkJPC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iaWRtLWluc3RhbGxhdGlvbmRpcmVjdGl2ZSI+CgkJCTxkcy12YWx1ZT5QRDk0Yld3Z2RtVnljMmx2YmowaU1TNHdJaUJsYm1OdlpHbHVaejBpVlZSR0xUZ2lQejQ4YVc1emRHRnNiR0YwYVc5dUxXUnBjbVZqZEdsMlpUNEtDVHh3YkdGalpXMWxiblFnYkc5allYUnBiMjQ5SW1SbFptRjFiSFFpTHo0S0NUeGtjeTFoZEhSeWFXSjFkR1Z6THo0S0NUeHdiMnhwWTNrdGJHbHVhMkZuWlQ0S0NRazhjRzlzYVdONUxYTmxkQ0J1WVcxbFBTSnBibkIxZENJZ2IzSmtaWEk5SW5kbGFXZG9kQ0lnZG1Gc2RXVTlJalV3TlNJdlBnb0pQQzl3YjJ4cFkza3RiR2x1YTJGblpUNEtQQzlwYm5OMFlXeHNZWFJwYjI0dFpHbHlaV04wYVhabFBnPT08L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0tZGlyZWN0aXZlY2hlY2tzdW0iPgoJCQk8ZHMtdmFsdWU+MTgwMzM5MjU5ODwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9ImlkbS1wYWNrYWdlYXNzb2NndWlkIj4KCQkJPGRzLXZhbHVlPjFGNTBPWFlNXzIwMTUwNTEyMTMwNDA1MDU4MTwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9ImlkbS1wYWNrYWdlZ3VpZCI+CgkJCTxkcy12YWx1ZT5EUTNaUEhYRl8yMDE1MDUxMjEzMDIzMjAxNjU8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0tY29udGVudGNoZWNrc3VtIj4KCQkJPGRzLXZhbHVlPjEwNDM3OTE1Mjc8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJPC9kcy1hdHRyaWJ1dGVzPgo8L2RzLW9iamVjdD4=</pkg-initial-state>
			<pkg-initial-state package-id="DQ3ZPHXF_201505121302320165" pkg-assoc-id="N3J373XE_201506121917120594" version="1.0.1.20180613142919">PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48ZHMtb2JqZWN0IGRzLW9iamVjdC1jbGFzcz0iRGlyWE1MLVJ1bGUiIGRzLW9iamVjdC1uYW1lPSJORVRRUkVTVERDRkctb3RwLUFkZEFzc29jaWF0aW9uIiBuYW1lPSJORVRRUkVTVERDRkctb3RwLUFkZEFzc29jaWF0aW9uIj4KCTxkcy1hdHRyaWJ1dGVzPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJYbWxEYXRhIj4KCQkJPGRzLXZhbHVlPgoJCQkJPHBvbGljeT4KCQkJCQk8cnVsZT4KCQkJCQkJPGRlc2NyaXB0aW9uPkFkZCBhc3NvY2lhdGlvbiB0byB1bmFzc29jaWF0ZWQgdXNlcnMgdXBvbiBNaWdyYXRpb24uPC9kZXNjcmlwdGlvbj4KCQkJCQkJPGNvbW1lbnQgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+VGhlIHBvbGljeSBhcHBlbmRzIHRoZSAmbHQ7YXNzb2NpYXRpb24+IHRvIG1pc3NpbmcgaW5zdGFuY2UgZWxlbWVudHMgb24gdHJpZ2dlcmluZyBtaWdyYXRpb24gaW50byBJRFYuIEl0IGFsc28gdXBkYXRlZCB0aGUgRGlyeG1sLUFzc29jaWF0aW9uIGF0dHJpYnV0ZSBvZiB0aGUgdXNlcjwvY29tbWVudD4KCQkJCQkJPGNvbmRpdGlvbnM+CgkJCQkJCQk8YW5kPgoJCQkJCQkJCTxpZi14cGF0aCBvcD0idHJ1ZSI+Ly9zdGF0dXNbQGxldmVsPSJzdWNjZXNzIl08L2lmLXhwYXRoPgoJCQkJCQkJCTxpZi1vcGVyYXRpb24gbW9kZT0ibm9jYXNlIiBvcD0iZXF1YWwiPmluc3RhbmNlPC9pZi1vcGVyYXRpb24+CgkJCQkJCQkJPGlmLWNsYXNzLW5hbWUgbW9kZT0ibm9jYXNlIiBvcD0iZXF1YWwiPlVzZXI8L2lmLWNsYXNzLW5hbWU+CgkJCQkJCQkJPGlmLWFzc29jaWF0aW9uIG9wPSJub3QtYXZhaWxhYmxlIi8+CgkJCQkJCQk8L2FuZD4KCQkJCQkJPC9jb25kaXRpb25zPgoJCQkJCQk8YWN0aW9ucz4KCQkJCQkJCTxkby1zZXQtbG9jYWwtdmFyaWFibGUgbmFtZT0iQXNzb2NpYXRpb25WYWx1ZU5vZGUiIHNjb3BlPSJwb2xpY3kiPgoJCQkJCQkJCTxhcmctbm9kZS1zZXQ+CgkJCQkJCQkJCTx0b2tlbi1xdWVyeSBjbGFzcy1uYW1lPSJVc2VyIiBkYXRhc3RvcmU9InNyYyI+CgkJCQkJCQkJCQk8YXJnLWRuPgoJCQkJCQkJCQkJCTx0b2tlbi1zcmMtZG4vPgoJCQkJCQkJCQkJPC9hcmctZG4+CgkJCQkJCQkJCQk8YXJnLXN0cmluZz4KCQkJCQkJCQkJCQk8dG9rZW4tZ2xvYmFsLXZhcmlhYmxlIG5hbWU9ImRydi5hc3NvY2lhdGlvbiIvPgoJCQkJCQkJCQkJPC9hcmctc3RyaW5nPgoJCQkJCQkJCQk8L3Rva2VuLXF1ZXJ5PgoJCQkJCQkJCTwvYXJnLW5vZGUtc2V0PgoJCQkJCQkJPC9kby1zZXQtbG9jYWwtdmFyaWFibGU+CgkJCQkJCQk8ZG8tc2V0LWxvY2FsLXZhcmlhYmxlIG5hbWU9ImFzc29jaWF0aW9uVmFsdWUiIHNjb3BlPSJwb2xpY3kiPgoJCQkJCQkJCTxhcmctc3RyaW5nPgoJCQkJCQkJCQk8dG9rZW4teHBhdGggZXhwcmVzc2lvbj0iJEFzc29jaWF0aW9uVmFsdWVOb2RlLy9hdHRyL3ZhbHVlL3RleHQoKSIvPgoJCQkJCQkJCTwvYXJnLXN0cmluZz4KCQkJCQkJCTwvZG8tc2V0LWxvY2FsLXZhcmlhYmxlPgoJCQkJCQkJPGRvLWFkZC1hc3NvY2lhdGlvbiBkaXJlY3Q9InRydWUiPgoJCQkJCQkJCTxhcmctYXNzb2NpYXRpb24+CgkJCQkJCQkJCTx0b2tlbi1sb2NhbC12YXJpYWJsZSBuYW1lPSJhc3NvY2lhdGlvblZhbHVlIi8+CgkJCQkJCQkJPC9hcmctYXNzb2NpYXRpb24+CgkJCQkJCQk8L2RvLWFkZC1hc3NvY2lhdGlvbj4KCQkJCQkJCTxkby1hcHBlbmQteG1sLWVsZW1lbnQgZXhwcmVzc2lvbj0iJGN1cnJlbnQtb3AiIG5hbWU9ImFzc29jaWF0aW9uIi8+CgkJCQkJCQk8ZG8tYXBwZW5kLXhtbC10ZXh0IGV4cHJlc3Npb249IiRjdXJyZW50LW9wL2Fzc29jaWF0aW9uIj4KCQkJCQkJCQk8YXJnLXN0cmluZz4KCQkJCQkJCQkJPHRva2VuLWxvY2FsLXZhcmlhYmxlIG5hbWU9ImFzc29jaWF0aW9uVmFsdWUiLz4KCQkJCQkJCQk8L2FyZy1zdHJpbmc+CgkJCQkJCQk8L2RvLWFwcGVuZC14bWwtdGV4dD4KCQkJCQkJPC9hY3Rpb25zPgoJCQkJCTwvcnVsZT4KCQkJCQk8cnVsZT4KCQkJCQkJPGRlc2NyaXB0aW9uPkFkZCBhc3NvY2lhdGlvbiB0byB1bmFzc29jaWF0ZWQgZ3JvdXBzIHVwb24gTWlncmF0aW9uLjwvZGVzY3JpcHRpb24+CgkJCQkJCTxjb21tZW50IHhtbDpzcGFjZT0icHJlc2VydmUiPlRoZSBwb2xpY3kgYXBwZW5kcyAmbHQ7YXNzb2NpYXRpb24+IHRvIG1pc3NpbmcgaW5zdGFuY2UgZWxlbWVudHMgb24gdHJpZ2dlcmluZyBtaWdyYXRpb24gaW50byBJRFYuIEl0IGFsc28gdXBkYXRlZCB0aGUgRGlyeG1sLUFzc29jaWF0aW9uIGF0dHJpYnV0ZSBvZiB0aGUgZ3JvdXA8L2NvbW1lbnQ+CgkJCQkJCTxjb25kaXRpb25zPgoJCQkJCQkJPGFuZD4KCQkJCQkJCQk8aWYteHBhdGggb3A9InRydWUiPi8vc3RhdHVzW0BsZXZlbD0ic3VjY2VzcyJdPC9pZi14cGF0aD4KCQkJCQkJCQk8aWYtb3BlcmF0aW9uIG1vZGU9Im5vY2FzZSIgb3A9ImVxdWFsIj5pbnN0YW5jZTwvaWYtb3BlcmF0aW9uPgoJCQkJCQkJCTxpZi1jbGFzcy1uYW1lIG1vZGU9Im5vY2FzZSIgb3A9ImVxdWFsIj5Hcm91cDwvaWYtY2xhc3MtbmFtZT4KCQkJCQkJCQk8aWYtYXNzb2NpYXRpb24gb3A9Im5vdC1hdmFpbGFibGUiLz4KCQkJCQkJCTwvYW5kPgoJCQkJCQk8L2NvbmRpdGlvbnM+CgkJCQkJCTxhY3Rpb25zPgoJCQkJCQkJPGRvLXNldC1sb2NhbC12YXJpYWJsZSBuYW1lPSJBc3NvY2lhdGlvblZhbHVlTm9kZSIgc2NvcGU9InBvbGljeSI+CgkJCQkJCQkJPGFyZy1ub2RlLXNldD4KCQkJCQkJCQkJPHRva2VuLXF1ZXJ5IGNsYXNzLW5hbWU9Ikdyb3VwIiBkYXRhc3RvcmU9InNyYyI+CgkJCQkJCQkJCQk8YXJnLWRuPgoJCQkJCQkJCQkJCTx0b2tlbi1zcmMtZG4vPgoJCQkJCQkJCQkJPC9hcmctZG4+CgkJCQkJCQkJCQk8YXJnLXN0cmluZz4KCQkJCQkJCQkJCQk8dG9rZW4tZ2xvYmFsLXZhcmlhYmxlIG5hbWU9ImRydi5hc3NvY2lhdGlvbiIvPgoJCQkJCQkJCQkJPC9hcmctc3RyaW5nPgoJCQkJCQkJCQk8L3Rva2VuLXF1ZXJ5PgoJCQkJCQkJCTwvYXJnLW5vZGUtc2V0PgoJCQkJCQkJPC9kby1zZXQtbG9jYWwtdmFyaWFibGU+CgkJCQkJCQk8ZG8tc2V0LWxvY2FsLXZhcmlhYmxlIG5hbWU9ImFzc29jaWF0aW9uVmFsdWUiIHNjb3BlPSJwb2xpY3kiPgoJCQkJCQkJCTxhcmctc3RyaW5nPgoJCQkJCQkJCQk8dG9rZW4teHBhdGggZXhwcmVzc2lvbj0iJEFzc29jaWF0aW9uVmFsdWVOb2RlLy9hdHRyL3ZhbHVlL3RleHQoKSIvPgoJCQkJCQkJCTwvYXJnLXN0cmluZz4KCQkJCQkJCTwvZG8tc2V0LWxvY2FsLXZhcmlhYmxlPgoJCQkJCQkJPGRvLWFkZC1hc3NvY2lhdGlvbiBkaXJlY3Q9InRydWUiPgoJCQkJCQkJCTxhcmctYXNzb2NpYXRpb24+CgkJCQkJCQkJCTx0b2tlbi1sb2NhbC12YXJpYWJsZSBuYW1lPSJhc3NvY2lhdGlvblZhbHVlIi8+CgkJCQkJCQkJPC9hcmctYXNzb2NpYXRpb24+CgkJCQkJCQk8L2RvLWFkZC1hc3NvY2lhdGlvbj4KCQkJCQkJCTxkby1hcHBlbmQteG1sLWVsZW1lbnQgZXhwcmVzc2lvbj0iJGN1cnJlbnQtb3AiIG5hbWU9ImFzc29jaWF0aW9uIi8+CgkJCQkJCQk8ZG8tYXBwZW5kLXhtbC10ZXh0IGV4cHJlc3Npb249IiRjdXJyZW50LW9wL2Fzc29jaWF0aW9uIj4KCQkJCQkJCQk8YXJnLXN0cmluZz4KCQkJCQkJCQkJPHRva2VuLWxvY2FsLXZhcmlhYmxlIG5hbWU9ImFzc29jaWF0aW9uVmFsdWUiLz4KCQkJCQkJCQk8L2FyZy1zdHJpbmc+CgkJCQkJCQk8L2RvLWFwcGVuZC14bWwtdGV4dD4KCQkJCQkJPC9hY3Rpb25zPgoJCQkJCTwvcnVsZT4KCQkJCTwvcG9saWN5PgoJCQk8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0taW5zdGFsbGF0aW9uZGlyZWN0aXZlIj4KCQkJPGRzLXZhbHVlPlBEOTRiV3dnZG1WeWMybHZiajBpTVM0d0lpQmxibU52WkdsdVp6MGlWVlJHTFRnaVB6NDhhVzV6ZEdGc2JHRjBhVzl1TFdScGNtVmpkR2wyWlQ0S0NUeHdiR0ZqWlcxbGJuUWdiRzlqWVhScGIyNDlJbVJsWm1GMWJIUWlMejRLQ1R4a2N5MWhkSFJ5YVdKMWRHVnpMejRLQ1R4d2IyeHBZM2t0YkdsdWEyRm5aVDRLQ1FrOGNHOXNhV041TFhObGRDQnVZVzFsUFNKdmRYUndkWFFpSUc5eVpHVnlQU0pYWldsbmFIUWlJSFpoYkhWbFBTSTFNREFpTHo0S0NUd3ZjRzlzYVdONUxXeHBibXRoWjJVK0Nqd3ZhVzV6ZEdGc2JHRjBhVzl1TFdScGNtVmpkR2wyWlQ0PTwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9ImlkbS1kaXJlY3RpdmVjaGVja3N1bSI+CgkJCTxkcy12YWx1ZT40NzY3OTEwMTE8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0tcGFja2FnZWFzc29jZ3VpZCI+CgkJCTxkcy12YWx1ZT5OM0ozNzNYRV8yMDE1MDYxMjE5MTcxMjA1OTQ8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0tcGFja2FnZWd1aWQiPgoJCQk8ZHMtdmFsdWU+RFEzWlBIWEZfMjAxNTA1MTIxMzAyMzIwMTY1PC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iaWRtLWNvbnRlbnRjaGVja3N1bSI+CgkJCTxkcy12YWx1ZT4yMzQ5MTYwNTU8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJPC9kcy1hdHRyaWJ1dGVzPgo8L2RzLW9iamVjdD4=</pkg-initial-state>
			<pkg-initial-state package-id="DQ3ZPHXF_201505121302320165" pkg-assoc-id="QRP06MSK_201806121701170286" version="1.0.1.20180613142919">PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48ZHMtb2JqZWN0IGRzLW9iamVjdC1jbGFzcz0iRGlyWE1MLVJ1bGUiIGRzLW9iamVjdC1uYW1lPSJORVRRUkVTVERDRkctb3RwLUNvbnZlcnRRdWVyeUV4VG9RdWVyeSIgbmFtZT0iTkVUUVJFU1REQ0ZHLW90cC1Db252ZXJ0UXVlcnlFeFRvUXVlcnkiPgoJPGRzLWF0dHJpYnV0ZXM+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9IlhtbERhdGEiPgoJCQk8ZHMtdmFsdWU+CgkJCQk8cG9saWN5PgoJCQkJCTxydWxlPgoJCQkJCQk8ZGVzY3JpcHRpb24+Q29udmVydCBxdWVyeS1leCB0byBxdWVyeTwvZGVzY3JpcHRpb24+CgkJCQkJCTxjb25kaXRpb25zPgoJCQkJCQkJPGFuZD4KCQkJCQkJCQk8aWYtb3BlcmF0aW9uIG9wPSJlcXVhbCI+cXVlcnktZXg8L2lmLW9wZXJhdGlvbj4KCQkJCQkJCTwvYW5kPgoJCQkJCQk8L2NvbmRpdGlvbnM+CgkJCQkJCTxhY3Rpb25zPgoJCQkJCQkJPGRvLWFwcGVuZC14bWwtZWxlbWVudCBleHByZXNzaW9uPSIuLiIgbmFtZT0icXVlcnkiLz4KCQkJCQkJCTxkby1jbG9uZS14cGF0aCBkZXN0LWV4cHJlc3Npb249Ii4uL3F1ZXJ5W2xhc3QoKV0iIHNyYy1leHByZXNzaW9uPSJAKiIvPgoJCQkJCQkJPGRvLWNsb25lLXhwYXRoIGRlc3QtZXhwcmVzc2lvbj0iLi4vcXVlcnkiIHNyYy1leHByZXNzaW9uPSIqIi8+CgkJCQkJCQk8ZG8tc3RyaXAteHBhdGggZXhwcmVzc2lvbj0iLiIvPgoJCQkJCQk8L2FjdGlvbnM+CgkJCQkJPC9ydWxlPgoJCQkJPC9wb2xpY3k+CgkJCTwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9ImlkbS1pbnN0YWxsYXRpb25kaXJlY3RpdmUiPgoJCQk8ZHMtdmFsdWU+UEQ5NGJXd2dkbVZ5YzJsdmJqMGlNUzR3SWlCbGJtTnZaR2x1WnowaVZWUkdMVGdpUHo0OGFXNXpkR0ZzYkdGMGFXOXVMV1JwY21WamRHbDJaVDRLQ1R4d2JHRmpaVzFsYm5RZ2JHOWpZWFJwYjI0OUltUmxabUYxYkhRaUx6NEtDVHhrY3kxaGRIUnlhV0oxZEdWekx6NEtDVHh3YjJ4cFkza3RiR2x1YTJGblpUNEtDUWs4Y0c5c2FXTjVMWE5sZENCdVlXMWxQU0p2ZFhSd2RYUWlJRzl5WkdWeVBTSjNaV2xuYUhRaUlIWmhiSFZsUFNJMk1EQWlMejRLQ1R3dmNHOXNhV041TFd4cGJtdGhaMlUrQ2p3dmFXNXpkR0ZzYkdGMGFXOXVMV1JwY21WamRHbDJaVDQ9PC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iaWRtLWRpcmVjdGl2ZWNoZWNrc3VtIj4KCQkJPGRzLXZhbHVlPjMwNDE0MzA5OTwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9ImlkbS1wYWNrYWdlYXNzb2NndWlkIj4KCQkJPGRzLXZhbHVlPlFSUDA2TVNLXzIwMTgwNjEyMTcwMTE3MDI4NjwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9ImlkbS1wYWNrYWdlZ3VpZCI+CgkJCTxkcy12YWx1ZT5EUTNaUEhYRl8yMDE1MDUxMjEzMDIzMjAxNjU8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0tY29udGVudGNoZWNrc3VtIj4KCQkJPGRzLXZhbHVlPjE2MjQ0NDcwNTc8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJPC9kcy1hdHRyaWJ1dGVzPgo8L2RzLW9iamVjdD4=</pkg-initial-state>
			<pkg-initial-state package-id="DQ3ZPHXF_201505121302320165" pkg-assoc-id="6MZKAGBJ_201806131428420678" version="1.0.1.20180613142919">PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48ZHMtb2JqZWN0IGRzLW9iamVjdC1jbGFzcz0iRGlyWE1MLVJ1bGUiIGRzLW9iamVjdC1uYW1lPSJORVRRUkVTVERDRkctb3RwLUFkZEZyb21DcHJzRmxhZyIgbmFtZT0iTkVUUVJFU1REQ0ZHLW90cC1BZGRGcm9tQ3Byc0ZsYWciPgoJPGRzLWF0dHJpYnV0ZXM+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9IlhtbERhdGEiPgoJCQk8ZHMtdmFsdWU+CgkJCQk8cG9saWN5PgoJCQkJCTxydWxlPgoJCQkJCQk8ZGVzY3JpcHRpb24+QWRkIGZyb20tY3BycyBmbGFnIHRvIGRyaXZlci1vcGVyYXRpb24tZGF0YTwvZGVzY3JpcHRpb24+CgkJCQkJCTxjb25kaXRpb25zPgoJCQkJCQkJPGFuZD4KCQkJCQkJCQk8aWYtb3AtcHJvcGVydHkgbmFtZT0iZnJvbS1jcHJzIiBvcD0iZXF1YWwiPnRydWU8L2lmLW9wLXByb3BlcnR5PgoJCQkJCQkJCTxpZi1vcGVyYXRpb24gb3A9ImVxdWFsIj5kcml2ZXItb3BlcmF0aW9uLWRhdGE8L2lmLW9wZXJhdGlvbj4KCQkJCQkJCTwvYW5kPgoJCQkJCQk8L2NvbmRpdGlvbnM+CgkJCQkJCTxhY3Rpb25zPgoJCQkJCQkJPGRvLXNldC14bWwtYXR0ciBleHByZXNzaW9uPSIuIiBuYW1lPSJmcm9tLWNwcnMiPgoJCQkJCQkJCTxhcmctc3RyaW5nPgoJCQkJCQkJCQk8dG9rZW4tdGV4dCB4bWw6c3BhY2U9InByZXNlcnZlIj50cnVlPC90b2tlbi10ZXh0PgoJCQkJCQkJCTwvYXJnLXN0cmluZz4KCQkJCQkJCTwvZG8tc2V0LXhtbC1hdHRyPgoJCQkJCQk8L2FjdGlvbnM+CgkJCQkJPC9ydWxlPgoJCQkJPC9wb2xpY3k+CgkJCTwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9ImlkbS1pbnN0YWxsYXRpb25kaXJlY3RpdmUiPgoJCQk8ZHMtdmFsdWU+UEQ5NGJXd2dkbVZ5YzJsdmJqMGlNUzR3SWlCbGJtTnZaR2x1WnowaVZWUkdMVGdpUHo0OGFXNXpkR0ZzYkdGMGFXOXVMV1JwY21WamRHbDJaVDRLQ1R4d2JHRmpaVzFsYm5RZ2JHOWpZWFJwYjI0OUltUmxabUYxYkhRaUx6NEtDVHhrY3kxaGRIUnlhV0oxZEdWekx6NEtDVHh3YjJ4cFkza3RiR2x1YTJGblpUNEtDUWs4Y0c5c2FXTjVMWE5sZENCdVlXMWxQU0p2ZFhSd2RYUWlJRzl5WkdWeVBTSjNaV2xuYUhRaUlIWmhiSFZsUFNJNU5UQWlMejRLQ1R3dmNHOXNhV041TFd4cGJtdGhaMlUrQ2p3dmFXNXpkR0ZzYkdGMGFXOXVMV1JwY21WamRHbDJaVDQ9PC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iaWRtLWRpcmVjdGl2ZWNoZWNrc3VtIj4KCQkJPGRzLXZhbHVlPjM4OTAyMTE2MjwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9ImlkbS1wYWNrYWdlYXNzb2NndWlkIj4KCQkJPGRzLXZhbHVlPjZNWktBR0JKXzIwMTgwNjEzMTQyODQyMDY3ODwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9ImlkbS1wYWNrYWdlZ3VpZCI+CgkJCTxkcy12YWx1ZT5EUTNaUEhYRl8yMDE1MDUxMjEzMDIzMjAxNjU8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0tY29udGVudGNoZWNrc3VtIj4KCQkJPGRzLXZhbHVlPjIzODE4NDAyMjU8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJPC9kcy1hdHRyaWJ1dGVzPgo8L2RzLW9iamVjdD4=</pkg-initial-state>
			<pkg-initial-state package-id="CP32RFWU_201505121250070695" pkg-assoc-id="964C650E_201505121250070695" version="1.1.0.20200528134627">PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48ZHMtb2JqZWN0IGRzLW9iamVjdC1jbGFzcz0iRGlyWE1MLVJ1bGUiIGRzLW9iamVjdC1uYW1lPSJORVRRUkVTVEpTT04taXRwLUNoZWNrUmV0cmllcyIgbmFtZT0iTkVUUVJFU1RKU09OLWl0cC1DaGVja1JldHJpZXMiPgoJPGRzLWF0dHJpYnV0ZXM+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9IlhtbERhdGEiPgoJCQk8ZHMtdmFsdWU+CgkJCQk8cG9saWN5PgoJCQkJCTxydWxlPgoJCQkJCQk8ZGVzY3JpcHRpb24+c2V0IHJldHJ5IG9uIHN0YXR1cyBpZiBzb3VnaHQ8L2Rlc2NyaXB0aW9uPgoJCQkJCQk8Y29uZGl0aW9ucz4KCQkJCQkJCTxhbmQ+CgkJCQkJCQkJPGlmLW9wZXJhdGlvbiBtb2RlPSJjYXNlIiBvcD0iZXF1YWwiPnN0YXR1czwvaWYtb3BlcmF0aW9uPgoJCQkJCQkJCTxpZi14bWwtYXR0ciBtb2RlPSJub2Nhc2UiIG5hbWU9ImxldmVsIiBvcD0iZXF1YWwiPnN1Y2Nlc3M8L2lmLXhtbC1hdHRyPgoJCQkJCQkJCTxpZi14cGF0aCBvcD0idHJ1ZSI+ZHJpdmVyLW9wZXJhdGlvbi1kYXRhL0ByZXRyeT0idHJ1ZSI8L2lmLXhwYXRoPgoJCQkJCQkJPC9hbmQ+CgkJCQkJCTwvY29uZGl0aW9ucz4KCQkJCQkJPGFjdGlvbnM+CgkJCQkJCQk8ZG8tc2V0LXhtbC1hdHRyIGV4cHJlc3Npb249IiRjdXJyZW50LW9wIiBuYW1lPSJsZXZlbCI+CgkJCQkJCQkJPGFyZy1zdHJpbmc+CgkJCQkJCQkJCTx0b2tlbi10ZXh0IHhtbDpzcGFjZT0icHJlc2VydmUiPnJldHJ5PC90b2tlbi10ZXh0PgoJCQkJCQkJCTwvYXJnLXN0cmluZz4KCQkJCQkJCTwvZG8tc2V0LXhtbC1hdHRyPgoJCQkJCQk8L2FjdGlvbnM+CgkJCQkJPC9ydWxlPgoJCQkJPC9wb2xpY3k+CgkJCTwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9ImlkbS1pbnN0YWxsYXRpb25kaXJlY3RpdmUiPgoJCQk8ZHMtdmFsdWU+UEQ5NGJXd2dkbVZ5YzJsdmJqMGlNUzR3SWlCbGJtTnZaR2x1WnowaVZWUkdMVGdpUHo0OGFXNXpkR0ZzYkdGMGFXOXVMV1JwY21WamRHbDJaVDRLQ1R4d2JHRmpaVzFsYm5RZ2JHOWpZWFJwYjI0OUltUmxabUYxYkhRaUx6NEtDVHhrY3kxaGRIUnlhV0oxZEdWekx6NEtDVHh3YjJ4cFkza3RiR2x1YTJGblpUNEtDUWs4Y0c5c2FXTjVMWE5sZENCdVlXMWxQU0pwYm5CMWRDSWdiM0prWlhJOUluZGxhV2RvZENJZ2RtRnNkV1U5SWpFMU1DSXZQZ29KUEM5d2IyeHBZM2t0YkdsdWEyRm5aVDRLUEM5cGJuTjBZV3hzWVhScGIyNHRaR2x5WldOMGFYWmxQZz09PC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iaWRtLWRpcmVjdGl2ZWNoZWNrc3VtIj4KCQkJPGRzLXZhbHVlPjM1NTExMTU3NjI8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0tcGFja2FnZWFzc29jZ3VpZCI+CgkJCTxkcy12YWx1ZT45NjRDNjUwRV8yMDE1MDUxMjEyNTAwNzA2OTU8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0tcGFja2FnZWd1aWQiPgoJCQk8ZHMtdmFsdWU+Q1AzMlJGV1VfMjAxNTA1MTIxMjUwMDcwNjk1PC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iaWRtLWNvbnRlbnRjaGVja3N1bSI+CgkJCTxkcy12YWx1ZT4zMjAzODM2MTY5PC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCTwvZHMtYXR0cmlidXRlcz4KPC9kcy1vYmplY3Q+</pkg-initial-state>
			<pkg-initial-state package-id="XTEF1YO3_201006231733410161" pkg-assoc-id="P3E27K73_201006231751340034" version="2.1.2.20190806140123">PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48ZHMtb2JqZWN0IGRzLW9iamVjdC1jbGFzcz0iRGlyWE1MLVJ1bGUiIGRzLW9iamVjdC1uYW1lPSJOT1ZMUFdEU1lOQy1pdHAtRW1haWxPbkZhaWxlZFB3ZFN1YiIgbmFtZT0iTk9WTFBXRFNZTkMtaXRwLUVtYWlsT25GYWlsZWRQd2RTdWIiPgoJPGRzLWF0dHJpYnV0ZXM+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9IlhtbERhdGEiPgoJCQk8ZHMtdmFsdWU+CgkJCQk8cG9saWN5PgoJCQkJCTxkZXNjcmlwdGlvbj5FbWFpbCBub3RpZmljYXRpb25zIGZvciBmYWlsZWQgcGFzc3dvcmQgc3Vic2NyaXB0aW9uczwvZGVzY3JpcHRpb24+CgkJCQkJPHJ1bGU+CgkJCQkJCTxkZXNjcmlwdGlvbj5TZW5kIGUtbWFpbCBvbiBhIGZhaWx1cmUgd2hlbiBzdWJzY3JpYmluZyB0byBwYXNzd29yZHM8L2Rlc2NyaXB0aW9uPgoJCQkJCQk8Y29uZGl0aW9ucz4KCQkJCQkJCTxhbmQ+CgkJCQkJCQkJPGlmLWdsb2JhbC12YXJpYWJsZSBtb2RlPSJub2Nhc2UiIG5hbWU9Im5vdGlmeS11c2VyLW9uLXBhc3N3b3JkLWRpc3QtZmFpbHVyZSIgb3A9ImVxdWFsIj50cnVlPC9pZi1nbG9iYWwtdmFyaWFibGU+CgkJCQkJCQkJPGlmLW9wZXJhdGlvbiBvcD0iZXF1YWwiPnN0YXR1czwvaWYtb3BlcmF0aW9uPgoJCQkJCQkJCTxpZi14cGF0aCBvcD0idHJ1ZSI+c2VsZjo6c3RhdHVzW0BsZXZlbCAhPSAnc3VjY2VzcyddW3RleHQoKSAhPSAnJ10vb3BlcmF0aW9uLWRhdGEvcGFzc3dvcmQtc3Vic2NyaWJlLXN0YXR1cy9hc3NvY2lhdGlvblt0ZXh0KCkgIT0gJyddPC9pZi14cGF0aD4KCQkJCQkJCTwvYW5kPgoJCQkJCQk8L2NvbmRpdGlvbnM+CgkJCQkJCTxhY3Rpb25zPgoJCQkJCQkJPGRvLXNlbmQtZW1haWwtZnJvbS10ZW1wbGF0ZSBub3RpZmljYXRpb24tZG49ImNuPXNlY3VyaXR5XGNuPURlZmF1bHQgTm90aWZpY2F0aW9uIENvbGxlY3Rpb24iIHRlbXBsYXRlLWRuPSJjbj1zZWN1cml0eVxjbj1EZWZhdWx0IE5vdGlmaWNhdGlvbiBDb2xsZWN0aW9uXGNuPVBhc3N3b3JkIFNldCBGYWlsIj4KCQkJCQkJCQk8YXJnLXN0cmluZyBuYW1lPSJVc2VyRnVsbE5hbWUiPgoJCQkJCQkJCQk8dG9rZW4tZGVzdC1hdHRyIG5hbWU9IkZ1bGwgTmFtZSI+CgkJCQkJCQkJCQk8YXJnLWFzc29jaWF0aW9uPgoJCQkJCQkJCQkJCTx0b2tlbi14cGF0aCBleHByZXNzaW9uPSJzZWxmOjpzdGF0dXMvb3BlcmF0aW9uLWRhdGEvcGFzc3dvcmQtc3Vic2NyaWJlLXN0YXR1cy9hc3NvY2lhdGlvbiIvPgoJCQkJCQkJCQkJPC9hcmctYXNzb2NpYXRpb24+CgkJCQkJCQkJCTwvdG9rZW4tZGVzdC1hdHRyPgoJCQkJCQkJCTwvYXJnLXN0cmluZz4KCQkJCQkJCQk8YXJnLXN0cmluZyBuYW1lPSJVc2VyR2l2ZW5OYW1lIj4KCQkJCQkJCQkJPHRva2VuLWRlc3QtYXR0ciBuYW1lPSJHaXZlbiBOYW1lIj4KCQkJCQkJCQkJCTxhcmctYXNzb2NpYXRpb24+CgkJCQkJCQkJCQkJPHRva2VuLXhwYXRoIGV4cHJlc3Npb249InNlbGY6OnN0YXR1cy9vcGVyYXRpb24tZGF0YS9wYXNzd29yZC1zdWJzY3JpYmUtc3RhdHVzL2Fzc29jaWF0aW9uIi8+CgkJCQkJCQkJCQk8L2FyZy1hc3NvY2lhdGlvbj4KCQkJCQkJCQkJPC90b2tlbi1kZXN0LWF0dHI+CgkJCQkJCQkJPC9hcmctc3RyaW5nPgoJCQkJCQkJCTxhcmctc3RyaW5nIG5hbWU9IlVzZXJMYXN0TmFtZSI+CgkJCQkJCQkJCTx0b2tlbi1kZXN0LWF0dHIgbmFtZT0iU3VybmFtZSI+CgkJCQkJCQkJCQk8YXJnLWFzc29jaWF0aW9uPgoJCQkJCQkJCQkJCTx0b2tlbi14cGF0aCBleHByZXNzaW9uPSJzZWxmOjpzdGF0dXMvb3BlcmF0aW9uLWRhdGEvcGFzc3dvcmQtc3Vic2NyaWJlLXN0YXR1cy9hc3NvY2lhdGlvbiIvPgoJCQkJCQkJCQkJPC9hcmctYXNzb2NpYXRpb24+CgkJCQkJCQkJCTwvdG9rZW4tZGVzdC1hdHRyPgoJCQkJCQkJCTwvYXJnLXN0cmluZz4KCQkJCQkJCQk8YXJnLXN0cmluZyBuYW1lPSJDb25uZWN0ZWRTeXN0ZW1OYW1lIj4KCQkJCQkJCQkJPHRva2VuLWdsb2JhbC12YXJpYWJsZSBuYW1lPSJDb25uZWN0ZWRTeXN0ZW1OYW1lIi8+CgkJCQkJCQkJPC9hcmctc3RyaW5nPgoJCQkJCQkJCTxhcmctc3RyaW5nIG5hbWU9IkZhaWx1cmVSZWFzb24iPgoJCQkJCQkJCQk8dG9rZW4tdGV4dC8+CgkJCQkJCQkJCTx0b2tlbi14cGF0aCBleHByZXNzaW9uPSJzZWxmOjpzdGF0dXMvY2hpbGQ6OnRleHQoKSIvPgoJCQkJCQkJCTwvYXJnLXN0cmluZz4KCQkJCQkJCQk8YXJnLXN0cmluZyBuYW1lPSJ0byI+CgkJCQkJCQkJCTx0b2tlbi1kZXN0LWF0dHIgbmFtZT0iSW50ZXJuZXQgRU1haWwgQWRkcmVzcyI+CgkJCQkJCQkJCQk8YXJnLWFzc29jaWF0aW9uPgoJCQkJCQkJCQkJCTx0b2tlbi14cGF0aCBleHByZXNzaW9uPSJzZWxmOjpzdGF0dXMvb3BlcmF0aW9uLWRhdGEvcGFzc3dvcmQtc3Vic2NyaWJlLXN0YXR1cy9hc3NvY2lhdGlvbiIvPgoJCQkJCQkJCQkJPC9hcmctYXNzb2NpYXRpb24+CgkJCQkJCQkJCTwvdG9rZW4tZGVzdC1hdHRyPgoJCQkJCQkJCTwvYXJnLXN0cmluZz4KCQkJCQkJCTwvZG8tc2VuZC1lbWFpbC1mcm9tLXRlbXBsYXRlPgoJCQkJCQk8L2FjdGlvbnM+CgkJCQkJPC9ydWxlPgoJCQkJCTxydWxlPgoJCQkJCQk8ZGVzY3JpcHRpb24+U2VuZCBlLW1haWwgb24gZmFpbHVyZSB0byByZXNldCBjb25uZWN0ZWQgc3lzdGVtIHBhc3N3b3JkIHVzaW5nIHRoZSBJZGVudGl0eSBWYXVsdCBwYXNzd29yZDwvZGVzY3JpcHRpb24+CgkJCQkJCTxjb25kaXRpb25zPgoJCQkJCQkJPGFuZD4KCQkJCQkJCQk8aWYtZ2xvYmFsLXZhcmlhYmxlIG1vZGU9Im5vY2FzZSIgbmFtZT0ibm90aWZ5LXVzZXItb24tcGFzc3dvcmQtZGlzdC1mYWlsdXJlIiBvcD0iZXF1YWwiPnRydWU8L2lmLWdsb2JhbC12YXJpYWJsZT4KCQkJCQkJCQk8aWYtb3BlcmF0aW9uIG9wPSJlcXVhbCI+c3RhdHVzPC9pZi1vcGVyYXRpb24+CgkJCQkJCQkJPGlmLXhwYXRoIG9wPSJ0cnVlIj5zZWxmOjpzdGF0dXNbQGxldmVsICE9ICdzdWNjZXNzJ10vb3BlcmF0aW9uLWRhdGEvcGFzc3dvcmQtcmVzZXQtc3RhdHVzPC9pZi14cGF0aD4KCQkJCQkJCTwvYW5kPgoJCQkJCQk8L2NvbmRpdGlvbnM+CgkJCQkJCTxhY3Rpb25zPgoJCQkJCQkJPGRvLXNlbmQtZW1haWwtZnJvbS10ZW1wbGF0ZSBub3RpZmljYXRpb24tZG49ImNuPXNlY3VyaXR5XGNuPURlZmF1bHQgTm90aWZpY2F0aW9uIENvbGxlY3Rpb24iIHRlbXBsYXRlLWRuPSJjbj1zZWN1cml0eVxjbj1EZWZhdWx0IE5vdGlmaWNhdGlvbiBDb2xsZWN0aW9uXGNuPVBhc3N3b3JkIFJlc2V0IEZhaWwiPgoJCQkJCQkJCTxhcmctc3RyaW5nIG5hbWU9IlVzZXJGdWxsTmFtZSI+CgkJCQkJCQkJCTx0b2tlbi1kZXN0LWF0dHIgbmFtZT0iRnVsbCBOYW1lIj4KCQkJCQkJCQkJCTxhcmctYXNzb2NpYXRpb24+CgkJCQkJCQkJCQkJPHRva2VuLXhwYXRoIGV4cHJlc3Npb249InNlbGY6OnN0YXR1cy9vcGVyYXRpb24tZGF0YS9wYXNzd29yZC1yZXNldC1zdGF0dXMvYXNzb2NpYXRpb24iLz4KCQkJCQkJCQkJCTwvYXJnLWFzc29jaWF0aW9uPgoJCQkJCQkJCQk8L3Rva2VuLWRlc3QtYXR0cj4KCQkJCQkJCQk8L2FyZy1zdHJpbmc+CgkJCQkJCQkJPGFyZy1zdHJpbmcgbmFtZT0iVXNlckdpdmVuTmFtZSI+CgkJCQkJCQkJCTx0b2tlbi1kZXN0LWF0dHIgbmFtZT0iR2l2ZW4gTmFtZSI+CgkJCQkJCQkJCQk8YXJnLWFzc29jaWF0aW9uPgoJCQkJCQkJCQkJCTx0b2tlbi14cGF0aCBleHByZXNzaW9uPSJzZWxmOjpzdGF0dXMvb3BlcmF0aW9uLWRhdGEvcGFzc3dvcmQtcmVzZXQtc3RhdHVzL2Fzc29jaWF0aW9uIi8+CgkJCQkJCQkJCQk8L2FyZy1hc3NvY2lhdGlvbj4KCQkJCQkJCQkJPC90b2tlbi1kZXN0LWF0dHI+CgkJCQkJCQkJPC9hcmctc3RyaW5nPgoJCQkJCQkJCTxhcmctc3RyaW5nIG5hbWU9IlVzZXJMYXN0TmFtZSI+CgkJCQkJCQkJCTx0b2tlbi1kZXN0LWF0dHIgbmFtZT0iU3VybmFtZSI+CgkJCQkJCQkJCQk8YXJnLWFzc29jaWF0aW9uPgoJCQkJCQkJCQkJCTx0b2tlbi14cGF0aCBleHByZXNzaW9uPSJzZWxmOjpzdGF0dXMvb3BlcmF0aW9uLWRhdGEvcGFzc3dvcmQtcmVzZXQtc3RhdHVzL2Fzc29jaWF0aW9uIi8+CgkJCQkJCQkJCQk8L2FyZy1hc3NvY2lhdGlvbj4KCQkJCQkJCQkJPC90b2tlbi1kZXN0LWF0dHI+CgkJCQkJCQkJPC9hcmctc3RyaW5nPgoJCQkJCQkJCTxhcmctc3RyaW5nIG5hbWU9IkNvbm5lY3RlZFN5c3RlbU5hbWUiPgoJCQkJCQkJCQk8dG9rZW4tZ2xvYmFsLXZhcmlhYmxlIG5hbWU9IkNvbm5lY3RlZFN5c3RlbU5hbWUiLz4KCQkJCQkJCQk8L2FyZy1zdHJpbmc+CgkJCQkJCQkJPGFyZy1zdHJpbmcgbmFtZT0iRmFpbHVyZVJlYXNvbiI+CgkJCQkJCQkJCTx0b2tlbi10ZXh0Lz4KCQkJCQkJCQkJPHRva2VuLXhwYXRoIGV4cHJlc3Npb249InNlbGY6OnN0YXR1cy9jaGlsZDo6dGV4dCgpIi8+CgkJCQkJCQkJPC9hcmctc3RyaW5nPgoJCQkJCQkJCTxhcmctc3RyaW5nIG5hbWU9InRvIj4KCQkJCQkJCQkJPHRva2VuLWRlc3QtYXR0ciBuYW1lPSJJbnRlcm5ldCBFTWFpbCBBZGRyZXNzIj4KCQkJCQkJCQkJCTxhcmctYXNzb2NpYXRpb24+CgkJCQkJCQkJCQkJPHRva2VuLXhwYXRoIGV4cHJlc3Npb249InNlbGY6OnN0YXR1cy9vcGVyYXRpb24tZGF0YS9wYXNzd29yZC1yZXNldC1zdGF0dXMvYXNzb2NpYXRpb24iLz4KCQkJCQkJCQkJCTwvYXJnLWFzc29jaWF0aW9uPgoJCQkJCQkJCQk8L3Rva2VuLWRlc3QtYXR0cj4KCQkJCQkJCQk8L2FyZy1zdHJpbmc+CgkJCQkJCQk8L2RvLXNlbmQtZW1haWwtZnJvbS10ZW1wbGF0ZT4KCQkJCQkJPC9hY3Rpb25zPgoJCQkJCTwvcnVsZT4KCQkJCTwvcG9saWN5PgoJCQk8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0taW5zdGFsbGF0aW9uZGlyZWN0aXZlIj4KCQkJPGRzLXZhbHVlPlBEOTRiV3dnZG1WeWMybHZiajBpTVM0d0lpQmxibU52WkdsdVp6MGlWVlJHTFRnaVB6NDhhVzV6ZEdGc2JHRjBhVzl1TFdScGNtVmpkR2wyWlQ0S0NUeHdiR0ZqWlcxbGJuUWdiRzlqWVhScGIyNDlJbVJsWm1GMWJIUWlMejRLQ1R4a2N5MWhkSFJ5YVdKMWRHVnpMejRLQ1R4d2IyeHBZM2t0YkdsdWEyRm5aUzgrQ2p3dmFXNXpkR0ZzYkdGMGFXOXVMV1JwY21WamRHbDJaVDQ9PC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iaWRtLWRpcmVjdGl2ZWNoZWNrc3VtIj4KCQkJPGRzLXZhbHVlPjM3NTcxMzc0MDE8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0tcGFja2FnZWFzc29jZ3VpZCI+CgkJCTxkcy12YWx1ZT5QM0UyN0s3M18yMDEwMDYyMzE3NTEzNDAwMzQ8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0tcGFja2FnZWd1aWQiPgoJCQk8ZHMtdmFsdWU+WFRFRjFZTzNfMjAxMDA2MjMxNzMzNDEwMTYxPC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iaWRtLWNvbnRlbnRjaGVja3N1bSI+CgkJCTxkcy12YWx1ZT4xMDgzOTU5MTAyPC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCTwvZHMtYXR0cmlidXRlcz4KPC9kcy1vYmplY3Q+</pkg-initial-state>
			<pkg-initial-state package-id="XTEF1YO3_201006231733410161" pkg-assoc-id="MBHAM66E_201006231751400713" version="2.1.2.20190806140123">PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48ZHMtb2JqZWN0IGRzLW9iamVjdC1jbGFzcz0iRGlyWE1MLVJ1bGUiIGRzLW9iamVjdC1uYW1lPSJOT1ZMUFdEU1lOQy1vdHAtRW1haWxPbkZhaWxlZFB3ZFB1YiIgbmFtZT0iTk9WTFBXRFNZTkMtb3RwLUVtYWlsT25GYWlsZWRQd2RQdWIiPgoJPGRzLWF0dHJpYnV0ZXM+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9IlhtbERhdGEiPgoJCQk8ZHMtdmFsdWU+CgkJCQk8cG9saWN5PgoJCQkJCTxkZXNjcmlwdGlvbj5FbWFpbCBub3RpZmljYXRpb25zIGZvciBmYWlsZWQgcGFzc3dvcmQgcHVibGljYXRpb25zPC9kZXNjcmlwdGlvbj4KCQkJCQk8cnVsZT4KCQkJCQkJPGRlc2NyaXB0aW9uPlNlbmQgZS1tYWlsIGZvciBhIGZhaWxlZCBwdWJsaXNoIHBhc3N3b3JkIG9wZXJhdGlvbjwvZGVzY3JpcHRpb24+CgkJCQkJCTxjb25kaXRpb25zPgoJCQkJCQkJPGFuZD4KCQkJCQkJCQk8aWYtZ2xvYmFsLXZhcmlhYmxlIG1vZGU9Im5vY2FzZSIgbmFtZT0ibm90aWZ5LXVzZXItb24tcGFzc3dvcmQtZGlzdC1mYWlsdXJlIiBvcD0iZXF1YWwiPnRydWU8L2lmLWdsb2JhbC12YXJpYWJsZT4KCQkJCQkJCQk8aWYtb3BlcmF0aW9uIG9wPSJlcXVhbCI+c3RhdHVzPC9pZi1vcGVyYXRpb24+CgkJCQkJCQkJPGlmLXhwYXRoIG9wPSJ0cnVlIj5zZWxmOjpzdGF0dXNbQGxldmVsICE9ICdzdWNjZXNzJ10vb3BlcmF0aW9uLWRhdGEvcGFzc3dvcmQtcHVibGlzaC1zdGF0dXM8L2lmLXhwYXRoPgoJCQkJCQkJPC9hbmQ+CgkJCQkJCTwvY29uZGl0aW9ucz4KCQkJCQkJPGFjdGlvbnM+CgkJCQkJCQk8IS0tIGdlbmVyYXRlIGVtYWlsIG5vdGlmaWNhdGlvbiAtLT4KCQkJCQkJCTxkby1zZW5kLWVtYWlsLWZyb20tdGVtcGxhdGUgbm90aWZpY2F0aW9uLWRuPSJjbj1zZWN1cml0eVxjbj1EZWZhdWx0IE5vdGlmaWNhdGlvbiBDb2xsZWN0aW9uIiB0ZW1wbGF0ZS1kbj0iY249c2VjdXJpdHlcY249RGVmYXVsdCBOb3RpZmljYXRpb24gQ29sbGVjdGlvblxjbj1QYXNzd29yZCBTeW5jIEZhaWwiPgoJCQkJCQkJCTxhcmctc3RyaW5nIG5hbWU9IlVzZXJGdWxsTmFtZSI+CgkJCQkJCQkJCTx0b2tlbi1zcmMtYXR0ciBuYW1lPSJGdWxsIE5hbWUiPgoJCQkJCQkJCQkJPGFyZy1hc3NvY2lhdGlvbj4KCQkJCQkJCQkJCQk8dG9rZW4teHBhdGggZXhwcmVzc2lvbj0ic2VsZjo6c3RhdHVzL29wZXJhdGlvbi1kYXRhL3Bhc3N3b3JkLXB1Ymxpc2gtc3RhdHVzL2Fzc29jaWF0aW9uIi8+CgkJCQkJCQkJCQk8L2FyZy1hc3NvY2lhdGlvbj4KCQkJCQkJCQkJPC90b2tlbi1zcmMtYXR0cj4KCQkJCQkJCQk8L2FyZy1zdHJpbmc+CgkJCQkJCQkJPGFyZy1zdHJpbmcgbmFtZT0iVXNlckdpdmVuTmFtZSI+CgkJCQkJCQkJCTx0b2tlbi1zcmMtYXR0ciBuYW1lPSJHaXZlbiBOYW1lIj4KCQkJCQkJCQkJCTxhcmctYXNzb2NpYXRpb24+CgkJCQkJCQkJCQkJPHRva2VuLXhwYXRoIGV4cHJlc3Npb249InNlbGY6OnN0YXR1cy9vcGVyYXRpb24tZGF0YS9wYXNzd29yZC1wdWJsaXNoLXN0YXR1cy9hc3NvY2lhdGlvbiIvPgoJCQkJCQkJCQkJPC9hcmctYXNzb2NpYXRpb24+CgkJCQkJCQkJCTwvdG9rZW4tc3JjLWF0dHI+CgkJCQkJCQkJPC9hcmctc3RyaW5nPgoJCQkJCQkJCTxhcmctc3RyaW5nIG5hbWU9IlVzZXJMYXN0TmFtZSI+CgkJCQkJCQkJCTx0b2tlbi1zcmMtYXR0ciBuYW1lPSJTdXJuYW1lIj4KCQkJCQkJCQkJCTxhcmctYXNzb2NpYXRpb24+CgkJCQkJCQkJCQkJPHRva2VuLXhwYXRoIGV4cHJlc3Npb249InNlbGY6OnN0YXR1cy9vcGVyYXRpb24tZGF0YS9wYXNzd29yZC1wdWJsaXNoLXN0YXR1cy9hc3NvY2lhdGlvbiIvPgoJCQkJCQkJCQkJPC9hcmctYXNzb2NpYXRpb24+CgkJCQkJCQkJCTwvdG9rZW4tc3JjLWF0dHI+CgkJCQkJCQkJPC9hcmctc3RyaW5nPgoJCQkJCQkJCTxhcmctc3RyaW5nIG5hbWU9IkNvbm5lY3RlZFN5c3RlbU5hbWUiPgoJCQkJCQkJCQk8dG9rZW4tZ2xvYmFsLXZhcmlhYmxlIG5hbWU9IkNvbm5lY3RlZFN5c3RlbU5hbWUiLz4KCQkJCQkJCQk8L2FyZy1zdHJpbmc+CgkJCQkJCQkJPGFyZy1zdHJpbmcgbmFtZT0idG8iPgoJCQkJCQkJCQk8dG9rZW4tc3JjLWF0dHIgbmFtZT0iSW50ZXJuZXQgRU1haWwgQWRkcmVzcyI+CgkJCQkJCQkJCQk8YXJnLWFzc29jaWF0aW9uPgoJCQkJCQkJCQkJCTx0b2tlbi14cGF0aCBleHByZXNzaW9uPSJzZWxmOjpzdGF0dXMvb3BlcmF0aW9uLWRhdGEvcGFzc3dvcmQtcHVibGlzaC1zdGF0dXMvYXNzb2NpYXRpb24iLz4KCQkJCQkJCQkJCTwvYXJnLWFzc29jaWF0aW9uPgoJCQkJCQkJCQk8L3Rva2VuLXNyYy1hdHRyPgoJCQkJCQkJCTwvYXJnLXN0cmluZz4KCQkJCQkJCQk8YXJnLXN0cmluZyBuYW1lPSJGYWlsdXJlUmVhc29uIj4KCQkJCQkJCQkJPHRva2VuLXRleHQvPgoJCQkJCQkJCQk8dG9rZW4teHBhdGggZXhwcmVzc2lvbj0ic2VsZjo6c3RhdHVzL2NoaWxkOjp0ZXh0KCkiLz4KCQkJCQkJCQk8L2FyZy1zdHJpbmc+CgkJCQkJCQk8L2RvLXNlbmQtZW1haWwtZnJvbS10ZW1wbGF0ZT4KCQkJCQkJPC9hY3Rpb25zPgoJCQkJCTwvcnVsZT4KCQkJCTwvcG9saWN5PgoJCQk8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0taW5zdGFsbGF0aW9uZGlyZWN0aXZlIj4KCQkJPGRzLXZhbHVlPlBEOTRiV3dnZG1WeWMybHZiajBpTVM0d0lpQmxibU52WkdsdVp6MGlWVlJHTFRnaVB6NDhhVzV6ZEdGc2JHRjBhVzl1TFdScGNtVmpkR2wyWlQ0S0NUeHdiR0ZqWlcxbGJuUWdiRzlqWVhScGIyNDlJbVJsWm1GMWJIUWlMejRLQ1R4a2N5MWhkSFJ5YVdKMWRHVnpMejRLQ1R4d2IyeHBZM2t0YkdsdWEyRm5aUzgrQ2p3dmFXNXpkR0ZzYkdGMGFXOXVMV1JwY21WamRHbDJaVDQ9PC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iaWRtLWRpcmVjdGl2ZWNoZWNrc3VtIj4KCQkJPGRzLXZhbHVlPjM3NTcxMzc0MDE8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0tcGFja2FnZWFzc29jZ3VpZCI+CgkJCTxkcy12YWx1ZT5NQkhBTTY2RV8yMDEwMDYyMzE3NTE0MDA3MTM8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0tcGFja2FnZWd1aWQiPgoJCQk8ZHMtdmFsdWU+WFRFRjFZTzNfMjAxMDA2MjMxNzMzNDEwMTYxPC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iaWRtLWNvbnRlbnRjaGVja3N1bSI+CgkJCTxkcy12YWx1ZT4xNTcyNDExOTcxPC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCTwvZHMtYXR0cmlidXRlcz4KPC9kcy1vYmplY3Q+</pkg-initial-state>
			<pkg-initial-state package-id="XTEF1YO3_201006231733410161" pkg-assoc-id="FVA6FG1H_201902191454010658" version="2.1.2.20190806140123">PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48ZHMtb2JqZWN0IGRzLW9iamVjdC1jbGFzcz0iRGlyWE1MLUdsb2JhbENvbmZpZ0RlZiIgZHMtb2JqZWN0LW5hbWU9Ik5PVkxQV0RTWU5DLUdDVnMiIG5hbWU9Ik5PVkxQV0RTWU5DLUdDVnMiPgoJPGRzLWF0dHJpYnV0ZXM+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9ImlkbS1pbnN0YWxsYXRpb25kaXJlY3RpdmUiPgoJCQk8ZHMtdmFsdWU+UEQ5NGJXd2dkbVZ5YzJsdmJqMGlNUzR3SWlCbGJtTnZaR2x1WnowaVZWUkdMVGdpUHo0OGFXNXpkR0ZzYkdGMGFXOXVMV1JwY21WamRHbDJaU0J0YjJSbFBTSmhiR3dpUGdvSlBIQnNZV05sYldWdWRDQnNiMk5oZEdsdmJqMGlaR1ZtWVhWc2RDSXZQZ29KUEdSekxXRjBkSEpwWW5WMFpYTXZQZ29KUEdOdmJtWnBaM1Z5WVhScGIyNHRkbUZzZFdWelBnb0pDVHhrWldacGJtbDBhVzl1Y3lCa2FYTndiR0Y1TFc1aGJXVTlJa052YlcxdmJpQlFZWE56ZDI5eVpDQlRaWFIwYVc1bmN5SStDZ2tKQ1R4a1pXWnBibWwwYVc5dUlHTnlhWFJwWTJGc0xXTm9ZVzVuWlQwaWRISjFaU0lnWkdsemNHeGhlUzF1WVcxbFBTSjRiR1pwWkNoT1QxWk1VRmRFVTFsT1F5NW5iRzlpWVd4amIyNW1hV2N1VGs5V1RGQlhSRk5aVGtOSFExWnpMbWRqZGk1a1pXWmhkV3gwVUdGemMzZHZjbVF1Wlc1aFlteGxLVk5sZENCa1pXWmhkV3gwSUhCaGMzTjNiM0prSUdsbUlHNXZkQ0JoZG1GcGJHRmliR1VpSUc1aGJXVTlJbVJsWm1GMWJIUlFZWE56ZDI5eVpDNWxibUZpYkdVaUlIUjVjR1U5SW1WdWRXMGlQZ29KQ1FrSlBHUmxjMk55YVhCMGFXOXVQbmhzWm1sa0tFNVBWa3hRVjBSVFdVNURMbWRzYjJKaGJHTnZibVpwWnk1T1QxWk1VRmRFVTFsT1EwZERWbk11WjJOMkxtUnpZM0l1WkdWbVlYVnNkRkJoYzNOM2IzSmtMbVZ1WVdKc1pTbFRaV3hsWTNRZ0oxbGxjeWNnZEc4Z2MyVjBJR0VnWkdWbVlYVnNkQ0J3WVhOemQyOXlaQ0JwWmlCd1lYTnpkMjl5WkNCbGJHVnRaVzUwSUdseklHNXZkQ0JoZG1GcGJHRmliR1VnYVc0Z2RYTmxjaUJoWkdRZ1pYWmxiblF1SUZSb2FYTWdaMk4ySUhCaGNtRnRaWFJsY2lCM2FXeHNJR052Ym5SeWIyd2dhRzkzSUNvdFkzQXRSR1ZtWVhWc2RGQmhjM04zYjNKa0lIQnZiR2xqZVNCbGVHVmpkWFJsY3k0OEwyUmxjMk55YVhCMGFXOXVQZ29KQ1FrSlBHVnVkVzB0WTJodmFXTmxJR1JwYzNCc1lYa3RibUZ0WlQwaWVHeG1hV1FvVGs5V1RGQlhSRk5aVGtNdVoyeHZZbUZzWTI5dVptbG5MazVQVmt4UVYwUlRXVTVEUjBOV2N5NW5ZM1l1WTJodmFXTmxMbVJsWm1GMWJIUlFZWE56ZDI5eVpDNWxibUZpYkdVdVdXVnpLVmxsY3lJK2VXVnpQQzlsYm5WdExXTm9iMmxqWlQ0S0NRa0pDVHhsYm5WdExXTm9iMmxqWlNCa2FYTndiR0Y1TFc1aGJXVTlJbmhzWm1sa0tFNVBWa3hRVjBSVFdVNURMbWRzYjJKaGJHTnZibVpwWnk1T1QxWk1VRmRFVTFsT1EwZERWbk11WjJOMkxtTm9iMmxqWlM1a1pXWmhkV3gwVUdGemMzZHZjbVF1Wlc1aFlteGxMazV2S1U1dklqNXViend2Wlc1MWJTMWphRzlwWTJVK0Nna0pDUWs4ZG1Gc2RXVStlV1Z6UEM5MllXeDFaVDRLQ1FrSlBDOWtaV1pwYm1sMGFXOXVQZ29KQ1R3dlpHVm1hVzVwZEdsdmJuTStDZ2s4TDJOdmJtWnBaM1Z5WVhScGIyNHRkbUZzZFdWelBnb0pQSEJ2YkdsamVTMXNhVzVyWVdkbFBnb0pDVHh3YjJ4cFkza3RjMlYwSUc1aGJXVTlJbWRqZGlJZ2IzSmtaWEk5SWxkbGFXZG9kQ0lnZG1Gc2RXVTlJalV3TUNJdlBnb0pQQzl3YjJ4cFkza3RiR2x1YTJGblpUNEtQQzlwYm5OMFlXeHNZWFJwYjI0dFpHbHlaV04wYVhabFBnPT08L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0tZGlyZWN0aXZlY2hlY2tzdW0iPgoJCQk8ZHMtdmFsdWU+Mzk2MzE2ODI0NjwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9ImlkbS1wYWNrYWdlYXNzb2NndWlkIj4KCQkJPGRzLXZhbHVlPkZWQTZGRzFIXzIwMTkwMjE5MTQ1NDAxMDY1ODwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9ImlkbS1wYWNrYWdlZ3VpZCI+CgkJCTxkcy12YWx1ZT5YVEVGMVlPM18yMDEwMDYyMzE3MzM0MTAxNjE8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0tY29udGVudGNoZWNrc3VtIj4KCQkJPGRzLXZhbHVlPjE0OTI3Njk5MjQ8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJPC9kcy1hdHRyaWJ1dGVzPgo8L2RzLW9iamVjdD4=</pkg-initial-state>
			<pkg-initial-state package-id="3V750MRQ_201504031637130312" pkg-assoc-id="9AOAGBIZ_201504031637130332" version="1.0.0.20171211151747">PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48ZHMtb2JqZWN0IGRzLW9iamVjdC1jbGFzcz0iRGlyWE1MLUdsb2JhbENvbmZpZ0RlZiIgZHMtb2JqZWN0LW5hbWU9Ik5FVFFSRVNUUFdELUdDViIgbmFtZT0iTkVUUVJFU1RQV0QtR0NWIj4KCTxkcy1hdHRyaWJ1dGVzPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0taW5zdGFsbGF0aW9uZGlyZWN0aXZlIj4KCQkJPGRzLXZhbHVlPlBEOTRiV3dnZG1WeWMybHZiajBpTVM0d0lpQmxibU52WkdsdVp6MGlWVlJHTFRnaVB6NDhhVzV6ZEdGc2JHRjBhVzl1TFdScGNtVmpkR2wyWlNCdGIyUmxQU0poYkd3aVBnb0pQSEJzWVdObGJXVnVkQ0JzYjJOaGRHbHZiajBpWkdWbVlYVnNkQ0l2UGdvSlBHUnpMV0YwZEhKcFluVjBaWE12UGdvSlBHTnZibVpwWjNWeVlYUnBiMjR0ZG1Gc2RXVnpQZ29KQ1R4a1pXWnBibWwwYVc5dWN5QmthWE53YkdGNUxXNWhiV1U5SWxCaGMzTjNiM0prSUZONWJtTm9jbTl1YVhwaGRHbHZiaUkrQ2drSkNUeGtaV1pwYm1sMGFXOXVJR1JwYzNCc1lYa3RibUZ0WlQwaWVHeG1hV1FvVGtWVVVWSkZVMVJRVjBRdVoyeHZZbUZzWTI5dVptbG5MazVGVkZGU1JWTlVVRmRFUjBOV0xtZGpkaTVsYm1GaWJHVXRjR0Z6YzNkdmNtUXRjM1ZpYzJOeWFXSmxLVUZ3Y0d4cFkyRjBhVzl1SUdGalkyVndkSE1nY0dGemMzZHZjbVJ6SUdaeWIyMGdTV1JsYm5ScGRIa2dUV0Z1WVdkbGNpSWdibUZ0WlQwaVpXNWhZbXhsTFhCaGMzTjNiM0prTFhOMVluTmpjbWxpWlNJZ2RIbHdaVDBpWW05dmJHVmhiaUkrQ2drSkNRazhaR1Z6WTNKcGNIUnBiMjQrZUd4bWFXUW9Ua1ZVVVZKRlUxUlFWMFF1WjJ4dlltRnNZMjl1Wm1sbkxrNUZWRkZTUlZOVVVGZEVSME5XTG1kamRpNWtjMk55TG1WdVlXSnNaUzF3WVhOemQyOXlaQzF6ZFdKelkzSnBZbVVwVTJWc1pXTjBJSGRvWlhSb1pYSWdkR2hsSUdGd2NHeHBZMkYwYVc5dUlHRmpZMlZ3ZEhNZ2NHRnpjM2R2Y21SeklHWnliMjBnU1dSbGJuUnBkSGtnVFdGdVlXZGxjaTRnVkhKMVpTQmhiR3h2ZDNNZ2NHRnpjM2R2Y21SeklIUnZJR1pzYjNjZ1puSnZiU0IwYUdVZ1NXUmxiblJwZEhrZ1RXRnVZV2RsY2lCa1lYUmhJSE4wYjNKbElIUnZJSFJvWlNCamIyNXVaV04wWldRZ2MzbHpkR1Z0TGp3dlpHVnpZM0pwY0hScGIyNCtDZ2tKQ1FrOGRtRnNkV1UrZEhKMVpUd3ZkbUZzZFdVK0Nna0pDVHd2WkdWbWFXNXBkR2x2Ymo0S0NRa0pQR1JsWm1sdWFYUnBiMjRnWkdsemNHeGhlUzF1WVcxbFBTSjRiR1pwWkNoT1JWUlJVa1ZUVkZCWFJDNW5iRzlpWVd4amIyNW1hV2N1VGtWVVVWSkZVMVJRVjBSSFExWXVaMk4yTG1WdVlXSnNaUzF3WVhOemQyOXlaQzF3ZFdKc2FYTm9LVWxrWlc1MGFYUjVJRTFoYm1GblpYSWdZV05qWlhCMGN5QndZWE56ZDI5eVpITWdabkp2YlNCaGNIQnNhV05oZEdsdmJpSWdibUZ0WlQwaVpXNWhZbXhsTFhCaGMzTjNiM0prTFhCMVlteHBjMmdpSUhSNWNHVTlJbUp2YjJ4bFlXNGlQZ29KQ1FrSlBHUmxjMk55YVhCMGFXOXVQbmhzWm1sa0tFNUZWRkZTUlZOVVVGZEVMbWRzYjJKaGJHTnZibVpwWnk1T1JWUlJVa1ZUVkZCWFJFZERWaTVuWTNZdVpITmpjaTVsYm1GaWJHVXRjR0Z6YzNkdmNtUXRjSFZpYkdsemFDbFRaV3hsWTNRZ2QyaGxkR2hsY2lCSlpHVnVkR2wwZVNCTllXNWhaMlZ5SUdGalkyVndkSE1nY0dGemMzZHZjbVJ6SUdaeWIyMGdkR2hsSUdGd2NHeHBZMkYwYVc5dUxpQlVjblZsSUdGc2JHOTNjeUJ3WVhOemQyOXlaSE1nZEc4Z1pteHZkeUJtY205dElIUm9aU0JqYjI1dVpXTjBaV1FnYzNsemRHVnRJSFJ2SUhSb1pTQkpaR1Z1ZEdsMGVTQk5ZVzVoWjJWeUlHUmhkR0VnYzNSdmNtVXVQQzlrWlhOamNtbHdkR2x2Ymo0S0NRa0pDVHgyWVd4MVpUNTBjblZsUEM5MllXeDFaVDRLQ1FrSlBDOWtaV1pwYm1sMGFXOXVQZ29KQ1FrOFpHVm1hVzVwZEdsdmJpQmthWE53YkdGNUxXNWhiV1U5SW5oc1ptbGtLRTVGVkZGU1JWTlVVRmRFTG1kc2IySmhiR052Ym1acFp5NU9SVlJSVWtWVFZGQlhSRWREVmk1blkzWXVjSFZpYkdsemFDMXdZWE56ZDI5eVpDMTBieTF1WkhNcFVIVmliR2x6YUNCd1lYTnpkMjl5WkhNZ2RHOGdUa1JUSUhCaGMzTjNiM0prSWlCdVlXMWxQU0p3ZFdKc2FYTm9MWEJoYzNOM2IzSmtMWFJ2TFc1a2N5SWdkSGx3WlQwaVltOXZiR1ZoYmlJK0Nna0pDUWs4WkdWelkzSnBjSFJwYjI0K2VHeG1hV1FvVGtWVVVWSkZVMVJRVjBRdVoyeHZZbUZzWTI5dVptbG5MazVGVkZGU1JWTlVVRmRFUjBOV0xtZGpkaTVrYzJOeUxuQjFZbXhwYzJndGNHRnpjM2R2Y21RdGRHOHRibVJ6S1ZWelpTQjBhR1VnY0dGemMzZHZjbVFnWm5KdmJTQjBhR1VnWTI5dWJtVmpkR1ZrSUhONWMzUmxiU0IwYnlCelpYUWdkR2hsSUc1dmJpMXlaWFpsY25OcFlteGxJRTVFVXlCd1lYTnpkMjl5WkNCcGJpQmxSR2x5WldOMGIzSjVMand2WkdWelkzSnBjSFJwYjI0K0Nna0pDUWs4ZG1Gc2RXVStkSEoxWlR3dmRtRnNkV1UrQ2drSkNUd3ZaR1ZtYVc1cGRHbHZiajRLQ1FrSlBHUmxabWx1YVhScGIyNGdaR2x6Y0d4aGVTMXVZVzFsUFNKNGJHWnBaQ2hPUlZSUlVrVlRWRkJYUkM1bmJHOWlZV3hqYjI1bWFXY3VUa1ZVVVZKRlUxUlFWMFJIUTFZdVoyTjJMbkIxWW14cGMyZ3RjR0Z6YzNkdmNtUXRkRzh0WkhBcFVIVmliR2x6YUNCd1lYTnpkMjl5WkhNZ2RHOGdSR2x6ZEhKcFluVjBhVzl1SUZCaGMzTjNiM0prSWlCdVlXMWxQU0p3ZFdKc2FYTm9MWEJoYzNOM2IzSmtMWFJ2TFdSd0lpQjBlWEJsUFNKaWIyOXNaV0Z1SWo0S0NRa0pDVHhrWlhOamNtbHdkR2x2Ymo1NGJHWnBaQ2hPUlZSUlVrVlRWRkJYUkM1bmJHOWlZV3hqYjI1bWFXY3VUa1ZVVVZKRlUxUlFWMFJIUTFZdVoyTjJMbVJ6WTNJdWNIVmliR2x6YUMxd1lYTnpkMjl5WkMxMGJ5MWtjQ2xUWld4bFkzUWdkMmhsYm5Sb1pYSWdkRzhnZFhObElIUm9aU0J3WVhOemQyOXlaQ0JtY205dElIUm9aU0JqYjI1dVpXTjBaV1FnYzNsemRHVnRJSFJ2SUhObGRDQjBhR1VnVGsxQlV5QkVhWE4wY21saWRYUnBiMjRnVUdGemMzZHZjbVFnZFhObFpDQm1iM0lnU1dSbGJuUnBkSGtnVFdGdVlXZGxjaUJ3WVhOemQyOXlaQ0J6ZVc1amFISnZibWw2WVhScGIyNHVQQzlrWlhOamNtbHdkR2x2Ymo0S0NRa0pDVHgyWVd4MVpUNTBjblZsUEM5MllXeDFaVDRLQ1FrSlBDOWtaV1pwYm1sMGFXOXVQZ29KQ1FrOFpHVm1hVzVwZEdsdmJpQmthWE53YkdGNUxXNWhiV1U5SW5oc1ptbGtLRTVGVkZGU1JWTlVVRmRFTG1kc2IySmhiR052Ym1acFp5NU9SVlJSVWtWVFZGQlhSRWREVmk1blkzWXVaVzVtYjNKalpTMXdZWE56ZDI5eVpDMXdiMnhwWTNrcFVtVnhkV2x5WlNCd1lYTnpkMjl5WkNCd2IyeHBZM2tnZG1Gc2FXUmhkR2x2YmlCaVpXWnZjbVVnY0hWaWJHbHphR2x1WnlCd1lYTnpkMjl5WkhNaUlHNWhiV1U5SW1WdVptOXlZMlV0Y0dGemMzZHZjbVF0Y0c5c2FXTjVJaUIwZVhCbFBTSmliMjlzWldGdUlqNEtDUWtKQ1R4a1pYTmpjbWx3ZEdsdmJqNTRiR1pwWkNoT1JWUlJVa1ZUVkZCWFJDNW5iRzlpWVd4amIyNW1hV2N1VGtWVVVWSkZVMVJRVjBSSFExWXVaMk4yTG1SelkzSXVaVzVtYjNKalpTMXdZWE56ZDI5eVpDMXdiMnhwWTNrcFZISjFaU0JoY0hCc2FXVnpJSFJvWlNCT1RVRlRJSEJoYzNOM2IzSmtJSEJ2YkdsamFXVnpJR1IxY21sdVp5QndZWE56ZDI5eVpDQnZjR1Z5WVhScGIyNXpJRzl1SUhSb1pTQlFkV0pzYVhOb1pYSWdZMmhoYm01bGJDNGdWR2hsSUhCaGMzTjNiM0prSUdseklHNXZkQ0IzY21sMGRHVnVJSFJ2SUhSb1pTQmtZWFJoSUhOMGIzSmxJR2xtSUdsMElHUnZaWE1nYm05MElHTnZiWEJzZVM0Z1JtRnNjMlVnWkc5bGN5QnViM1FnWVhCd2JIa2dkR2hsSUU1TlFWTWdjR0Z6YzNkdmNtUWdjRzlzYVdOcFpYTWdaSFZ5YVc1bklIQmhjM04zYjNKa0lHOXdaWEpoZEdsdmJuTWdiMjRnZEdobElGQjFZbXhwYzJobGNpQmphR0Z1Ym1Wc0xqd3ZaR1Z6WTNKcGNIUnBiMjQrQ2drSkNRazhkbUZzZFdVK2RISjFaVHd2ZG1Gc2RXVStDZ2tKQ1R3dlpHVm1hVzVwZEdsdmJqNEtDUWtKUEdSbFptbHVhWFJwYjI0Z1pHbHpjR3hoZVMxdVlXMWxQU0o0YkdacFpDaE9SVlJSVWtWVFZGQlhSQzVuYkc5aVlXeGpiMjVtYVdjdVRrVlVVVkpGVTFSUVYwUkhRMVl1WjJOMkxuSmxjMlYwTFdWNGRHVnlibUZzTFhCaGMzTjNiM0prTFc5dUxXWmhhV3gxY21VcFVtVnpaWFFnZFhObGNpZHpJR1Y0ZEdWeWJtRnNJSE41YzNSbGJTQndZWE56ZDI5eVpDQjBieUIwYUdVZ1NXUmxiblJwZEhrZ1RXRnVZV2RsY2lCd1lYTnpkMjl5WkNCdmJpQm1ZV2xzZFhKbElpQnVZVzFsUFNKeVpYTmxkQzFsZUhSbGNtNWhiQzF3WVhOemQyOXlaQzF2YmkxbVlXbHNkWEpsSWlCMGVYQmxQU0ppYjI5c1pXRnVJajRLQ1FrSkNUeGtaWE5qY21sd2RHbHZiajU0YkdacFpDaE9SVlJSVWtWVFZGQlhSQzVuYkc5aVlXeGpiMjVtYVdjdVRrVlVVVkpGVTFSUVYwUkhRMVl1WjJOMkxtUnpZM0l1Y21WelpYUXRaWGgwWlhKdVlXd3RjR0Z6YzNkdmNtUXRiMjR0Wm1GcGJIVnlaU2xVY25WbElHRjBkR1Z0Y0hSeklIUnZJSEpsYzJWMElIUm9aU0J3WVhOemQyOXlaQ0JwYmlCMGFHVWdZMjl1Ym1WamRHVmtJSE41YzNSbGJTQmllU0IxYzJsdVp5QjBhR1VnUkdsemRISnBZblYwYVc5dUlGQmhjM04zYjNKa0lHWnliMjBnZEdobElFbGtaVzUwYVhSNUlGWmhkV3gwSUhkb1pXNGdZU0J3ZFdKc2FYTm9JRVJwYzNSeWFXSjFkR2x2YmlCUVlYTnpkMjl5WkNCbVlXbHNkWEpsSUc5alkzVnljeTQ4TDJSbGMyTnlhWEIwYVc5dVBnb0pDUWtKUEhaaGJIVmxQblJ5ZFdVOEwzWmhiSFZsUGdvSkNRazhMMlJsWm1sdWFYUnBiMjQrQ2drSkNUeGtaV1pwYm1sMGFXOXVJR1JwYzNCc1lYa3RibUZ0WlQwaWVHeG1hV1FvVGtWVVVWSkZVMVJRVjBRdVoyeHZZbUZzWTI5dVptbG5MazVGVkZGU1JWTlVVRmRFUjBOV0xtZGpkaTV1YjNScFpua3RkWE5sY2kxdmJpMXdZWE56ZDI5eVpDMWthWE4wTFdaaGFXeDFjbVVwVG05MGFXWjVJSFJvWlNCMWMyVnlJRzltSUhCaGMzTjNiM0prSUhONWJtTm9jbTl1YVhwaGRHbHZiaUJtWVdsc2RYSmxJSFpwWVNCbExXMWhhV3dpSUc1aGJXVTlJbTV2ZEdsbWVTMTFjMlZ5TFc5dUxYQmhjM04zYjNKa0xXUnBjM1F0Wm1GcGJIVnlaU0lnZEhsd1pUMGlZbTl2YkdWaGJpSStDZ2tKQ1FrOFpHVnpZM0pwY0hScGIyNHZQZ29KQ1FrSlBIWmhiSFZsUG5SeWRXVThMM1poYkhWbFBnb0pDUWs4TDJSbFptbHVhWFJwYjI0K0Nna0pQQzlrWldacGJtbDBhVzl1Y3o0S0NUd3ZZMjl1Wm1sbmRYSmhkR2x2YmkxMllXeDFaWE0rQ2drOGNHOXNhV041TFd4cGJtdGhaMlUrQ2drSlBIQnZiR2xqZVMxelpYUWdibUZ0WlQwaVoyTjJJaUJ2Y21SbGNqMGlkMlZwWjJoMElpQjJZV3gxWlQwaU1UUXdJaTgrQ2drOEwzQnZiR2xqZVMxc2FXNXJZV2RsUGdvOEwybHVjM1JoYkd4aGRHbHZiaTFrYVhKbFkzUnBkbVUrPC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iaWRtLWRpcmVjdGl2ZWNoZWNrc3VtIj4KCQkJPGRzLXZhbHVlPjIyMzg0ODIyOTQ8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0tcGFja2FnZWFzc29jZ3VpZCI+CgkJCTxkcy12YWx1ZT45QU9BR0JJWl8yMDE1MDQwMzE2MzcxMzAzMzI8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0tcGFja2FnZWd1aWQiPgoJCQk8ZHMtdmFsdWU+M1Y3NTBNUlFfMjAxNTA0MDMxNjM3MTMwMzEyPC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iaWRtLWNvbnRlbnRjaGVja3N1bSI+CgkJCTxkcy12YWx1ZT4zNDk2ODI2MTY8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJPC9kcy1hdHRyaWJ1dGVzPgo8L2RzLW9iamVjdD4=</pkg-initial-state>
		</pkg-initial-states>
	</attributes>
	<children>
		<publisher name="Publisher">
			<attributes/>
			<children>
				<rule checksum="2091278712" name="NETQRESTDCFG-pub-ctp-ModifytoRename" package-id="DQ3ZPHXF_201505121302320165" pkg-assoc-id="I53KDN51_201505121304050419">
					<policy>
						<rule>
							<description>Convert modify to rename</description>
							<conditions>
								<and>
									<if-operation op="equal">modify</if-operation>
									<if-op-attr name="CN" op="changing"/>
								</and>
							</conditions>
							<actions>
								<do-append-xml-element expression=".." name="rename"/>
								<do-append-xml-element expression="../rename[last()]" name="association"/>
								<do-append-xml-text expression="../rename[last()]/association">
									<arg-string>
										<token-association/>
									</arg-string>
								</do-append-xml-text>
								<do-set-xml-attr expression="../rename[last()]" name="event-id">
									<arg-string>
										<token-xpath expression="$current-op/@event-id"/>
									</arg-string>
								</do-set-xml-attr>
								<do-set-xml-attr expression="../rename[last()]" name="src-dn">
									<arg-string>
										<token-xpath expression="$current-op/@src-dn"/>
									</arg-string>
								</do-set-xml-attr>
								<do-append-xml-element expression="../rename[last()]" name="new-name"/>
								<do-append-xml-text expression="../rename[last()]/new-name">
									<arg-string>
										<token-xpath expression="$current-op/modify-attr[@attr-name='CN']/add-value/value/text()"/>
									</arg-string>
								</do-append-xml-text>
								<do-strip-op-attr name="CN"/>
							</actions>
						</rule>
					</policy>
				</rule>
				<rule checksum="3168005419" name="NETQRESTDCFG-pub-pp" package-id="DQ3ZPHXF_201505121302320165" pkg-assoc-id="H7WTLCEF_201505121304050581">
					<policy>
						<rule>
							<description>User Placement Policy</description>
							<conditions>
								<or>
									<if-class-name op="equal">User</if-class-name>
								</or>
							</conditions>
							<actions>
								<do-set-local-variable name="dn">
									<arg-string>
										<token-global-variable name="idv.dit.data.users"/>
										<token-text>\</token-text>
										<token-attr name="CN"/>
									</arg-string>
								</do-set-local-variable>
							</actions>
						</rule>
						<rule>
							<description>Group Placement Policy</description>
							<conditions>
								<and>
									<if-class-name mode="nocase" op="equal">Group</if-class-name>
								</and>
							</conditions>
							<actions>
								<do-set-local-variable name="dn" scope="policy">
									<arg-string>
										<token-global-variable name="idv.dit.data.groups"/>
										<token-text>\</token-text>
										<token-attr name="CN"/>
									</arg-string>
								</do-set-local-variable>
							</actions>
						</rule>
						<rule>
							<description>Set Destination DN</description>
							<conditions>
								<and/>
							</conditions>
							<actions>
								<do-set-op-dest-dn>
									<arg-dn>
										<token-local-variable name="dn"/>
									</arg-dn>
								</do-set-op-dest-dn>
							</actions>
						</rule>
					</policy>
				</rule>
				<rule checksum="2922201566" name="NETQRESTDCFG-pub-mp" package-id="DQ3ZPHXF_201505121302320165" pkg-assoc-id="RKSNLX6P_201505121315370584">
					<policy>
						<rule>
							<description>User match on CN</description>
							<conditions>
								<and>
									<if-class-name mode="nocase" op="equal">User</if-class-name>
								</and>
							</conditions>
							<actions>
								<do-find-matching-object scope="subtree">
									<arg-dn>
										<token-global-variable name="idv.dit.data.users"/>
									</arg-dn>
									<arg-match-attr name="CN"/>
								</do-find-matching-object>
							</actions>
						</rule>
						<rule>
							<description>Group match on CN</description>
							<conditions>
								<and>
									<if-class-name mode="nocase" op="equal">Group</if-class-name>
								</and>
							</conditions>
							<actions>
								<do-find-matching-object scope="subtree">
									<arg-dn>
										<token-global-variable name="idv.dit.data.groups"/>
									</arg-dn>
									<arg-match-attr name="CN"/>
								</do-find-matching-object>
							</actions>
						</rule>
					</policy>
				</rule>
				<rule checksum="1605400340" name="NETQRESTDCFG-pub-cp" package-id="DQ3ZPHXF_201505121302320165" pkg-assoc-id="MUXK9PEA_201507011237170385">
					<policy>
						<rule>
							<description>Required attributes for User creation</description>
							<comment xml:space="preserve">The policy lists basic set of mandatory attributes required for user creation in Identity vault. Unavailabiliy of these attibutes will result in operation getting vetoed.
</comment>
							<conditions>
								<and>
									<if-class-name mode="nocase" op="equal">User</if-class-name>
								</and>
							</conditions>
							<actions>
								<do-veto-if-op-attr-not-available name="CN"/>
								<do-veto-if-op-attr-not-available name="Surname"/>
							</actions>
						</rule>
					</policy>
				</rule>
				<rule checksum="3566212025" name="NETQRESTJSON-itp-JSONtoXDS" package-id="CP32RFWU_201505121250070695" pkg-assoc-id="FIN3S6PU_201505212016350356">
					<policy xmlns:es="http://www.novell.com/nxsl/ecmascript" xmlns:rs="http://www.novell.com/nxsl/java/com.novell.nds.dirxml.driver.rest.common.JSONConverter">
						<rule>
							<description>Translate JSON to XDS</description>
							<conditions>
								<and>
									<if-class-name op="available"/>
									<if-class-name mode="nocase" op="not-equal">DirXML-Driver</if-class-name>
								</and>
								<and>
									<if-operation mode="regex" op="equal">status</if-operation>
									<if-xpath disabled="true" op="not-true">$current-op/driver-operation-data [@class-name="DirXML-Driver"]</if-xpath>
								</and>
							</conditions>
							<actions>
								<do-if>
									<arg-conditions>
										<or>
											<if-operation mode="regex" op="equal">status</if-operation>
										</or>
									</arg-conditions>
									<arg-actions>
										<do-if>
											<arg-conditions>
												<and>
													<if-xpath op="true">string-length(./driver-operation-data/response/value/text())>0</if-xpath>
													<if-xpath op="true">./driver-operation-data[@command="query"]</if-xpath>
												</and>
											</arg-conditions>
											<arg-actions>
												<do-set-local-variable name="xmlInput" notrace="true" scope="policy">
													<arg-string>
														<token-base64-encode charset="UTF-8">
															<token-replace-all regex="&amp;lt;" replace-with="&lt;">
																<token-xml-serialize>
																	<token-xpath expression="."/>
																</token-xml-serialize>
															</token-replace-all>
														</token-base64-encode>
													</arg-string>
												</do-set-local-variable>
												<do-set-local-variable name="applicationContent" notrace="true" scope="policy">
													<arg-string>
														<token-xpath expression="rs:jsonToXDS($xmlInput)"/>
													</arg-string>
												</do-set-local-variable>
												<do-if notrace="true">
													<arg-conditions>
														<and>
															<if-local-variable mode="nocase" name="applicationContent" op="not-equal"/>
														</and>
													</arg-conditions>
													<arg-actions>
														<do-set-local-variable name="xdscontent" scope="policy">
															<arg-node-set>
																<token-xml-parse>
																	<token-local-variable name="applicationContent"/>
																</token-xml-parse>
															</arg-node-set>
														</do-set-local-variable>
														<do-clone-xpath dest-expression=".." src-expression="$xdscontent/status/instance"/>
													</arg-actions>
													<arg-actions/>
												</do-if>
												<do-strip-xpath expression="./driver-operation-data"/>
											</arg-actions>
											<arg-actions/>
										</do-if>
									</arg-actions>
									<arg-actions>
										<do-if>
											<arg-conditions>
												<and>
													<if-xml-attr name="command" op="available"/>
												</and>
											</arg-conditions>
											<arg-actions>
												<do-if>
													<arg-conditions>
														<and>
															<if-xml-attr mode="nocase" name="command" op="equal">poll</if-xml-attr>
														</and>
													</arg-conditions>
													<arg-actions>
														<do-if>
															<arg-conditions>
																<and>
																	<if-xpath op="true">string-length(./response/value/text())>0</if-xpath>
																</and>
															</arg-conditions>
															<arg-actions>
																<do-set-local-variable name="xmlInput" notrace="true" scope="policy">
																	<arg-string>
																		<token-base64-encode charset="UTF-8">
																			<token-replace-all regex="&amp;lt;" replace-with="&lt;">
																				<token-xml-serialize>
																					<token-xpath expression="."/>
																				</token-xml-serialize>
																			</token-replace-all>
																		</token-base64-encode>
																	</arg-string>
																</do-set-local-variable>
																<do-set-local-variable name="applicationContent" notrace="true" scope="policy">
																	<arg-string>
																		<token-xpath expression="rs:jsonToXDS($xmlInput)"/>
																	</arg-string>
																</do-set-local-variable>
																<do-if notrace="true">
																	<arg-conditions>
																		<and>
																			<if-local-variable mode="nocase" name="applicationContent" op="not-equal"/>
																		</and>
																	</arg-conditions>
																	<arg-actions>
																		<do-set-local-variable name="xdscontent" scope="policy">
																			<arg-node-set>
																				<token-xml-parse>
																					<token-local-variable name="applicationContent"/>
																				</token-xml-parse>
																			</arg-node-set>
																		</do-set-local-variable>
																		<do-clone-xpath dest-expression=".." src-expression="$xdscontent/input/modify"/>
																	</arg-actions>
																	<arg-actions/>
																</do-if>
																<do-strip-xpath expression="."/>
															</arg-actions>
															<arg-actions/>
														</do-if>
													</arg-actions>
													<arg-actions>
														<do-set-local-variable name="operations" scope="policy">
															<arg-node-set>
																<token-xpath expression="."/>
															</arg-node-set>
														</do-set-local-variable>
														<do-for-each>
															<arg-node-set>
																<token-local-variable name="operations"/>
															</arg-node-set>
															<arg-actions>
																<do-set-local-variable name="command" scope="policy">
																	<arg-string>
																		<token-xpath expression="@command"/>
																	</arg-string>
																</do-set-local-variable>
																<do-if>
																	<arg-conditions>
																		<and>
																			<if-local-variable mode="regex" name="command" op="equal">query|delete</if-local-variable>
																		</and>
																	</arg-conditions>
																	<arg-actions>
																		<do-if>
																			<arg-conditions>
																				<and>
																					<if-local-variable mode="nocase" name="command" op="equal">query</if-local-variable>
																				</and>
																			</arg-conditions>
																			<arg-actions>
																				<do-append-xml-element expression="//nds/input" name="query"/>
																				<do-set-xml-attr expression="//nds/input/query[last()]" name="class-name">
																					<arg-string>
																						<token-xpath expression="@class-name"/>
																					</arg-string>
																				</do-set-xml-attr>
																				<do-append-xml-element expression="//nds/input/query[last()]" name="search-class"/>
																				<do-set-xml-attr expression="//nds/input/query[last()]/search-class[last()]" name="class-name">
																					<arg-string>
																						<token-xpath expression="@class-name"/>
																					</arg-string>
																				</do-set-xml-attr>
																				<do-if>
																					<arg-conditions>
																						<and>
																							<if-xpath op="true">@association</if-xpath>
																						</and>
																					</arg-conditions>
																					<arg-actions>
																						<do-append-xml-element expression="//nds/input/query[last()]" name="association"/>
																						<do-append-xml-text expression="//nds/input/query[last()]/association">
																							<arg-string>
																								<token-xpath expression="@association"/>
																							</arg-string>
																						</do-append-xml-text>
																						<do-set-local-variable name="filterText" scope="policy">
																							<arg-string>
																								<token-xpath expression="@filter"/>
																							</arg-string>
																						</do-set-local-variable>
																						<do-set-local-variable name="filterTextSplit" scope="policy">
																							<arg-node-set>
																								<token-split delimiter="&amp;">
																									<token-local-variable name="filterText"/>
																								</token-split>
																							</arg-node-set>
																						</do-set-local-variable>
																						<do-set-local-variable name="readAttrText" scope="policy">
																							<arg-string>
																								<token-substring start="10">
																									<token-xpath expression="rs:urlDecode($filterTextSplit[2])"/>
																								</token-substring>
																							</arg-string>
																						</do-set-local-variable>
																						<do-if>
																							<arg-conditions>
																								<and>
																									<if-local-variable mode="case" name="readAttrText" op="not-equal"/>
																								</and>
																							</arg-conditions>
																							<arg-actions>
																								<do-if>
																									<arg-conditions>
																										<and>
																											<if-local-variable mode="case" name="readAttrText" op="not-equal">*</if-local-variable>
																										</and>
																									</arg-conditions>
																									<arg-actions>
																										<do-set-local-variable name="readAttrs" scope="policy">
																											<arg-node-set>
																												<token-split delimiter="and">
																													<token-local-variable name="readAttrText"/>
																												</token-split>
																											</arg-node-set>
																										</do-set-local-variable>
																										<do-for-each>
																											<arg-node-set>
																												<token-local-variable name="readAttrs"/>
																											</arg-node-set>
																											<arg-actions>
																												<do-append-xml-element expression="//nds/input/query[last()]" name="read-attr"/>
																												<do-set-xml-attr expression="//nds/input/query[last()]/read-attr[last()]" name="attr-name">
																													<arg-string>
																														<token-replace-all regex="'" replace-with="">
																															<token-local-variable name="current-node"/>
																														</token-replace-all>
																													</arg-string>
																												</do-set-xml-attr>
																											</arg-actions>
																										</do-for-each>
																									</arg-actions>
																									<arg-actions/>
																								</do-if>
																							</arg-actions>
																							<arg-actions>
																								<do-append-xml-element expression="//nds/input/query[last()]" name="read-attr"/>
																							</arg-actions>
																						</do-if>
																					</arg-actions>
																					<arg-actions>
																						<!-- do-set-xml-attr expression="//nds/input/query[last()]" name="dest-dn">
																		<arg-string>
																			<token-global-variable name="idv.dit.data.users"/>
																		</arg-string>
																	</do-set-xml-attr-->
																						<do-set-local-variable name="filterText" scope="policy">
																							<arg-string>
																								<token-xpath expression="@filter"/>
																							</arg-string>
																						</do-set-local-variable>
																						<do-set-local-variable name="filterTextSplit" scope="policy">
																							<arg-node-set>
																								<token-split delimiter="&amp;">
																									<token-local-variable name="filterText"/>
																								</token-split>
																							</arg-node-set>
																						</do-set-local-variable>
																						<do-set-local-variable name="filterTextNode" scope="policy">
																							<arg-node-set>
																								<token-split delimiter="and">
																									<token-substring start="12">
																										<token-xpath expression="rs:urlDecode($filterTextSplit[1])"/>
																									</token-substring>
																								</token-split>
																							</arg-node-set>
																						</do-set-local-variable>
																						<do-for-each>
																							<arg-node-set>
																								<token-local-variable name="filterTextNode"/>
																							</arg-node-set>
																							<arg-actions>
																								<do-set-local-variable name="search-attr" scope="policy">
																									<arg-node-set>
																										<token-split delimiter="eq">
																											<token-local-variable name="current-node"/>
																										</token-split>
																									</arg-node-set>
																								</do-set-local-variable>
																								<do-append-xml-element expression="//nds/input/query[last()]" name="search-attr"/>
																								<do-set-xml-attr expression="//nds/input/query[last()]/search-attr[last()]" name="attr-name">
																									<arg-string>
																										<token-xpath expression="$search-attr[1]"/>
																									</arg-string>
																								</do-set-xml-attr>
																								<do-append-xml-element expression="//nds/input/query[last()]/search-attr[last()]" name="value"/>
																								<do-append-xml-text expression="//nds/input/query[last()]/search-attr[last()]/value">
																									<arg-string>
																										<token-replace-all regex="'" replace-with="">
																											<token-xpath expression="$search-attr[2]"/>
																										</token-replace-all>
																									</arg-string>
																								</do-append-xml-text>
																							</arg-actions>
																						</do-for-each>
																						<do-set-local-variable name="readAttrText" scope="policy">
																							<arg-string>
																								<token-substring start="10">
																									<token-xpath expression="rs:urlDecode($filterTextSplit[2])"/>
																								</token-substring>
																							</arg-string>
																						</do-set-local-variable>
																						<do-if>
																							<arg-conditions>
																								<and>
																									<if-local-variable mode="case" name="readAttrText" op="not-equal"/>
																								</and>
																							</arg-conditions>
																							<arg-actions>
																								<do-if>
																									<arg-conditions>
																										<and>
																											<if-local-variable mode="case" name="readAttrText" op="not-equal">*</if-local-variable>
																										</and>
																									</arg-conditions>
																									<arg-actions>
																										<do-set-local-variable name="readAttrs" scope="policy">
																											<arg-node-set>
																												<token-split delimiter="and">
																													<token-local-variable name="readAttrText"/>
																												</token-split>
																											</arg-node-set>
																										</do-set-local-variable>
																										<do-for-each>
																											<arg-node-set>
																												<token-local-variable name="readAttrs"/>
																											</arg-node-set>
																											<arg-actions>
																												<do-append-xml-element expression="//nds/input/query[last()]" name="read-attr"/>
																												<do-set-xml-attr expression="//nds/input/query[last()]/read-attr[last()]" name="attr-name">
																													<arg-string>
																														<token-replace-all regex="'" replace-with="">
																															<token-local-variable name="current-node"/>
																														</token-replace-all>
																													</arg-string>
																												</do-set-xml-attr>
																											</arg-actions>
																										</do-for-each>
																									</arg-actions>
																									<arg-actions/>
																								</do-if>
																							</arg-actions>
																							<arg-actions>
																								<do-append-xml-element expression="//nds/input/query[last()]" name="read-attr"/>
																							</arg-actions>
																						</do-if>
																					</arg-actions>
																				</do-if>
																			</arg-actions>
																			<arg-actions>
																				<do-append-xml-element expression="//nds/input" name="delete"/>
																				<do-set-xml-attr expression="//nds/input/delete[last()]" name="class-name">
																					<arg-string>
																						<token-xpath expression="@class-name"/>
																					</arg-string>
																				</do-set-xml-attr>
																				<do-if>
																					<arg-conditions>
																						<and>
																							<if-xpath op="true">@association</if-xpath>
																						</and>
																					</arg-conditions>
																					<arg-actions>
																						<do-append-xml-element expression="//nds/input/delete[last()]" name="association"/>
																						<do-append-xml-text expression="//nds/input/delete[last()]/association">
																							<arg-string>
																								<token-xpath expression="@association"/>
																							</arg-string>
																						</do-append-xml-text>
																					</arg-actions>
																					<arg-actions/>
																				</do-if>
																			</arg-actions>
																		</do-if>
																	</arg-actions>
																	<arg-actions>
																		<do-set-local-variable name="xmlInput" notrace="true" scope="policy">
																			<arg-string>
																				<token-base64-encode charset="UTF-8">
																					<token-replace-all regex="&amp;lt;" replace-with="&lt;">
																						<token-xml-serialize>
																							<token-xpath expression="."/>
																						</token-xml-serialize>
																					</token-replace-all>
																				</token-base64-encode>
																			</arg-string>
																		</do-set-local-variable>
																		<do-set-local-variable name="applicationContent" notrace="true" scope="policy">
																			<arg-string>
																				<token-xpath expression="rs:jsonToXDS($xmlInput)"/>
																			</arg-string>
																		</do-set-local-variable>
																		<do-if notrace="true">
																			<arg-conditions>
																				<and>
																					<if-local-variable mode="nocase" name="applicationContent" op="not-equal"/>
																				</and>
																			</arg-conditions>
																			<arg-actions>
																				<do-set-local-variable name="xdscontent" scope="policy">
																					<arg-node-set>
																						<token-xml-parse>
																							<token-local-variable name="applicationContent"/>
																						</token-xml-parse>
																					</arg-node-set>
																				</do-set-local-variable>
																				<do-clone-xpath dest-expression="/nds/input" src-expression="$xdscontent"/>
																			</arg-actions>
																			<arg-actions/>
																		</do-if>
																	</arg-actions>
																</do-if>
																<do-strip-xpath expression="."/>
															</arg-actions>
														</do-for-each>
													</arg-actions>
												</do-if>
											</arg-actions>
											<arg-actions/>
										</do-if>
									</arg-actions>
								</do-if>
							</actions>
						</rule>
					</policy>
				</rule>
				<rule checksum="3061773090" name="NOVLPWDSYNC-pub-ctp-AddPwdPayload" package-id="XTEF1YO3_201006231733410161" pkg-assoc-id="2BRCGU9C_201006231753280863">
					<policy>
						<description>Publish password payloads</description>
						<rule>
							<description>Add operation-data element to password operations</description>
							<conditions>
								<and>
									<if-operation op="equal">add</if-operation>
									<if-password op="available"/>
									<if-xpath op="not-true">operation-data</if-xpath>
								</and>
								<and>
									<if-operation op="equal">add</if-operation>
									<if-xpath op="true">add-attr[@attr-name='nspmDistributionPassword']</if-xpath>
									<if-xpath op="not-true">operation-data</if-xpath>
								</and>
								<and>
									<if-operation op="equal">modify-password</if-operation>
									<if-xpath op="not-true">operation-data</if-xpath>
								</and>
								<and>
									<if-operation op="equal">modify</if-operation>
									<if-xpath op="true">modify-attr[@attr-name='nspmDistributionPassword']</if-xpath>
									<if-xpath op="not-true">operation-data</if-xpath>
								</and>
							</conditions>
							<actions>
								<!-- Add a operation data payload element to pick up result of a password operation -->
								<do-append-xml-element expression="." name="operation-data"/>
							</actions>
						</rule>
						<rule>
							<description>Add payload data to password operations</description>
							<conditions>
								<and>
									<if-operation op="equal">add</if-operation>
									<if-password op="available"/>
								</and>
								<and>
									<if-operation op="equal">add</if-operation>
									<if-xpath op="true">add-attr[@attr-name='nspmDistributionPassword']</if-xpath>
								</and>
								<and>
									<if-operation op="equal">modify-password</if-operation>
								</and>
								<and>
									<if-operation op="equal">modify</if-operation>
									<if-xpath op="true">modify-attr[@attr-name='nspmDistributionPassword']</if-xpath>
								</and>
							</conditions>
							<actions>
								<!-- Add a operation data payload element to pick up result of a password operation -->
								<do-append-xml-element expression="operation-data" name="password-publish-status"/>
								<do-append-xml-element expression="operation-data/password-publish-status" name="association"/>
								<do-append-xml-text expression="operation-data/password-publish-status/association">
									<arg-string>
										<token-association/>
									</arg-string>
								</do-append-xml-text>
							</actions>
						</rule>
					</policy>
				</rule>
				<rule checksum="2018212417" name="NOVLPWDSYNC-pub-ctp-CheckPwdGCV" package-id="XTEF1YO3_201006231733410161" pkg-assoc-id="K51N08RF_201006231754340016">
					<policy>
						<description>Publish Passwords</description>
						<rule>
							<description>Block publishing passwords to the Identity Vault when adding an object</description>
							<conditions>
								<and>
									<if-global-variable mode="nocase" name="enable-password-publish" op="equal">false</if-global-variable>
									<if-operation op="equal">add</if-operation>
								</and>
							</conditions>
							<actions>
								<!-- Remove all password elements from add -->
								<do-strip-xpath expression="password"/>
							</actions>
						</rule>
						<rule>
							<description>Block sending modify-password changes to the Identity Vault</description>
							<conditions>
								<and>
									<if-global-variable mode="nocase" name="enable-password-publish" op="equal">false</if-global-variable>
									<if-operation op="equal">modify-password</if-operation>
								</and>
							</conditions>
							<actions>
								<!-- Block all modify-passwords -->
								<do-veto/>
							</actions>
						</rule>
					</policy>
				</rule>
				<rule checksum="711100711" name="NOVLPWDSYNC-pub-cp-DefaultPwd" package-id="XTEF1YO3_201006231733410161" pkg-assoc-id="0J0H3EFI_201006231755560188">
					<policy>
						<rule>
							<description>On User add, provide the default password if no password exists</description>
							<conditions>
								<and>
									<if-operation op="equal">add</if-operation>
									<if-class-name op="equal">User</if-class-name>
									<if-password op="not-available"/>
									<if-op-attr name="nspmDistributionPassword" op="not-available"/>
								</and>
							</conditions>
							<actions>
								<do-if>
									<arg-conditions>
										<and>
											<if-global-variable mode="nocase" name="defaultPassword.enable" op="equal">yes</if-global-variable>
										</and>
									</arg-conditions>
									<arg-actions>
										<do-set-dest-password>
											<arg-string>
												<token-text xml:space="preserve">@DirXml1</token-text>
											</arg-string>
										</do-set-dest-password>
									</arg-actions>
									<arg-actions>
										<do-veto/>
									</arg-actions>
								</do-if>
							</actions>
						</rule>
					</policy>
				</rule>
				<rule checksum="800972629" name="NOVLPWDSYNC-pub-ctp-PublishDistPwd" package-id="XTEF1YO3_201006231733410161" pkg-assoc-id="WQU9K1S0_201006231757350198">
					<policy>
						<description>Publish passwords to NMAS distribution password</description>
						<rule>
							<description>Add nspmDistributionAttribute attribute to add operation</description>
							<conditions>
								<and>
									<if-global-variable mode="nocase" name="publish-password-to-dp" op="equal">true</if-global-variable>
									<if-operation op="equal">add</if-operation>
									<if-password op="available"/>
									<if-password mode="regex" op="equal">.+</if-password>
								</and>
							</conditions>
							<actions>
								<!-- Add add-attr element for nspmDistributionPassword attribute -->
								<do-add-dest-attr-value name="nspmDistributionPassword">
									<arg-value>
										<token-password/>
									</arg-value>
								</do-add-dest-attr-value>
								<!-- Add a validate-password attribute to previous add-attr element -->
								<do-set-xml-attr expression="add-attr[@attr-name = 'nspmDistributionPassword'][last()]" name="enforce-password-policy">
									<arg-string>
										<token-global-variable name="enforce-password-policy"/>
									</arg-string>
								</do-set-xml-attr>
							</actions>
						</rule>
						<rule>
							<description>Change modify-password operations to a modify</description>
							<conditions>
								<and>
									<if-global-variable mode="nocase" name="publish-password-to-dp" op="equal">true</if-global-variable>
									<if-operation op="equal">modify-password</if-operation>
									<if-password op="available"/>
									<if-password mode="regex" op="equal">.+</if-password>
								</and>
							</conditions>
							<actions>
								<!-- Add modify-attr element for nspmDistributionPassword attribute -->
								<do-add-dest-attr-value name="nspmDistributionPassword">
									<arg-value>
										<token-password/>
									</arg-value>
								</do-add-dest-attr-value>
								<!-- Add a event-id attribute to previous modify element -->
								<do-set-xml-attr expression="../modify" name="event-id">
									<arg-string>
										<token-text>pwd-publish</token-text>
									</arg-string>
								</do-set-xml-attr>
								<!-- Add a validate-password attribute to previous add-attr element -->
								<do-set-xml-attr expression="../modify/modify-attr[@attr-name='nspmDistributionPassword']" name="enforce-password-policy">
									<arg-string>
										<token-global-variable name="enforce-password-policy"/>
									</arg-string>
								</do-set-xml-attr>
							</actions>
						</rule>
					</policy>
				</rule>
				<rule checksum="2652784874" name="NOVLPWDSYNC-pub-ctp-PublishNDSPwd" package-id="XTEF1YO3_201006231733410161" pkg-assoc-id="84V5V29N_201006231759000291">
					<policy>
						<description>Publish passwords to eDirectory password.</description>
						<rule>
							<description>Block publishing passwords to eDirectory password</description>
							<conditions>
								<and>
									<if-operation op="equal">add</if-operation>
								</and>
							</conditions>
							<actions>
								<!-- Remove all password elements from add -->
								<do-if>
									<arg-conditions>
										<or>
											<if-global-variable mode="nocase" name="publish-password-to-nds" op="equal">false</if-global-variable>
											<if-password op="not-available"/>
											<if-password mode="regex" op="not-equal">.+</if-password>
										</or>
									</arg-conditions>
									<arg-actions>
										<do-strip-xpath expression="password"/>
									</arg-actions>
								</do-if>
							</actions>
						</rule>
						<rule>
							<description>Block sending modify-password changes to the eDirectory password</description>
							<conditions>
								<and>
									<if-operation op="equal">modify-password</if-operation>
								</and>
							</conditions>
							<actions>
								<!-- Block all modify-passwords -->
								<do-if>
									<arg-conditions>
										<or>
											<if-global-variable mode="nocase" name="publish-password-to-nds" op="equal">false</if-global-variable>
											<if-password op="not-available"/>
											<if-password mode="regex" op="not-equal">.+</if-password>
										</or>
									</arg-conditions>
									<arg-actions>
										<do-veto/>
									</arg-actions>
								</do-if>
							</actions>
						</rule>
					</policy>
				</rule>
				<rule checksum="2538148234" name="NETQPWDSYNC-itp-TransformPassword" package-id="3V750MRQ_201504031637130312" pkg-assoc-id="AC644FBS_201504082045320904">
					<policy>
						<rule>
							<description>Create Modify Password</description>
							<conditions>
								<and>
									<if-class-name mode="nocase" op="equal">User</if-class-name>
									<if-operation mode="nocase" op="equal">modify</if-operation>
									<if-op-attr name="password" op="available"/>
								</and>
							</conditions>
							<actions>
								<do-set-dest-password class-name="User">
									<arg-string>
										<token-op-attr name="password"/>
									</arg-string>
								</do-set-dest-password>
								<do-strip-xpath expression="."/>
							</actions>
						</rule>
					</policy>
				</rule>
			</children>
		</publisher>
		<subscriber name="Subscriber">
			<attributes/>
			<children>
				<rule checksum="831956920" name="NETQRESTDCFG-sub-ctp-Associate" package-id="DQ3ZPHXF_201505121302320165" pkg-assoc-id="92DOXP4M_201505121304050581">
					<policy>
						<rule>
							<description>Associate on ADD</description>
							<conditions>
								<and>
									<if-operation mode="regex" op="equal">add</if-operation>
								</and>
							</conditions>
							<actions>
								<do-set-op-property name="association">
									<arg-string>
										<token-attr name="$drv.association$"/>
									</arg-string>
								</do-set-op-property>
								<do-set-op-property name="src-dn">
									<arg-string>
										<token-src-dn/>
									</arg-string>
								</do-set-op-property>
								<do-set-op-association>
									<arg-association>
										<token-op-property name="association"/>
									</arg-association>
								</do-set-op-association>
							</actions>
						</rule>
					</policy>
				</rule>
				<rule checksum="1517605313" name="NETQRESTDCFG-sub-ctp-RenameToModify" package-id="DQ3ZPHXF_201505121302320165" pkg-assoc-id="DSMC0QX4_201505121304050581">
					<policy>
						<rule>
							<description>Transform rename event to modify</description>
							<conditions>
								<and>
									<if-operation op="equal">rename</if-operation>
								</and>
							</conditions>
							<actions>
								<do-set-dest-attr-value name="CN" when="after">
									<arg-value type="string">
										<token-xpath expression="new-name/text()"/>
									</arg-value>
								</do-set-dest-attr-value>
								<do-veto/>
							</actions>
						</rule>
					</policy>
				</rule>
				<rule checksum="1738626977" name="NETQRESTDCFG-sub-mp" package-id="DQ3ZPHXF_201505121302320165" pkg-assoc-id="YZ5E0IK0_201505121315030061">
					<policy>
						<description>Query Display Name</description>
						<rule>
							<description>Match Users</description>
							<conditions>
								<and>
									<if-class-name mode="nocase" op="equal">User</if-class-name>
								</and>
							</conditions>
							<actions>
								<do-find-matching-object scope="subtree">
									<arg-match-attr name="CN">
										<arg-value type="string">
											<token-src-attr name="CN"/>
										</arg-value>
									</arg-match-attr>
								</do-find-matching-object>
								<do-find-matching-object scope="subtree">
									<arg-match-attr name="DisplayName">
										<arg-value type="string">
											<token-src-attr name="Full Name"/>
										</arg-value>
									</arg-match-attr>
								</do-find-matching-object>
							</actions>
						</rule>
						<rule>
							<description>Match group</description>
							<conditions>
								<and>
									<if-class-name mode="nocase" op="equal">Group</if-class-name>
								</and>
							</conditions>
							<actions>
								<do-find-matching-object scope="subtree">
									<arg-match-attr name="DisplayName">
										<arg-value type="string">
											<token-src-attr name="CN"/>
										</arg-value>
									</arg-match-attr>
								</do-find-matching-object>
							</actions>
						</rule>
					</policy>
				</rule>
				<rule checksum="323617129" name="NETQRESTJSON-otp-XDStoJSON" package-id="CP32RFWU_201505121250070695" pkg-assoc-id="4CBT7U00_201505121250070695">
					<policy xmlns:es="http://www.novell.com/nxsl/ecmascript" xmlns:rs="http://www.novell.com/nxsl/java/com.novell.nds.dirxml.driver.rest.common.JSONConverter">
						<rule>
							<description>Translate XDS to JSON</description>
							<conditions>
								<and>
									<if-operation mode="regex" op="not-equal">instance</if-operation>
									<if-operation mode="nocase" op="not-equal">driver-operation-data</if-operation>
								</and>
							</conditions>
							<actions>
								<do-if>
									<arg-conditions>
										<and>
											<if-operation mode="regex" op="equal">status</if-operation>
											<if-xpath op="true">count(//nds//instance)>0</if-xpath>
											<if-xpath op="not-true">//instance[@class-name="DirXML-Driver"]</if-xpath>
										</and>
									</arg-conditions>
									<arg-actions>
										<do-set-local-variable name="status" scope="policy">
											<arg-node-set>
												<token-xml-parse>
													<token-text xml:space="preserve">&lt;status>&lt;/status></token-text>
												</token-xml-parse>
											</arg-node-set>
										</do-set-local-variable>
										<do-clone-xpath dest-expression="$status/status" src-expression="/nds/*/instance"/>
										<do-set-local-variable name="xmlInput" scope="policy">
											<arg-string>
												<token-base64-encode charset="UTF-8">
													<token-replace-all regex="&amp;lt;" replace-with="&lt;">
														<token-xml-serialize>
															<token-xpath expression="$status"/>
														</token-xml-serialize>
													</token-replace-all>
												</token-base64-encode>
											</arg-string>
										</do-set-local-variable>
										<do-set-local-variable name="applicationContent" notrace="true" scope="policy">
											<arg-string>
												<token-xpath expression="rs:xdsToJSON($xmlInput)"/>
											</arg-string>
										</do-set-local-variable>
										<do-append-xml-element expression="$current-op" name="driver-operation-data"/>
										<do-append-xml-element expression="$current-op/driver-operation-data[last()]" name="header"/>
										<do-set-xml-attr expression="$current-op/driver-operation-data[last()]/header" name="Accept">
											<arg-string>
												<token-text xml:space="preserve">application/json</token-text>
											</arg-string>
										</do-set-xml-attr>
										<do-append-xml-element expression="$current-op/driver-operation-data[last()]" name="response"/>
										<do-append-xml-element expression="$current-op/driver-operation-data[last()]/response" name="value"/>
										<do-append-xml-text expression="$current-op/driver-operation-data[last()]/response/value" notrace="true">
											<arg-string>
												<token-local-variable name="applicationContent"/>
											</arg-string>
										</do-append-xml-text>
										<do-strip-xpath expression="/nds/*/instance"/>
									</arg-actions>
									<arg-actions>
										<do-if>
											<arg-conditions>
												<and>
													<if-class-name op="available"/>
													<if-class-name mode="nocase" op="not-equal">DirXML-Driver</if-class-name>
												</and>
											</arg-conditions>
											<arg-actions>
												<do-set-local-variable name="operations" scope="policy">
													<arg-node-set>
														<token-xpath expression="."/>
													</arg-node-set>
												</do-set-local-variable>
												<do-for-each>
													<arg-node-set>
														<token-local-variable name="operations"/>
													</arg-node-set>
													<arg-actions>
														<do-set-local-variable name="xmlInput" notrace="true" scope="policy">
															<arg-string>
																<token-base64-encode charset="UTF-8">
																	<token-replace-all regex="&amp;lt;" replace-with="&lt;">
																		<token-xml-serialize>
																			<token-xpath expression="$current-op"/>
																		</token-xml-serialize>
																	</token-replace-all>
																</token-base64-encode>
															</arg-string>
														</do-set-local-variable>
														<do-set-local-variable name="applicationContent" notrace="true" scope="policy">
															<arg-string>
																<token-xpath expression="rs:xdsToJSON($xmlInput)"/>
															</arg-string>
														</do-set-local-variable>
														<do-if notrace="true">
															<arg-conditions>
																<and>
																	<if-local-variable mode="nocase" name="applicationContent" op="not-equal"/>
																</and>
															</arg-conditions>
															<arg-actions>
																<do-if>
																	<arg-conditions>
																		<and>
																			<if-operation mode="regex" op="not-equal">query</if-operation>
																		</and>
																	</arg-conditions>
																	<arg-actions>
																		<do-append-xml-element expression=".." name="driver-operation-data"/>
																		<do-set-xml-attr expression="../driver-operation-data" name="src-dn">
																			<arg-string>
																				<token-src-dn/>
																			</arg-string>
																		</do-set-xml-attr>
																		<do-set-xml-attr expression="../driver-operation-data[last()]" name="is-sensitive">
																			<arg-string>
																				<token-text xml:space="preserve">true</token-text>
																			</arg-string>
																		</do-set-xml-attr>
																		<!--  <do-if>
														<arg-conditions>
															<and>
																<if-password op="available"/>
															</and>
														</arg-conditions>
														<arg-actions>
															<do-set-xml-attr expression="../driver-operation-data[last()]" name="is-sensitive">
																<arg-string>
																	<token-text xml:space="preserve">true</token-text>
																</arg-string>
															</do-set-xml-attr>
														</arg-actions>
														<arg-actions/>
													</do-if>-->
																		<do-set-xml-attr expression="../driver-operation-data[last()]" name="class-name">
																			<arg-string>
																				<token-class-name/>
																			</arg-string>
																		</do-set-xml-attr>
																		<do-set-xml-attr expression="../driver-operation-data[last()]" name="event-id">
																			<arg-string>
																				<token-xpath expression="$current-op/@event-id"/>
																			</arg-string>
																		</do-set-xml-attr>
																		<do-if>
																			<arg-conditions>
																				<and>
																					<if-operation mode="nocase" op="equal">modify-password</if-operation>
																				</and>
																			</arg-conditions>
																			<arg-actions>
																				<do-set-xml-attr expression="../driver-operation-data[last()]" name="command">
																					<arg-string>
																						<token-text xml:space="preserve">modify</token-text>
																					</arg-string>
																				</do-set-xml-attr>
																			</arg-actions>
																			<arg-actions>
																				<do-set-xml-attr expression="../driver-operation-data[last()]" name="command">
																					<arg-string>
																						<token-operation/>
																					</arg-string>
																				</do-set-xml-attr>
																			</arg-actions>
																		</do-if>
																		<do-append-xml-element expression="../driver-operation-data[last()]" name="request"/>
																		<do-append-xml-element expression="../driver-operation-data[last()]/request[last()]" name="url-token"/>
																		<do-if>
																			<arg-conditions>
																				<and>
																					<if-association op="available"/>
																				</and>
																			</arg-conditions>
																			<arg-actions>
																				<do-set-xml-attr expression="../driver-operation-data[last()]/request[last()]/url-token" name="association">
																					<arg-string>
																						<token-association/>
																					</arg-string>
																				</do-set-xml-attr>
																			</arg-actions>
																			<arg-actions/>
																		</do-if>
																		<do-append-xml-element expression="../driver-operation-data[last()]/request[last()]" name="header"/>
																		<do-set-xml-attr expression="../driver-operation-data[last()]/request[last()]/header" name="content-type">
																			<arg-string>
																				<token-text xml:space="preserve">application/json</token-text>
																			</arg-string>
																		</do-set-xml-attr>
																		<do-append-xml-element expression="../driver-operation-data[last()]/request[last()]" name="value"/>
																		<do-append-xml-text expression="../driver-operation-data[last()]/request[last()]/value">
																			<arg-string>
																				<token-local-variable name="applicationContent"/>
																			</arg-string>
																		</do-append-xml-text>
																	</arg-actions>
																	<arg-actions>
																		<do-if>
																			<arg-conditions>
																				<and>
																					<if-xpath op="true">$current-op/@scope="entry"</if-xpath>
																				</and>
																			</arg-conditions>
																			<arg-actions>
																				<do-append-xml-element expression=".." name="driver-operation-data"/>
																				<do-if disabled="true">
																					<arg-conditions>
																						<and>
																							<if-global-variable mode="case" name="drv.allowtracing" op="equal">false</if-global-variable>
																						</and>
																					</arg-conditions>
																					<arg-actions>
																						<do-set-xml-attr expression="../driver-operation-data[last()]" name="is-sensitive">
																							<arg-string>
																								<token-text xml:space="preserve">false</token-text>
																							</arg-string>
																						</do-set-xml-attr>
																					</arg-actions>
																					<arg-actions>
																						<do-set-xml-attr expression="../driver-operation-data[last()]" name="is-sensitive">
																							<arg-string>
																								<token-text xml:space="preserve">true</token-text>
																							</arg-string>
																						</do-set-xml-attr>
																					</arg-actions>
																				</do-if>
																				<do-set-xml-attr expression="../driver-operation-data[last()]" name="class-name">
																					<arg-string>
																						<token-class-name/>
																					</arg-string>
																				</do-set-xml-attr>
																				<do-set-xml-attr expression="../driver-operation-data[last()]" name="command">
																					<arg-string>
																						<token-operation/>
																					</arg-string>
																				</do-set-xml-attr>
																				<do-set-xml-attr expression="../driver-operation-data[last()]" name="event-id">
																					<arg-string>
																						<token-xpath expression="$current-op/@event-id"/>
																					</arg-string>
																				</do-set-xml-attr>
																				<do-append-xml-element expression="../driver-operation-data[last()]" name="request"/>
																				<do-if>
																					<arg-conditions>
																						<and>
																							<if-association op="available"/>
																						</and>
																					</arg-conditions>
																					<arg-actions>
																						<do-set-local-variable name="associationHolder" scope="policy">
																							<arg-string>
																								<token-association/>
																							</arg-string>
																						</do-set-local-variable>
																					</arg-actions>
																					<arg-actions>
																						<do-set-local-variable name="associationHolder" scope="policy">
																							<arg-string>
																								<token-text xml:space="preserve">/</token-text>
																								<token-dest-dn/>
																							</arg-string>
																						</do-set-local-variable>
																					</arg-actions>
																				</do-if>
																				<do-append-xml-element expression="../driver-operation-data[last()]/request[last()]" name="url-token"/>
																				<do-set-xml-attr expression="../driver-operation-data[last()]/request[last()]/url-token" name="association">
																					<arg-string>
																						<token-local-variable name="associationHolder"/>
																					</arg-string>
																				</do-set-xml-attr>
																				<do-append-xml-element expression="../driver-operation-data[last()]/request[last()]" name="header"/>
																				<do-set-xml-attr expression="../driver-operation-data[last()]/request[last()]/header" name="content-type">
																					<arg-string>
																						<token-text xml:space="preserve">application/json</token-text>
																					</arg-string>
																				</do-set-xml-attr>
																				<do-append-xml-element expression="../driver-operation-data[last()]/request[last()]" name="value"/>
																				<do-append-xml-text expression="../driver-operation-data[last()]/request[last()]/value">
																					<arg-string>
																						<token-local-variable name="applicationContent"/>
																					</arg-string>
																				</do-append-xml-text>
																			</arg-actions>
																			<arg-actions>
																				<do-set-local-variable name="searchClasses" scope="policy">
																					<arg-node-set>
																						<token-xpath expression="$current-op/search-class"/>
																					</arg-node-set>
																				</do-set-local-variable>
																				<do-for-each>
																					<arg-node-set>
																						<token-local-variable name="searchClasses"/>
																					</arg-node-set>
																					<arg-actions>
																						<do-append-xml-element expression=".." name="driver-operation-data"/>
																						<do-set-xml-attr expression="../driver-operation-data[last()]" name="class-name">
																							<arg-string>
																								<token-class-name/>
																							</arg-string>
																						</do-set-xml-attr>
																						<do-set-xml-attr expression="../driver-operation-data[last()]" name="command">
																							<arg-string>
																								<token-operation/>
																							</arg-string>
																						</do-set-xml-attr>
																						<do-set-xml-attr expression="../driver-operation-data[last()]" name="event-id">
																							<arg-string>
																								<token-xpath expression="$current-op/@event-id"/>
																							</arg-string>
																						</do-set-xml-attr>
																						<do-append-xml-element expression="../driver-operation-data[last()]" name="request"/>
																						<do-append-xml-element expression="../driver-operation-data[last()]/request[last()]" name="url-token"/>
																						<do-append-xml-element expression="../driver-operation-data[last()]/request[last()]" name="header"/>
																						<do-set-xml-attr expression="../driver-operation-data[last()]/request[last()]/header" name="content-type">
																							<arg-string>
																								<token-text xml:space="preserve">application/json</token-text>
																							</arg-string>
																						</do-set-xml-attr>
																						<do-append-xml-element expression="../driver-operation-data[last()]/request[last()]" name="value"/>
																						<do-append-xml-text expression="../driver-operation-data[last()]/request[last()]/value">
																							<arg-string>
																								<token-local-variable name="applicationContent"/>
																							</arg-string>
																						</do-append-xml-text>
																						<do-set-local-variable name="searchAttrs" scope="policy">
																							<arg-node-set>
																								<token-xpath expression="$current-op/search-attr"/>
																							</arg-node-set>
																						</do-set-local-variable>
																						<do-for-each>
																							<arg-node-set>
																								<token-local-variable name="searchAttrs"/>
																							</arg-node-set>
																							<arg-actions>
																								<do-if>
																									<arg-conditions>
																										<and>
																											<if-local-variable name="filterText" op="available"/>
																										</and>
																									</arg-conditions>
																									<arg-actions>
																										<do-set-local-variable name="filterText" scope="policy">
																											<arg-string>
																												<token-xpath expression="$current-node/@attr-name"/>
																												<token-text xml:space="preserve"> eq '</token-text>
																												<token-xpath expression="$current-node/value/text()"/>
																												<token-text xml:space="preserve">'</token-text>
																												<token-text xml:space="preserve"> and </token-text>
																												<token-local-variable name="filterText"/>
																											</arg-string>
																										</do-set-local-variable>
																									</arg-actions>
																									<arg-actions>
																										<do-set-local-variable name="filterText" scope="policy">
																											<arg-string>
																												<token-xpath expression="$current-node/@attr-name"/>
																												<token-text xml:space="preserve"> eq '</token-text>
																												<token-xpath expression="$current-node/value/text()"/>
																												<token-text xml:space="preserve">'</token-text>
																											</arg-string>
																										</do-set-local-variable>
																									</arg-actions>
																								</do-if>
																							</arg-actions>
																						</do-for-each>
																						<do-set-local-variable name="filterText" scope="policy">
																							<arg-string>
																								<token-xpath expression='rs:urlEncode($filterText,"UTF-8")'/>
																							</arg-string>
																						</do-set-local-variable>
																					</arg-actions>
																				</do-for-each>
																			</arg-actions>
																		</do-if>
																		<do-set-local-variable name="readAttrs" scope="policy">
																			<arg-node-set>
																				<token-xpath expression="$current-op/read-attr"/>
																			</arg-node-set>
																		</do-set-local-variable>
																		<do-if>
																			<arg-conditions>
																				<and>
																					<if-xpath op="true">count($readAttrs)>0</if-xpath>
																				</and>
																			</arg-conditions>
																			<arg-actions>
																				<do-for-each>
																					<arg-node-set>
																						<token-local-variable name="readAttrs"/>
																					</arg-node-set>
																					<arg-actions>
																						<do-if>
																							<arg-conditions>
																								<and>
																									<if-local-variable name="readAttrText" op="not-available"/>
																								</and>
																							</arg-conditions>
																							<arg-actions>
																								<do-set-local-variable name="readAttrText" scope="policy">
																									<arg-string>
																										<token-text xml:space="preserve">'</token-text>
																										<token-xpath expression="$current-node/@attr-name"/>
																										<token-text xml:space="preserve">'</token-text>
																									</arg-string>
																								</do-set-local-variable>
																							</arg-actions>
																							<arg-actions>
																								<do-set-local-variable name="readAttrText" scope="policy">
																									<arg-string>
																										<token-text xml:space="preserve">'</token-text>
																										<token-xpath expression="$current-node/@attr-name"/>
																										<token-text xml:space="preserve">'</token-text>
																										<token-text xml:space="preserve">and</token-text>
																										<token-local-variable name="readAttrText"/>
																									</arg-string>
																								</do-set-local-variable>
																							</arg-actions>
																						</do-if>
																					</arg-actions>
																				</do-for-each>
																				<do-if>
																					<arg-conditions>
																						<and>
																							<if-local-variable mode="case" name="readAttrText" op="not-equal">''</if-local-variable>
																						</and>
																					</arg-conditions>
																					<arg-actions>
																						<do-set-local-variable name="readAttrText" scope="policy">
																							<arg-string>
																								<token-xpath expression='rs:urlEncode($readAttrText,"UTF-8")'/>
																							</arg-string>
																						</do-set-local-variable>
																						<do-if>
																							<arg-conditions>
																								<and>
																									<if-xpath op="true">$current-op/@scope="entry"</if-xpath>
																								</and>
																							</arg-conditions>
																							<arg-actions>
																								<do-set-xml-attr expression="../driver-operation-data[last()]/request[last()]/url-token" name="filter">
																									<arg-string>
																										<token-text xml:space="preserve">?read-attr=</token-text>
																										<token-local-variable name="readAttrText"/>
																									</arg-string>
																								</do-set-xml-attr>
																							</arg-actions>
																							<arg-actions>
																								<do-set-xml-attr expression="../driver-operation-data[last()]/request[last()]/url-token" name="filter">
																									<arg-string>
																										<token-text xml:space="preserve">?search-attr=</token-text>
																										<token-local-variable name="filterText"/>
																										<token-text xml:space="preserve">&amp;read-attr=</token-text>
																										<token-local-variable name="readAttrText"/>
																									</arg-string>
																								</do-set-xml-attr>
																							</arg-actions>
																						</do-if>
																					</arg-actions>
																					<arg-actions>
																						<do-set-local-variable name="readAttrText" scope="policy">
																							<arg-string>
																								<token-xpath expression='rs:urlEncode("","UTF-8")'/>
																							</arg-string>
																						</do-set-local-variable>
																						<do-if>
																							<arg-conditions>
																								<and>
																									<if-xpath op="true">$current-op/@scope="entry"</if-xpath>
																								</and>
																							</arg-conditions>
																							<arg-actions>
																								<do-set-xml-attr expression="../driver-operation-data[last()]/request[last()]/url-token" name="filter">
																									<arg-string>
																										<token-text xml:space="preserve">?read-attr=</token-text>
																										<token-local-variable name="readAttrText"/>
																									</arg-string>
																								</do-set-xml-attr>
																							</arg-actions>
																							<arg-actions>
																								<do-set-xml-attr expression="../driver-operation-data[last()]/request[last()]/url-token" name="filter">
																									<arg-string>
																										<token-text xml:space="preserve">?search-attr=</token-text>
																										<token-local-variable name="filterText"/>
																										<token-text xml:space="preserve">&amp;read-attr=</token-text>
																										<token-local-variable name="readAttrText"/>
																									</arg-string>
																								</do-set-xml-attr>
																							</arg-actions>
																						</do-if>
																					</arg-actions>
																				</do-if>
																			</arg-actions>
																			<arg-actions>
																				<do-set-local-variable name="readAttrText" scope="policy">
																					<arg-string>
																						<token-xpath expression='rs:urlEncode("*","UTF-8")'/>
																					</arg-string>
																				</do-set-local-variable>
																				<do-set-xml-attr expression="../driver-operation-data[last()]/request[last()]/url-token" name="filter">
																					<arg-string>
																						<token-text xml:space="preserve">?search-attr=</token-text>
																						<token-local-variable name="filterText"/>
																						<token-text xml:space="preserve">&amp;read-attr=</token-text>
																						<token-local-variable name="readAttrText"/>
																					</arg-string>
																				</do-set-xml-attr>
																			</arg-actions>
																		</do-if>
																	</arg-actions>
																</do-if>
															</arg-actions>
															<arg-actions>
																<do-if>
																	<arg-conditions>
																		<and>
																			<if-operation mode="regex" op="equal">delete|modify-password</if-operation>
																		</and>
																	</arg-conditions>
																	<arg-actions>
																		<do-append-xml-element expression=".." name="driver-operation-data"/>
																		<do-if>
																			<arg-conditions>
																				<and>
																					<if-password op="available"/>
																				</and>
																			</arg-conditions>
																			<arg-actions>
																				<do-set-xml-attr expression="../driver-operation-data[last()]" name="is-sensitive">
																					<arg-string>
																						<token-text xml:space="preserve">true</token-text>
																					</arg-string>
																				</do-set-xml-attr>
																			</arg-actions>
																			<arg-actions/>
																		</do-if>
																		<do-set-xml-attr expression="../driver-operation-data[last()]" name="class-name">
																			<arg-string>
																				<token-class-name/>
																			</arg-string>
																		</do-set-xml-attr>
																		<do-if>
																			<arg-conditions>
																				<and>
																					<if-operation mode="nocase" op="equal">modify-password</if-operation>
																				</and>
																			</arg-conditions>
																			<arg-actions>
																				<do-set-xml-attr expression="../driver-operation-data[last()]" name="command">
																					<arg-string>
																						<token-text xml:space="preserve">modify</token-text>
																					</arg-string>
																				</do-set-xml-attr>
																			</arg-actions>
																			<arg-actions>
																				<do-set-xml-attr expression="../driver-operation-data[last()]" name="command">
																					<arg-string>
																						<token-operation/>
																					</arg-string>
																				</do-set-xml-attr>
																			</arg-actions>
																		</do-if>
																		<do-append-xml-element expression="../driver-operation-data[last()]" name="request"/>
																		<do-append-xml-element expression="../driver-operation-data[last()]/request[last()]" name="url-token"/>
																		<do-if>
																			<arg-conditions>
																				<and>
																					<if-association op="available"/>
																				</and>
																			</arg-conditions>
																			<arg-actions>
																				<do-set-xml-attr expression="../driver-operation-data[last()]/request[last()]/url-token" name="association">
																					<arg-string>
																						<token-association/>
																					</arg-string>
																				</do-set-xml-attr>
																			</arg-actions>
																			<arg-actions/>
																		</do-if>
																		<do-append-xml-element expression="../driver-operation-data[last()]/request[last()]" name="header"/>
																		<do-set-xml-attr expression="../driver-operation-data[last()]/request[last()]/header" name="content-type">
																			<arg-string>
																				<token-text xml:space="preserve">application/json</token-text>
																			</arg-string>
																		</do-set-xml-attr>
																		<do-append-xml-element expression="../driver-operation-data[last()]/request[last()]" name="value"/>
																		<do-append-xml-text expression="../driver-operation-data[last()]/request[last()]/value">
																			<arg-string>
																				<token-local-variable name="applicationContent"/>
																			</arg-string>
																		</do-append-xml-text>
																	</arg-actions>
																	<arg-actions/>
																</do-if>
															</arg-actions>
														</do-if>
														<do-clone-xpath dest-expression="../driver-operation-data[last()]" notrace="true" src-expression="$current-op/operation-data"/>
														<do-strip-xpath expression="$current-op" notrace="true"/>
													</arg-actions>
												</do-for-each>
											</arg-actions>
											<arg-actions/>
										</do-if>
									</arg-actions>
								</do-if>
							</actions>
						</rule>
					</policy>
				</rule>
				<rule checksum="1402096025" name="NOVLPWDSYNC-sub-ctp-AddPwdPayload" package-id="XTEF1YO3_201006231733410161" pkg-assoc-id="FN6AXELS_201006231801080931">
					<policy>
						<description>Payloads for subscribe to password changes</description>
						<rule>
							<description>Add operation-data element to password subscribe operations</description>
							<conditions>
								<and>
									<if-operation op="equal">add</if-operation>
									<if-password op="available"/>
									<if-xpath op="not-true">operation-data</if-xpath>
								</and>
								<and>
									<if-operation op="equal">modify-password</if-operation>
									<if-xpath op="not-true">operation-data</if-xpath>
								</and>
							</conditions>
							<actions>
								<!-- Add a operation data payload element to pick up result of a password operation -->
								<do-append-xml-element expression="." name="operation-data"/>
							</actions>
						</rule>
						<rule>
							<description>Add payload data to a reset password from a failed password publish operation</description>
							<conditions>
								<and>
									<if-operation op="equal">modify-password</if-operation>
									<if-xpath op="true">self::modify-password[@event-id = 'pwd-publish-failed']</if-xpath>
								</and>
							</conditions>
							<actions>
								<!-- Add a operation data payload element to pick up result of a password operation -->
								<do-append-xml-element expression="operation-data" name="password-reset-status"/>
								<do-append-xml-element expression="operation-data/password-reset-status" name="association"/>
								<do-append-xml-text expression="operation-data/password-reset-status/association">
									<arg-string>
										<token-association/>
									</arg-string>
								</do-append-xml-text>
							</actions>
						</rule>
						<rule>
							<description>Add payload data to password subscribe operations</description>
							<conditions>
								<and>
									<if-operation op="equal">add</if-operation>
									<if-password op="available"/>
								</and>
								<and>
									<if-operation op="equal">modify-password</if-operation>
									<if-xpath op="true">self::modify-password[@event-id != 'pwd-publish-failed']</if-xpath>
								</and>
							</conditions>
							<actions>
								<!-- Add a operation data payload element to pick up result of a password operation -->
								<do-append-xml-element expression="operation-data" name="password-subscribe-status"/>
								<do-append-xml-element expression="operation-data/password-subscribe-status" name="association"/>
								<do-append-xml-text expression="operation-data/password-subscribe-status/association">
									<arg-string>
										<token-association/>
									</arg-string>
								</do-append-xml-text>
							</actions>
						</rule>
					</policy>
				</rule>
				<rule checksum="1235099749" name="NOVLPWDSYNC-sub-ctp-CheckPwdGCV" package-id="XTEF1YO3_201006231733410161" pkg-assoc-id="YX3KVQAI_201006231802110178">
					<policy>
						<description>Subscribe to password changes</description>
						<rule>
							<description>Block subscribing to passwords when objects are added</description>
							<conditions>
								<and>
									<if-global-variable mode="nocase" name="enable-password-subscribe" op="equal">false</if-global-variable>
									<if-operation op="equal">add</if-operation>
								</and>
							</conditions>
							<actions>
								<!-- Remove all password elements from add -->
								<do-strip-xpath expression="password"/>
							</actions>
						</rule>
						<rule>
							<description>Block subscribing to password modifications</description>
							<conditions>
								<and>
									<if-global-variable mode="nocase" name="enable-password-subscribe" op="equal">false</if-global-variable>
									<if-operation op="equal">modify-password</if-operation>
								</and>
							</conditions>
							<actions>
								<!-- Block all modify-passwords -->
								<do-veto/>
							</actions>
						</rule>
					</policy>
				</rule>
				<rule checksum="230375116" name="NOVLPWDSYNC-sub-cp-DefaultPwd" package-id="XTEF1YO3_201006231733410161" pkg-assoc-id="CXO45XW7_201006231803270112">
					<policy>
						<rule>
							<description>On User add, provide default password if no password exists</description>
							<conditions>
								<and>
									<if-operation op="equal">add</if-operation>
									<if-class-name op="equal">User</if-class-name>
									<if-password op="not-available"/>
									<if-op-attr name="nspmDistributionPassword" op="not-available"/>
								</and>
							</conditions>
							<actions>
								<do-if>
									<arg-conditions>
										<and>
											<if-global-variable mode="nocase" name="defaultPassword.enable" op="equal">yes</if-global-variable>
										</and>
									</arg-conditions>
									<arg-actions>
										<do-set-dest-password>
											<arg-string>
												<token-text xml:space="preserve">@DirXml1</token-text>
											</arg-string>
										</do-set-dest-password>
									</arg-actions>
									<arg-actions>
										<do-veto/>
									</arg-actions>
								</do-if>
							</actions>
						</rule>
					</policy>
				</rule>
				<rule checksum="3415738490" name="NOVLPWDSYNC-sub-ctp-TransformDistPwd" package-id="XTEF1YO3_201006231733410161" pkg-assoc-id="8CK6CZJW_201006231804290701">
					<policy>
						<description>Transform NMAS attribute to password elements</description>
						<rule>
							<description>Convert adds of the nspmDistributionPassword attribute to password elements</description>
							<conditions>
								<and>
									<if-operation op="equal">add</if-operation>
									<if-op-attr name="nspmDistributionPassword" op="available"/>
								</and>
							</conditions>
							<actions>
								<!-- Change all add-attr elements for the nspmDistributionPassword attribute to password elements-->
								<do-set-dest-password>
									<arg-string>
										<token-xpath expression="add-attr[@attr-name='nspmDistributionPassword']//value"/>
									</arg-string>
								</do-set-dest-password>
								<!-- Remove all add-attr elements for the nspmDistributionPassword attribute -->
								<do-strip-op-attr name="nspmDistributionPassword"/>
							</actions>
						</rule>
						<rule>
							<description>Block modifies for failed password publish operations if reset password is false</description>
							<conditions>
								<and>
									<if-global-variable mode="nocase" name="reset-external-password-on-failure" op="equal">false</if-global-variable>
									<if-operation op="equal">modify</if-operation>
									<if-xpath op="true">modify-attr[@attr-name='nspmDistributionPassword' and @failed-sync='true']</if-xpath>
								</and>
							</conditions>
							<actions>
								<!-- Block a password reset -->
								<do-veto/>
							</actions>
						</rule>
						<rule>
							<description>Convert modifies of a nspmDistributionPassword attribute to a modify password operation</description>
							<conditions>
								<and>
									<if-operation op="equal">modify</if-operation>
									<if-op-attr name="nspmDistributionPassword" op="available"/>
								</and>
							</conditions>
							<actions>
								<!-- Change all modify-attr elements for the nspmDistributionPassword attribute to modify-password elements-->
								<do-set-dest-password>
									<arg-string>
										<token-xpath expression="modify-attr[@attr-name='nspmDistributionPassword']//add-value//value"/>
									</arg-string>
								</do-set-dest-password>
								<!-- Remove all add-attr elements for the nspmDistributionPassword attribute -->
								<do-if>
									<arg-conditions>
										<and>
											<if-op-attr mode="regex" name="nspmDistributionPassword" op="changing-from">.+</if-op-attr>
										</and>
									</arg-conditions>
									<arg-actions>
										<do-append-xml-element before="../modify-password/password" expression="../modify-password" name="old-password"/>
										<do-append-xml-text expression="../modify-password/old-password">
											<arg-string>
												<token-removed-attr name="nspmDistributionPassword"/>
											</arg-string>
										</do-append-xml-text>
									</arg-actions>
								</do-if>
								<!-- Retain failed-sync status in the modify-password event-->
								<do-if>
									<arg-conditions>
										<and>
											<if-xpath op="true">modify-attr[@attr-name='nspmDistributionPassword' and @failed-sync='true']</if-xpath>
										</and>
									</arg-conditions>
									<arg-actions>
										<do-set-xml-attr expression="../modify-password" name="failed-sync">
											<arg-string>
												<token-text xml:space="preserve">true</token-text>
											</arg-string>
										</do-set-xml-attr>
									</arg-actions>
									<arg-actions/>
								</do-if>
								<do-strip-op-attr name="nspmDistributionPassword"/>
								<!-- Add an event-id attribute to the modify-password command we just added, required for operation data -->
								<do-set-xml-attr expression="../modify-password" name="event-id">
									<arg-string>
										<token-text>pwd-subscribe</token-text>
									</arg-string>
								</do-set-xml-attr>
							</actions>
						</rule>
						<rule>
							<description>Block empty modify operations</description>
							<conditions>
								<and>
									<if-operation op="equal">modify</if-operation>
									<if-xpath op="not-true">modify-attr</if-xpath>
								</and>
							</conditions>
							<actions>
								<!-- Veto empty modify -->
								<do-veto/>
							</actions>
						</rule>
					</policy>
				</rule>
				<rule checksum="654317975" name="NETQPWDSYNC-sub-cp-UserPwdCheck" package-id="3V750MRQ_201504031637130312" pkg-assoc-id="5GF18XJN_201505170105340535">
					<policy>
						<rule>
							<description>Veto if nspmDistributionPassword is not available</description>
							<conditions>
								<and>
									<if-class-name mode="nocase" op="equal">User</if-class-name>
								</and>
							</conditions>
							<actions>
								<do-veto-if-op-attr-not-available name="nspmDistributionPassword"/>
							</actions>
						</rule>
					</policy>
				</rule>
			</children>
		</subscriber>
		<rule checksum="1043791527" name="NETQRESTDCFG-itp-AddAssociation" package-id="DQ3ZPHXF_201505121302320165" pkg-assoc-id="1F50OXYM_201505121304050581">
			<policy>
				<rule>
					<description>Check for association -ADD</description>
					<conditions>
						<and>
							<if-operation mode="regex" op="equal">status</if-operation>
							<if-xml-attr mode="regex" name="level" op="equal">success</if-xml-attr>
							<if-op-property name="association" op="available"/>
							<if-op-property name="src-dn" op="available"/>
						</and>
					</conditions>
					<actions>
						<do-add-association>
							<arg-dn>
								<token-op-property name="src-dn"/>
							</arg-dn>
							<arg-association>
								<token-op-property name="association"/>
							</arg-association>
						</do-add-association>
					</actions>
				</rule>
				<rule>
					<description>Check for association - MODIFY</description>
					<conditions>
						<and>
							<if-operation mode="regex" op="equal">modify</if-operation>
							<if-association op="not-available"/>
						</and>
					</conditions>
					<actions>
						<do-set-op-association>
							<arg-association>
								<token-op-attr name="$drv.association$"/>
							</arg-association>
						</do-set-op-association>
					</actions>
				</rule>
			</policy>
		</rule>
		<rule checksum="234916055" name="NETQRESTDCFG-otp-AddAssociation" package-id="DQ3ZPHXF_201505121302320165" pkg-assoc-id="N3J373XE_201506121917120594">
			<policy>
				<rule>
					<description>Add association to unassociated users upon Migration.</description>
					<comment xml:space="preserve">The policy appends the &lt;association> to missing instance elements on triggering migration into IDV. It also updated the Dirxml-Association attribute of the user</comment>
					<conditions>
						<and>
							<if-xpath op="true">//status[@level="success"]</if-xpath>
							<if-operation mode="nocase" op="equal">instance</if-operation>
							<if-class-name mode="nocase" op="equal">User</if-class-name>
							<if-association op="not-available"/>
						</and>
					</conditions>
					<actions>
						<do-set-local-variable name="AssociationValueNode" scope="policy">
							<arg-node-set>
								<token-query class-name="User" datastore="src">
									<arg-dn>
										<token-src-dn/>
									</arg-dn>
									<arg-string>
										<token-global-variable name="drv.association"/>
									</arg-string>
								</token-query>
							</arg-node-set>
						</do-set-local-variable>
						<do-set-local-variable name="associationValue" scope="policy">
							<arg-string>
								<token-xpath expression="$AssociationValueNode//attr/value/text()"/>
							</arg-string>
						</do-set-local-variable>
						<do-add-association direct="true">
							<arg-association>
								<token-local-variable name="associationValue"/>
							</arg-association>
						</do-add-association>
						<do-append-xml-element expression="$current-op" name="association"/>
						<do-append-xml-text expression="$current-op/association">
							<arg-string>
								<token-local-variable name="associationValue"/>
							</arg-string>
						</do-append-xml-text>
					</actions>
				</rule>
				<rule>
					<description>Add association to unassociated groups upon Migration.</description>
					<comment xml:space="preserve">The policy appends &lt;association> to missing instance elements on triggering migration into IDV. It also updated the Dirxml-Association attribute of the group</comment>
					<conditions>
						<and>
							<if-xpath op="true">//status[@level="success"]</if-xpath>
							<if-operation mode="nocase" op="equal">instance</if-operation>
							<if-class-name mode="nocase" op="equal">Group</if-class-name>
							<if-association op="not-available"/>
						</and>
					</conditions>
					<actions>
						<do-set-local-variable name="AssociationValueNode" scope="policy">
							<arg-node-set>
								<token-query class-name="Group" datastore="src">
									<arg-dn>
										<token-src-dn/>
									</arg-dn>
									<arg-string>
										<token-global-variable name="drv.association"/>
									</arg-string>
								</token-query>
							</arg-node-set>
						</do-set-local-variable>
						<do-set-local-variable name="associationValue" scope="policy">
							<arg-string>
								<token-xpath expression="$AssociationValueNode//attr/value/text()"/>
							</arg-string>
						</do-set-local-variable>
						<do-add-association direct="true">
							<arg-association>
								<token-local-variable name="associationValue"/>
							</arg-association>
						</do-add-association>
						<do-append-xml-element expression="$current-op" name="association"/>
						<do-append-xml-text expression="$current-op/association">
							<arg-string>
								<token-local-variable name="associationValue"/>
							</arg-string>
						</do-append-xml-text>
					</actions>
				</rule>
			</policy>
		</rule>
		<rule checksum="1624447057" name="NETQRESTDCFG-otp-ConvertQueryExToQuery" package-id="DQ3ZPHXF_201505121302320165" pkg-assoc-id="QRP06MSK_201806121701170286">
			<policy>
				<rule>
					<description>Convert query-ex to query</description>
					<conditions>
						<and>
							<if-operation op="equal">query-ex</if-operation>
						</and>
					</conditions>
					<actions>
						<do-append-xml-element expression=".." name="query"/>
						<do-clone-xpath dest-expression="../query[last()]" src-expression="@*"/>
						<do-clone-xpath dest-expression="../query" src-expression="*"/>
						<do-strip-xpath expression="."/>
					</actions>
				</rule>
			</policy>
		</rule>
		<rule checksum="2381840225" name="NETQRESTDCFG-otp-AddFromCprsFlag" package-id="DQ3ZPHXF_201505121302320165" pkg-assoc-id="6MZKAGBJ_201806131428420678">
			<policy>
				<rule>
					<description>Add from-cprs flag to driver-operation-data</description>
					<conditions>
						<and>
							<if-op-property name="from-cprs" op="equal">true</if-op-property>
							<if-operation op="equal">driver-operation-data</if-operation>
						</and>
					</conditions>
					<actions>
						<do-set-xml-attr expression="." name="from-cprs">
							<arg-string>
								<token-text xml:space="preserve">true</token-text>
							</arg-string>
						</do-set-xml-attr>
					</actions>
				</rule>
			</policy>
		</rule>
		<rule checksum="3203836169" name="NETQRESTJSON-itp-CheckRetries" package-id="CP32RFWU_201505121250070695" pkg-assoc-id="964C650E_201505121250070695">
			<policy>
				<rule>
					<description>set retry on status if sought</description>
					<conditions>
						<and>
							<if-operation mode="case" op="equal">status</if-operation>
							<if-xml-attr mode="nocase" name="level" op="equal">success</if-xml-attr>
							<if-xpath op="true">driver-operation-data/@retry="true"</if-xpath>
						</and>
					</conditions>
					<actions>
						<do-set-xml-attr expression="$current-op" name="level">
							<arg-string>
								<token-text xml:space="preserve">retry</token-text>
							</arg-string>
						</do-set-xml-attr>
					</actions>
				</rule>
			</policy>
		</rule>
		<rule checksum="2360235429" name="NOVLPWDSYNC-itp-EmailOnFailedPwdSub" package-id="XTEF1YO3_201006231733410161" pkg-assoc-id="P3E27K73_201006231751340034">
			<policy>
				<description>Email notifications for failed password subscriptions</description>
				<rule>
					<description>Send e-mail on a failure when subscribing to passwords</description>
					<conditions>
						<and>
							<if-global-variable mode="nocase" name="notify-user-on-password-dist-failure" op="equal">true</if-global-variable>
							<if-operation op="equal">status</if-operation>
							<if-xpath op="true">self::status[@level != 'success'][text() != '']/operation-data/password-subscribe-status/association[text() != '']</if-xpath>
						</and>
					</conditions>
					<actions>
						<do-send-email-from-template notification-dn="cn=security\cn=Default Notification Collection" template-dn="cn=security\cn=Default Notification Collection\cn=Password Set Fail">
							<arg-string name="UserFullName">
								<token-dest-attr name="Full Name">
									<arg-association>
										<token-xpath expression="self::status/operation-data/password-subscribe-status/association"/>
									</arg-association>
								</token-dest-attr>
							</arg-string>
							<arg-string name="UserGivenName">
								<token-dest-attr name="Given Name">
									<arg-association>
										<token-xpath expression="self::status/operation-data/password-subscribe-status/association"/>
									</arg-association>
								</token-dest-attr>
							</arg-string>
							<arg-string name="UserLastName">
								<token-dest-attr name="Surname">
									<arg-association>
										<token-xpath expression="self::status/operation-data/password-subscribe-status/association"/>
									</arg-association>
								</token-dest-attr>
							</arg-string>
							<arg-string name="ConnectedSystemName">
								<token-global-variable name="ConnectedSystemName"/>
							</arg-string>
							<arg-string name="FailureReason">
								<token-text/>
								<token-xpath expression="self::status/child::text()"/>
							</arg-string>
							<arg-string name="to">
								<token-dest-attr name="Internet EMail Address">
									<arg-association>
										<token-xpath expression="self::status/operation-data/password-subscribe-status/association"/>
									</arg-association>
								</token-dest-attr>
							</arg-string>
						</do-send-email-from-template>
					</actions>
				</rule>
				<rule>
					<description>Send e-mail on failure to reset connected system password using the Identity Vault password</description>
					<conditions>
						<and>
							<if-global-variable mode="nocase" name="notify-user-on-password-dist-failure" op="equal">true</if-global-variable>
							<if-operation op="equal">status</if-operation>
							<if-xpath op="true">self::status[@level != 'success']/operation-data/password-reset-status</if-xpath>
						</and>
					</conditions>
					<actions>
						<do-send-email-from-template notification-dn="cn=security\cn=Default Notification Collection" template-dn="cn=security\cn=Default Notification Collection\cn=Password Reset Fail">
							<arg-string name="UserFullName">
								<token-dest-attr name="Full Name">
									<arg-association>
										<token-xpath expression="self::status/operation-data/password-reset-status/association"/>
									</arg-association>
								</token-dest-attr>
							</arg-string>
							<arg-string name="UserGivenName">
								<token-dest-attr name="Given Name">
									<arg-association>
										<token-xpath expression="self::status/operation-data/password-reset-status/association"/>
									</arg-association>
								</token-dest-attr>
							</arg-string>
							<arg-string name="UserLastName">
								<token-dest-attr name="Surname">
									<arg-association>
										<token-xpath expression="self::status/operation-data/password-reset-status/association"/>
									</arg-association>
								</token-dest-attr>
							</arg-string>
							<arg-string name="ConnectedSystemName">
								<token-global-variable name="ConnectedSystemName"/>
							</arg-string>
							<arg-string name="FailureReason">
								<token-text/>
								<token-xpath expression="self::status/child::text()"/>
							</arg-string>
							<arg-string name="to">
								<token-dest-attr name="Internet EMail Address">
									<arg-association>
										<token-xpath expression="self::status/operation-data/password-reset-status/association"/>
									</arg-association>
								</token-dest-attr>
							</arg-string>
						</do-send-email-from-template>
					</actions>
				</rule>
			</policy>
		</rule>
		<rule checksum="1801215884" name="NOVLPWDSYNC-otp-EmailOnFailedPwdPub" package-id="XTEF1YO3_201006231733410161" pkg-assoc-id="MBHAM66E_201006231751400713">
			<policy>
				<description>Email notifications for failed password publications</description>
				<rule>
					<description>Send e-mail for a failed publish password operation</description>
					<conditions>
						<and>
							<if-global-variable mode="nocase" name="notify-user-on-password-dist-failure" op="equal">true</if-global-variable>
							<if-operation op="equal">status</if-operation>
							<if-xpath op="true">self::status[@level != 'success']/operation-data/password-publish-status</if-xpath>
						</and>
					</conditions>
					<actions>
						<!-- generate email notification -->
						<do-send-email-from-template notification-dn="cn=security\cn=Default Notification Collection" template-dn="cn=security\cn=Default Notification Collection\cn=Password Sync Fail">
							<arg-string name="UserFullName">
								<token-src-attr name="Full Name">
									<arg-association>
										<token-xpath expression="self::status/operation-data/password-publish-status/association"/>
									</arg-association>
								</token-src-attr>
							</arg-string>
							<arg-string name="UserGivenName">
								<token-src-attr name="Given Name">
									<arg-association>
										<token-xpath expression="self::status/operation-data/password-publish-status/association"/>
									</arg-association>
								</token-src-attr>
							</arg-string>
							<arg-string name="UserLastName">
								<token-src-attr name="Surname">
									<arg-association>
										<token-xpath expression="self::status/operation-data/password-publish-status/association"/>
									</arg-association>
								</token-src-attr>
							</arg-string>
							<arg-string name="ConnectedSystemName">
								<token-global-variable name="ConnectedSystemName"/>
							</arg-string>
							<arg-string name="to">
								<token-src-attr name="Internet EMail Address">
									<arg-association>
										<token-xpath expression="self::status/operation-data/password-publish-status/association"/>
									</arg-association>
								</token-src-attr>
							</arg-string>
							<arg-string name="FailureReason">
								<token-text/>
								<token-xpath expression="self::status/child::text()"/>
							</arg-string>
						</do-send-email-from-template>
					</actions>
				</rule>
			</policy>
		</rule>
		<global-config-def checksum="1492769924" name="NOVLPWDSYNC-GCVs" package-id="XTEF1YO3_201006231733410161" pkg-assoc-id="FVA6FG1H_201902191454010658">
			<attributes>
				<global-config-values>
					<configuration-values>
						<definitions display-name="Common Password Settings">
							<definition critical-change="true" display-name="Set default password if not available" name="defaultPassword.enable" type="enum">
								<description>Select 'Yes' to set a default password if password element is not available in user add event. This gcv parameter will control how *-cp-DefaultPassword policy executes.</description>
								<enum-choice display-name="Yes">yes</enum-choice>
								<enum-choice display-name="No">no</enum-choice>
								<value>yes</value>
							</definition>
						</definitions>
					</configuration-values>
				</global-config-values>
			</attributes>
		</global-config-def>
		<global-config-def checksum="349682616" name="NETQRESTPWD-GCV" package-id="3V750MRQ_201504031637130312" pkg-assoc-id="9AOAGBIZ_201504031637130332">
			<attributes>
				<global-config-values>
					<configuration-values>
						<definitions display-name="Password Synchronization">
							<definition display-name="Application accepts passwords from Identity Manager" name="enable-password-subscribe" type="boolean">
								<description>Select whether the application accepts passwords from Identity Manager. True allows passwords to flow from the Identity Manager data store to the connected system.</description>
								<value>true</value>
							</definition>
							<definition display-name="Identity Manager accepts passwords from application" name="enable-password-publish" type="boolean">
								<description>Select whether Identity Manager accepts passwords from the application. True allows passwords to flow from the connected system to the Identity Manager data store.</description>
								<value>true</value>
							</definition>
							<definition display-name="Publish passwords to NDS password" name="publish-password-to-nds" type="boolean">
								<description>Use the password from the connected system to set the non-reversible NDS password in eDirectory.</description>
								<value>true</value>
							</definition>
							<definition display-name="Publish passwords to Distribution Password" name="publish-password-to-dp" type="boolean">
								<description>Select whenther to use the password from the connected system to set the NMAS Distribution Password used for Identity Manager password synchronization.</description>
								<value>true</value>
							</definition>
							<definition display-name="Require password policy validation before publishing passwords" name="enforce-password-policy" type="boolean">
								<description>True applies the NMAS password policies during password operations on the Publisher channel. The password is not written to the data store if it does not comply. False does not apply the NMAS password policies during password operations on the Publisher channel.</description>
								<value>true</value>
							</definition>
							<definition display-name="Reset user's external system password to the Identity Manager password on failure" name="reset-external-password-on-failure" type="boolean">
								<description>True attempts to reset the password in the connected system by using the Distribution Password from the Identity Vault when a publish Distribution Password failure occurs.</description>
								<value>true</value>
							</definition>
							<definition display-name="Notify the user of password synchronization failure via e-mail" name="notify-user-on-password-dist-failure" type="boolean">
								<description/>
								<value>true</value>
							</definition>
						</definitions>
					</configuration-values>
				</global-config-values>
			</attributes>
		</global-config-def>
	</children>
	<global-config-values/>
</driver-configuration>