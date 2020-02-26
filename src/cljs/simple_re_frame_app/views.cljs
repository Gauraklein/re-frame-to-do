(ns simple-re-frame-app.views
  (:require
   [re-frame.core :as re-frame]
   [simple-re-frame-app.subs :as subs]
   [simple-re-frame-app.events :as events]))

(defn to-do-view []
  (let [to-do (re-frame/subscribe [::subs/to-do])]
    [:div
     [:p (map str @to-do)]]))

(defn by-id [id]
  (js/document.getElementById id))

(defn get-value [id]
  (.-value (by-id id)))


(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])]
    [:div
     [:h1 @name]
     [:input {:id "new-to-do"}]
     [:button
      {:on-click (fn [e]
                   (.preventDefault e)
                   (re-frame/dispatch [::events/add-to-do (get-value "new-to-do")]))}
      "add to-do"]
     (to-do-view)]))
