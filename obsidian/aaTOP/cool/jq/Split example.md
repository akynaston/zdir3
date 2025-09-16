
works on linux:
jq -r '.Resources[].userName | split("@")' allusers.json


  "navin.kallolli",
  "wnco.com"
]
[
  "david.morabitofuentes",
  "wnco.com"
]
[
  "vallabh.kondra",
  "wnco.com"
]
[
  "manish.makin",
  "wnco.com"
]
[
  "e98765113942aaronishere",
  "wnco.com"
]
[
  "aaron.kynaston",
  "wnco.com"
]
[
  "e99001",
  "wnco.com"
]
[
  "mike.labit",
  "wnco.com"
]
[
  "e98765221676",
  "wnco.com"
]
[
  "e85201",
  "wnco.com"
]



More example:
https://michaelheap.com/extract-key-substring-using-jq/

[![](https://gravatar.com/avatar/bbf9decfbfc2ab5b450ec503749ded28?s=80)](https://michaelheap.com/)

[Twitter](https://twitter.com/mheap)[GitHub](https://github.com/mheap)[Mastodon](https://hachyderm.io/@mheap)

[Home](https://michaelheap.com/)[Blog](https://michaelheap.com/blog/)[Talks](https://michaelheap.com/talk/)[TIL](https://michaelheap.com/til/)[OSS](https://michaelheap.com/opensource/)

[Ideas](https://michaelheap.com/ideas) | [Uses](https://michaelheap.com/uses) | [RSS](https://michaelheap.com/rss)

[#jq](https://michaelheap.com/topic/jq)

# Extract substring of specific values with JQ

29 Oct 2014 in [TIL](https://michaelheap.com/til)

This is probably something very specific to my use case, but I was working with some JSON that looked something like this:

`   {    "something": {      "Identifying Key": [        {          "foo": "a.b.c",          "bar": "First Three"        },        {          "foo": "a.b.d",          "bar": "Second Three"        }      ],      "Another Key": [        {          "foo": "z.b.c",          "bar": "First Three, Take Two"        },        {          "foo": "z.b.d",          "bar": "Second Three, Take Two"        }      ]    }  }   `

From this, I wanted to extract everything before the first period in every instance of the `foo` key. Like I said, very specific use case.

To do it, I built the following [jq](http://stedolan.github.io/jq/) expression.

`   cat data.json | jq -r '.something | map(.[].foo | split(".")[0]) | unique | join("\n")'   `

Breaking that down:

`   # Select the top level namespace  cat data.json | jq -r '.something'  # Map over everything as key => value  cat data.json | jq -r '.something | map(.)'  # From each of those elements, step in to each array  cat data.json | jq -r '.something | map(.[])'  # And extract the foo key  cat data.json | jq -r '.something | map(.[].foo)'  # Inside the map, use "split" to split the string on a "."  cat data.json | jq -r '.something | map(.[].foo | split("."))'  # And only select the first element in the returned arrays  cat data.json | jq -r '.something | map(.[].foo | split(".")[0])'  # We only want to know about unique keys  cat data.json | jq -r '.something | map(.[].foo | split(".")[0]) | unique'  # And we want it as a string, not an array  cat data.json | jq -r '.something | map(.[].foo | split(".")[0]) | unique | join("\n")'   `

And with that, I have a unique list of values extracted from a specific key in an object. As I mentioned, it's very specific to my use case but it might help someone in the future