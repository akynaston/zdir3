I think this may encode it properly:


https://gist.github.com/icksa/cddd885859a3f33fb464

It just has:
# appropriate format for unicodePwd:
python -c 'import base64; print base64.b64encode("\"PasswordString\"".encode("utf-16le"))'