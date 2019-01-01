(ns pedestal-getting-started.core
  (:require [io.pedestal.http :as http]))

(defn respond-hello [request]
  {:status 200
   :body   "Hello, world!"})

(def routes
  #{["/greet" :get `respond-hello]})

(defn -main []
  (-> {::http/routes routes
       ::http/port   8890
       ::http/type   :jetty}
      http/create-server
      http/start))
