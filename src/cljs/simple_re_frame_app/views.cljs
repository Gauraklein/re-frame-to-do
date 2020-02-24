(ns simple-re-frame-app.views
  (:require
   [re-frame.core :as re-frame]
   [simple-re-frame-app.subs :as subs]))

(defn to-do-view []
  (let [to-do (re-frame/subscribe [::subs/to-do])]
    [:div
     [:p (get @to-do :first)]]))

(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])]
    [:div
     [:h1 "Hello from " @name]
     (to-do-view)]))
