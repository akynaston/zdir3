6/25/2024 11:30:11 AM
Version 1.0

Here are a few notes: - 
 - Looks like Harsh & Baron and perhaps Kyle may already be included; but I suspect their teams may be the most hard hit by this if at all; ideally, we'd make sure they're included on all communication on timing.
 - Any changes to Pipeline libraries will be a major impact; we may need to revisit all of our pipeline code if these change.
 - Large repos 5GB+ can severely hamper the process: I can help re-write repo history to remove files that shouldn't be there to reduce size. I think there's only one repo at risk of this - https://gitlab-tools.swacorp.com/csiam/idmarchive/security_vob_archive
 - Everyone should likely generate new ssh keys for the new system; and upload the public key as before. Even if they use the same keys we have already; it may be a good time to generate new keys, for the same reason we change passwords regularly.
 - There's not a whole lot of technical details on the page, though there are a few items:
	 - I have a backup copy of some repository rules such as push rules since they're not included:
	 - Branch name: ^((\S*\/)?(\b[A-Z0-9]{2,9}-\d+)((\/|-)[a-zA-Z0-9-]*[a-zA-Z0-9])*)$|(master|main|hotfix|develop|development|release(\S*)?)$
	 - master: allowed to merge: Developers + maintainers
	 - commit messages must match:
		 - ^((breaking|bug|build|chore|ci|docs|feat|fix|major|minor|patch|perf|refactor|revert|style|test)(\(\w+( \w+)*\))?(!)?(: (((\b[A-Z0-9]{2,9}-\d+))|((0|[1-9]\d*)\.(0|[1-9]\d*)\.(0|[1-9]\d*)(?:-((?:0|[1-9]\d*|\d*[a-zA-Z-][0-9a-zA-Z-]*)(?:\.(?:0|[1-9]\d*|\d*[a-zA-Z-][0-9a-zA-Z-]*))*))?(?:\+([0-9a-zA-Z-]+(?:\.[0-9a-zA-Z-]+)*))?)) (.*\s*)*))|(Merge (.*\s*)*)|(Initial [Cc]ommit$)|^(Notes added by \'git notes add\')'