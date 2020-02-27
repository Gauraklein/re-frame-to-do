(ns simple-re-frame-app.util
  (:require
    [clojure.string :as str]))

; gets an item by id
(defn by-id [id]
  (js/document.getElementById id))

; grabs value of item by id
(defn get-value [id]
  (.-value (by-id id)))

;replaces white space with dashes for ids or keys
(defn replace-white-space [string]
  (str/replace string #" " "-"))

; gets value from nested hash map by key
(defn get-val [parent key]
  (get-in (val parent) [key]))
