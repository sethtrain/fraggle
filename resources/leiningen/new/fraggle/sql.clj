(ns {{name}}.sql
  (:refer-clojure :exclude [update])
  (:require [honeysql.core :as sql]
            [honeysql.helpers :refer :all]))

;; CRUD Operations
(defn find-all [keys table]
  (-> (apply select keys)
      (from table)))

(defn find-one [keys table row-id]
  (-> (apply select keys)
      (from table)
      (where [:= :id row-id])))

(defn find-where [keys table where-clause]
  (-> (apply select keys)
      (from table)
      (where where-clause)))

(defn create! [table rows-map]
  (-> (insert-into table)
      (values (map #(assoc %1 :created-at (sql/call :now)
                              :updated-at (sql/call :now)) rows-map))))

(defn update-attrs! [table row-map]
  (let [{:keys [id]} (select-keys row-map [:id])]
    (-> (update table)
        (sset (dissoc row-map :id))
        (where [:= :id id]))))

(defn delete! [table row-id]
  (-> (delete-from table)
      (where [:= :id row-id])))

