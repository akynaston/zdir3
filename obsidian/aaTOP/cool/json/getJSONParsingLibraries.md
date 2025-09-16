#!/bin/bash
# retrieves Fernando Freita's json libraries!
git clone https://github.com/fchierad/IDM-ECMAlib.git
pushd IDM-ECMAlib
git checkout master
git pull
popd
