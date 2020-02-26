(ns simple-re-frame-app.views
  (:require
   [re-frame.core :as re-frame]
   [simple-re-frame-app.subs :as subs]
   [simple-re-frame-app.events :as events]
   [simple-re-frame-app.to_do_list :refer [to-do-list]]
   [clojure.string :as str]
   [simple-re-frame-app.util :as util]))

(defn render-completed [completed-task]
  [:li {:key completed-task} (str (val completed-task))])


(defn completed-list []
  (let [completed (re-frame/subscribe [::subs/completed])]
    [:div
      [:ul (map render-completed @completed)]]))




(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])]
    [:div
     [:h1 @name]
     [:input {:id "new-to-do"}]
     [:button
      {:on-click (fn [e]
                   (.preventDefault e)
                   (re-frame/dispatch [::events/add-to-do (util/get-value "new-to-do")]))}

      "add to-do"]
     (to-do-list)
     [:hr]
     [:h1 "Completed"]
     (completed-list)]))
