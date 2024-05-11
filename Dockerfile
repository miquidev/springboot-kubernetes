FROM ubuntu:latest
LABEL authors="Michael"

ENTRYPOINT ["top", "-b"]