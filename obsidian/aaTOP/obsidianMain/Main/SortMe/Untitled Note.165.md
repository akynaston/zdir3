# Untitled Note

Packages conference call notes 12/22/2014 10:45:36 AM
Packages benefits:
     - Shim config updates.
     - General updates
     -
1 - In summary, There seems to be a relatively high amount of risk and issues associated with using packages for not that much benefit.
2 - For TriVir's own shim, I suppose we have some obligation to follow the industry standard assuming NetIQ set one here. It just seems like
3 - For regular drivers we customize, it seems too problematic to make them part of our every day development.
     - There's a few ways that packages decide to order policies, and none of them seem like a good idea when we're building our own customizations.
4 - I realize they are meant to make it easier to upgrade driver, and I think we definitely should start with packages on each new driver so we get the latest data.
12/22/2014 8:41:56 AM
Packages notes
NARA's driver - longer term procedure change.
\- NARA old IDM drivers need to be upgraded.
     I need a little more context:
     - How much customization has been done on the NARA drivers?
     - What exactly prompted the upgrade? Are ew after some new specific fucntionality? is it just an engine or shim upgrade?
     - Upgraded . . .3.6.1 -
\- By the time a driver gets to us, we usually need to build something that's I think more complicated than packages can provide - things like Password sync seem ok, but other pcakges that give more functionality, and place scripts at any order in the chain seems a little scary.
12/22/2014 9:01:33 AM
\- Nara's need.
\- NARA needs an upgrade.
\- Benefits/drawbacks for using packages.
\- Defining what upgrade means.
     - Shim/Shim configuration
     - Policy
\- Team comments:
\- Policies should be backwards compatible . .upgrade is ambiguous.
\- Modernization: cleaning up driver policies:
     - Convert stylesheets to policies.
     - Add new functionality for new shims.
\- Each customer has specific requirements: use packages for a 'jumpstart'.
     - Hybrid approach: Use packages up front; not rely on packages going forward.
\- Standard reporting for policies would be helpful.
     - shipping reporting modules aren't ideal.
     - Customers still have specific needs that differ from functionality provided in packages.
\- IdMUnit confirm the functionality; not the packages.
\- Should we develop a TriVir package? Jim, Huston, Aaron not a fan.
\- Ordering from packages is error prone.
     - Policy ordering is very important, can easily break.
\- NetIQ's default logic in packages is undesirable.
\- The need to "drop something in" and have upgrades automated is there, but packages are not the answer.
\- Design work for package configuration has a very high amount of guess work.
\- Upgrade coding for packages is complicated and even more risky.
\- Automatic upgrades are quite involved and too risky; packages aren't the answer.
\- Policy insertion is problematic.
\- 5 ways to assign policy order in a package deployment:
     - policy first
     - policy last
     - policy before another policy
     - policy after another policy
     - policy weight. (recommended by NetIQ) - 0 to 1000 (there are some recommended ranges . .but still pretty non-deterministic.)
          - Package developer has to take a guess at this weight.
\- Packages could be a good thing: is it an industry standard?
\- TriVir won't be following industry standards that don't work.
\- IDM 4.5: integrated installer has been improved.
\- Has any one successfully done a package upgrade?
\- Jim had used packages for a starting driver, and has done some upgrade, sped up the starting process; but still had to customize.
\- May only be appropriate for packages for a new driver scenario.
\- Packages aren't going to have exactly what every client wants.
\- Upgrading existing drivers: trying to add packages to an old driver seems like an undesirable amount of work.
\- Upgrades typically don't include new functionality . .
\- Summary: while using packages seems dangerous, at a minimum knowing the functionality provided in packages is valuable, but at the end of the day, the AC is everything.
     - New driver: quick way to get something started
     - Existing driver upgrade: shim config, stylesheets etc: no experience!  Need to get this!
\- How AC documents that document base packages?
\- Reach out to Jeff and put together some package questions?
\- Geoffery Carmen talks about this: https://www.netiq.com/communities/cool-solutions/series/lets-talk-some-more-about-packages-in-designer-4/
\- Maybe put together some questions after we consume Geoffery Carmen's articles.
