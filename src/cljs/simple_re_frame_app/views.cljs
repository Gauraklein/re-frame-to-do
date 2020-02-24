(ns simple-re-frame-app.views
  (:require
   [re-frame.core :as re-frame]
   [simple-re-frame-app.subs :as subs]))

(defn to-do-view []
  (let [to-do (re-frame/subscribe [::subs/to-do])]
    [:div
     [:p (map str @to-do)]]))

(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])]
    [:div
     [:h1 @name]
     [:input]
     [:button "add to-do"]
     (to-do-view)]))
