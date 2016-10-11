(ns {{name}}.config
  (:require [environ.core :refer [env]]))

(defn connection-uri []
  (format "jdbc:postgresql://%s:%s/%s?user=%s&password=%s"
          (:db-host env)
          (:db-port env)
          (:db-name env)
          (:db-user env)
          (:db-password env)))

(defn connection-map []
  {:classname "org.postgresql.Driver"
   :subprotocol "postgresql"
   :subname (format "//%s:%s/%s"
                    (:db-host env)
                    (:db-port env)
                    (:db-name env))
   :user (:db-user env)
   :password (:db-password env)})

(defn jwt-secret []
  (:jwt-secret env))