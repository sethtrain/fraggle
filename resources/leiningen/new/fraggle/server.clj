(ns {{name}}.server
  (:require [buddy.sign.jwt :as jwt]
            [{{name}}.config :refer [jwt-secret]]
            [clojure.tools.logging :as log]
            [compojure.core :refer :all]
            [ring.middleware.json :refer [wrap-json-response wrap-json-params]]
            [ring.middleware.keyword-params :refer [wrap-keyword-params]]
            [ring.util.response :refer [response content-type]]))

(defn not-found [message]
  (fn [_]
    (log/info "File not found")
    (-> {:status 404
         :body {:message message}}
        (content-type "application/json; charset=utf-8"))))

(defn wrap-exception-json [handler]
  (fn [req]
    (try
      (handler req)
      (catch Exception e
        {:status 500 :body {:exception (.getMessage e)}}))))

(defn verify-token [token]
  (try
    (jwt/unsign token (jwt-secret))
    (catch Exception e
      false)))

(defn parse-token [req]
  (second (clojure.string/split (get-in req [:headers "authentication"]) #" ")))

(defroutes handler
  (GET "/" [] (response {:message "{{sanitized}} microservice"}))
  (not-found "Page not found"))

(def app
  (-> handler
      wrap-exception-json
      wrap-keyword-params
      wrap-json-params
      wrap-json-response))

