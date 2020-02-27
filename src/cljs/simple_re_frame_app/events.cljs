(ns simple-re-frame-app.events
  (:require
   [re-frame.core :as re-frame]
   [simple-re-frame-app.util :as util]
   [simple-re-frame-app.db :as db]))


(re-frame/reg-event-db
 ::initialize-db
 (fn [_ _]
   db/default-db))

(re-frame/reg-event-db
  ::add-to-do
  (fn [db [_ new-task]]
    (update-in db [:to-do] assoc (keyword (util/replace-white-space new-task))
                                 {:task new-task
                                  :completed? false})))

(re-frame/reg-event-db
  ::delete-to-do
  (fn [db [_ task-to-delete]]
    (update-in db [:to-do] dissoc task-to-delete)))

(re-frame/reg-event-db
  ::complete-to-do
  (fn [db [_ completed-to-do]]
    (update-in db [:to-do completed-to-do] assoc :completed? true)))
