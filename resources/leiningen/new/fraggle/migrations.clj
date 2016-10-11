(ns {{name}}.tools.migrations
  (:require [{{name}}.config :refer [connection-uri]]
            [ragtime.jdbc :as jdbc]
            [ragtime.repl :as repl]))

(defn load-config []
  {:datastore (jdbc/sql-database {:connection-uri (connection-uri)})
   :migrations (jdbc/load-resources "migrations")})

(defn migrate []
  (repl/migrate (load-config)))

(defn rollback []
  (repl/rollback (load-config)))
