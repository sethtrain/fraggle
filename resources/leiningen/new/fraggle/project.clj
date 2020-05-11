(defproject {{name}} "0.1.0-SNAPSHOT"
  :description "Fraggle service: {{name}}"
  :url "http://example.com/FIXME"
  :dependencies [[buddy/buddy-sign "3.1.0"]
                 [cheshire "5.10.0"]
                 [compojure "1.6.1"]
                 [environ "1.2.0"]
                 [honeysql "0.9.10"]
                 [log4j/log4j "2.13.2" :exclusions [javax.mail/mail
                                                    javax.jms/jms
                                                    com.sun.jmdk/jmxtools
                                                    com.sun.jmx/jmxri]]
                 [org.clojure/clojure "1.10.1"]
                 [org.clojure/java.jdbc "0.7.11"]
                 [org.clojure/tools.logging "1.1.0"]
                 [org.postgresql/postgresql "42.2.12"]
                 [ragtime "0.8.0"]
                 [ring/ring-defaults "0.3.2"]
                 [ring/ring-json "0.5.0"]
                 [org.slf4j/slf4j-log4j12 "1.7.30"]]
  :aliases {"migrate" ["run" "-m" "{{name}}.tools.migrations/migrate"]
            "rollback" ["run" "-m" "{{name}}.tools.migrations/rollback"]
            "seed" ["run" "-m" "{{name}}.tools.seed/seed"]
            "reset" ["do" "rollback," "migrate," "seed"]}
  :plugins [[lein-ring "0.12.5"]]
  :ring {:handler {{name}}.server/app})
