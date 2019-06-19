# coursier-hang

1. run `docker-compose up -d`

2. run `sbt -no-global update`

It tries to download the non-existent dependency in a loop:

```
nginx_1  | 172.20.0.1 - - [19/Jun/2019:06:51:39 +0000] "GET 
/ivy-virtual/com.sample/common-lib_2.12/19.23.0-does-not-exist/ivys/ivy.xml.sha1 HTTP/1.1" 401 180 "-" "" "-"
nginx_1  | 172.20.0.1 - arti [19/Jun/2019:06:51:39 +0000] "GET 
/ivy-virtual/com.sample/common-lib_2.12/19.23.0-does-not-exist/ivys/ivy.xml.sha1 HTTP/1.1" 404 154 "-" "" "-"
nginx_1  | 172.20.0.1 - - [19/Jun/2019:06:51:39 +0000] "GET 
/ivy-virtual/com.sample/common-lib_2.12/19.23.0-does-not-exist/ivys/ivy.xml.sha1 HTTP/1.1" 401 180 "-" "" "-"
nginx_1  | 172.20.0.1 - arti [19/Jun/2019:06:51:39 +0000] "GET 
/ivy-virtual/com.sample/common-lib_2.12/19.23.0-does-not-exist/ivys/ivy.xml.sha1 HTTP/1.1" 404 154 "-" "" "-"
nginx_1  | 172.20.0.1 - arti [19/Jun/2019:06:51:39 +0000] "GET 
/ivy-virtual/com.sample/common-lib_2.12/19.23.0-does-not-exist/ivys/ivy.xml HTTP/1.1" 404 154 "-" "" "-"
nginx_1  | 172.20.0.1 - - [19/Jun/2019:06:51:39 +0000] "GET 
/ivy-virtual/com.sample/common-lib_2.12/19.23.0-does-not-exist/ivys/ivy.xml.sha1 HTTP/1.1" 401 180 "-" "" "-"
nginx_1  | 172.20.0.1 - - [19/Jun/2019:06:51:39 +0000] "GET /ivy-virtual/com.sample/common-lib_2.12/19.23.0-does-not-exist/ivys/ivy.xml 
HTTP/1.1" 401 180 "-" "" "-"
nginx_1  | 172.20.0.1 - arti [19/Jun/2019:06:51:39 +0000] "GET 
/ivy-virtual/com.sample/common-lib_2.12/19.23.0-does-not-exist/ivys/ivy.xml.sha1 HTTP/1.1" 404 154 "-" "" "-"
nginx_1  | 172.20.0.1 - arti [19/Jun/2019:06:51:39 +0000] "GET 
/ivy-virtual/com.sample/common-lib_2.12/19.23.0-does-not-exist/ivys/ivy.xml HTTP/1.1" 404 154 "-" "" "-"
nginx_1  | 172.20.0.1 - - [19/Jun/2019:06:51:39 +0000] "GET 
/ivy-virtual/com.sample/common-lib_2.12/19.23.0-does-not-exist/ivys/ivy.xml.sha1 HTTP/1.1" 401 180 "-" "" "-"
nginx_1  | 172.20.0.1 - arti [19/Jun/2019:06:51:39 +0000] "GET 
/ivy-virtual/com.sample/common-lib_2.12/19.23.0-does-not-exist/ivys/ivy.xml.sha1 HTTP/1.1" 404 154 "-" "" "-"
nginx_1  | 172.20.0.1 - - [19/Jun/2019:06:51:39 +0000] "GET /ivy-virtual/com.sample/common-lib_2.12/19.23.0-does-not-exist/ivys/ivy.xml 
HTTP/1.1" 401 180 "-" "" "-"
nginx_1  | 172.20.0.1 - - [19/Jun/2019:06:51:39 +0000] "GET 
/ivy-virtual/com.sample/common-lib_2.12/19.23.0-does-not-exist/ivys/ivy.xml.sha1 HTTP/1.1" 401 180 "-" "" "-"
nginx_1  | 172.20.0.1 - arti [19/Jun/2019:06:51:39 +0000] "GET /ivy-vi
...
```

It should stop fetching the resources after receiving a 404.
