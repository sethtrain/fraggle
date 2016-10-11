(ns {{name}}.persistence.core
  (:refer-clojure :exclude [update])
  (:require [{{name}}.config :refer [connection-map]]
            [clojure.java.jdbc :as j]
            [honeysql.core :as sql]))

;; JDBC operations
(defn execute! [sqlmap]
  (j/execute! (connection-map) (sql/format sqlmap)))

(defn query [sqlmap]
  (j/query (connection-map) (sql/format sqlmap)))

(defn query-first [sqlmap]
  (first (j/query (connection-map) (sql/format sqlmap))))

(defn insert! [sqlmap]
  (execute! sqlmap))

(defn update! [sqlmap]
  (execute! sqlmap))

(defn delete! [sqlmap]
  (execute! sqlmap))
