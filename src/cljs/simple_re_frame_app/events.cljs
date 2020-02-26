(ns simple-re-frame-app.events
  (:require
   [re-frame.core :as re-frame]
   [simple-re-frame-app.db :as db]))


(re-frame/reg-event-db
 ::initialize-db
 (fn [_ _]
   db/default-db))

(re-frame/reg-event-db
  ::add-to-do
  (fn [db [_ new-task]]
    (update-in db [:to-do] conj new-task)))

(re-frame/reg-event-db
  ::delete-to-do
  (fn [db [_ task-to-delete]]
    (js/console.log task-to-delete)
    (update-in db [:to-do] dissoc task-to-delete)))
