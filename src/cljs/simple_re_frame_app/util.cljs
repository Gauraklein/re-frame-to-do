(ns simple-re-frame-app.util
  (:require
    [clojure.string :as str]))

(defn by-id [id]
  (js/document.getElementById id))

(defn get-value [id]
  (.-value (by-id id)))

(defn replace-white-space [string]
  (str/replace string #" " "-"))
