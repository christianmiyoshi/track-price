FROM clojure:lein

EXPOSE 8080

WORKDIR /code

COPY . .

WORKDIR /code/projection-clojure

#CMD lein run
#CMD lein repl
#ENTRYPOINT ["tail", "-f", "/dev/null"]
#ENTRYPOINT ["lein", "repl", ":start", ":port", "7000"]
CMD (echo "(def dev-serv (run-dev))"; cat <&0) | lein repl :start :port 7000
#ENTRYPOINT ["tail", "-f", "/dev/null"]

#CMD lein repl :start :port 7000