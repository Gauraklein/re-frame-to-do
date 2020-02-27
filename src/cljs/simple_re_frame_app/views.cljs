(ns simple-re-frame-app.views
  (:require
   [re-frame.core :as re-frame]
   [simple-re-frame-app.subs :as subs]
   [simple-re-frame-app.events :as events]
   [simple-re-frame-app.to_do_list :refer [to-do-list]]
   [clojure.string :as str]
   [simple-re-frame-app.util :as util]))

(defn render-completed [to-do]
  (if (util/get-val to-do :completed?)
    [:li {:key to-do} (util/get-val to-do :task)]))


(defn completed-list []
  (let [to-do (re-frame/subscribe [::subs/to-do])]
    [:div
      [:ul (map render-completed @to-do)]]))




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
