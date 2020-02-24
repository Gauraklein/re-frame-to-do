(ns simple-re-frame-app.events
  (:require
   [re-frame.core :as re-frame]
   [simple-re-frame-app.db :as db]))


(re-frame/reg-event-db
 ::initialize-db
 (fn [_ _]
   db/default-db))

; (re-frame/reg-event-db
;   ::add-to-do
;   (fn [db [_ new-task]]
;     (assoc db/to-do
;            (into (db/to-do)))))
