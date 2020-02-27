(ns simple-re-frame-app.to_do_list
  (:require
   [re-frame.core :as re-frame]
   [simple-re-frame-app.subs :as subs]
   [simple-re-frame-app.events :as events]
   [clojure.string :as str]
   [simple-re-frame-app.util :as util]))

;; renders pending to-dos
(defn render-to-do [to-do]
  ;; boolean to check if task is completed
  (if (false? (util/get-val to-do :completed?))
    ;;if task is pending renders task as well as delete and complete buttons
    [:li {:key (key to-do)} (util/get-val to-do :task)
     [:button {:on-click
               (fn [e]
                (.preventDefault e)
                (re-frame/dispatch [::events/complete-to-do (key to-do)]))}
           "complete"]
     [:button {:on-click
               (fn [e]
                (.preventDefault e)
                (re-frame/dispatch [::events/delete-to-do (key to-do)]))}
           "delete"]]))

;;maps through to-dos looking for pending tasks
(defn to-do-list []
  ;; subscribes to to-dos in the app-db
  (let [to-do (re-frame/subscribe [::subs/to-do])]
    [:div
      [:ul (map render-to-do @to-do)]]))

;; renders completed tasks
(defn render-completed [to-do]
  ;; boolean to check if task is Completed
  (if (util/get-val to-do :completed?)
    [:li {:key to-do} (util/get-val to-do :task)]))

;; maps through to-dos looking for completed tasks
(defn completed-list []
  ;;subscribes to to-dos in app-db
  (let [to-do (re-frame/subscribe [::subs/to-do])]
    [:div
      [:ul (map render-completed @to-do)]]))
