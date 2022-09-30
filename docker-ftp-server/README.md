ftp-server
===================

Docker FTP server


How to use
----------

Simple command line usage:

```
docker build -t ftp-server
docker run -p 11021:21 -it --rm -e FTP_USER=<username> -e FTP_PASS=<password> ftp-server
```

You can test using:
```
ftp localhost 11021
```

