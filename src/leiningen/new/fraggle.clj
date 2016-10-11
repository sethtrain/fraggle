(ns leiningen.new.fraggle
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "fraggle"))

(defn fraggle
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh fraggle project.")
    (->files data
             ["project.clj" (render "project.clj" data)]
             ["README.md" (render "README.md" data)]
             [".gitignore" (render ".gitignore" data)]
             [".lein-env" (render "lein-env" data)]
             ["log/.gitkeep" (render ".gitkeep" data)]
             ["resources/log4j.properties" (render "log4j.properties" data)]
             ["resources/migrations/.gitkeep" (render ".gitkeep" data)]
             ["src/{{sanitized}}/config.clj" (render "config.clj" data)]
             ["src/{{sanitized}}/server.clj" (render "server.clj" data)]
             ["src/{{sanitized}}/sql.clj" (render "sql.clj" data)]
             ["src/{{sanitized}}/peristence/core.clj" (render "persistence.clj" data)]
             ["src/{{sanitized}}/repository/.gitkeep" (render ".gitkeep" data)]
             ["src/{{sanitized}}/resources/.gitkeep" (render ".gitkeep" data)]
             ["src/{{sanitized}}/tools/migrations.clj" (render "migrations.clj" data)]
             ["src/{{sanitized}}/tools/seed.clj" (render "seed.clj" data)])))
