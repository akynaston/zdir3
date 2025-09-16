# Untitled Note

ISO3166 Alpha 3 country code - java conversion from ISO2 to ISO3 conersion:

      **public** **static** **void** main(String\[\] args) {
          String\[\] countries \= Locale._getISOCountries_();
          _localeMap_ \= **new** HashMap<String, Locale>(countries.length);
          **for** (String country : countries) {
        Locale locale \= **new** Locale("", country);
              _localeMap_.put(locale.getISO3Country().toUpperCase(), locale);
          }

Allows two to three letter country code mapping.
