
# Request OK

```bash
curl --request POST --header "Accept: */*" --header "Content-Type:" --url http://localhost:8080/test -k -v

```

# Request with ERROR

```bash
curl --request POST --header "Accept: */*" --header "Content-Type: ''" --url http://localhost:8080/test -k -v
curl --request POST --header "Accept: application/x-www-form-urlencoded" --url http://localhost:8080/test -k -v
```