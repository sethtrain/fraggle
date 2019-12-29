(defproject {{name}} "0.1.0-SNAPSHOT"
  :description "Fraggle service: {{name}}"
  :url "http://example.com/FIXME"
  :dependencies [[buddy/buddy-sign "1.2.0"]
                 [cheshire "5.6.3"]
                 [clj-time "0.12.0"]
                 [compojure "1.5.1"]
                 [environ "1.1.0"]
                 [honeysql "0.7.0"]
                 [log4j/log4j "1.2.17" :exclusions [javax.mail/mail
                                                    javax.jms/jms
                                                    com.sun.jmdk/jmxtools
                                                    com.sun.jmx/jmxri]]
                 [org.clojure/clojure "1.8.0"]
                 [org.clojure/java.jdbc "0.6.2-alpha3"]
                 [org.clojure/tools.logging "0.3.1"]
                 [org.postgresql/postgresql "9.4.1209"]
                 [ragtime "0.6.3"]
                 [ring/ring-defaults "0.2.1"]
                 [ring/ring-json "0.4.0"]
                 [org.slf4j/slf4j-log4j12 "1.7.21"]]
  :aliases {"migrate" ["run" "-m" "{{name}}.tools.migrations/migrate"]
            "rollback" ["run" "-m" "{{name}}.tools.migrations/rollback"]
            "seed" ["run" "-m" "{{name}}.tools.seed/seed"]
            "reset" ["do" "rollback," "migrate," "seed"]}
  :plugins [[lein-ring "0.9.7"]]
  :ring {:handler {{name}}.server/app})
