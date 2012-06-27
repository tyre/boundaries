(ns boundaries.server
  (:require [noir.server :as server]))
(server/load-views "src/boundaries/views/")
  (defn -main [& m]
    (let [mode (or (first m) :dev)
      port (Integer. (get (System/getenv) "PORT" "8080"))]
      (server/start port {:mode (keyword mode)
        :ns 'boundaries})))