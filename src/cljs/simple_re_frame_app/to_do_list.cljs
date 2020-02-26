(ns simple-re-frame-app.to_do_list
  (:require
   [re-frame.core :as re-frame]
   [simple-re-frame-app.subs :as subs]
   [simple-re-frame-app.events :as events]
   [clojure.string :as str]
   [simple-re-frame-app.util :as util]))

(defn render-to-do [to-do]
  [:li {:key to-do} (str (val to-do))
      ; [:button {}
      ;   "edit"]
  [:button {:id (str "complete-" (util/replace-white-space (val to-do)))
            :on-click (fn [e]
                        (.preventDefault e)
                        (re-frame/dispatch [::events/complete-to-do (val to-do)]))}
        "complete"]
  [:button {:id (str "delete-" (util/replace-white-space (val to-do)))
                :on-click (fn [e]
                            (.preventDefault e)
                            (re-frame/dispatch [::events/delete-to-do (key to-do)]))}
        "delete"]])


(defn to-do-list []
  (let [to-do (re-frame/subscribe [::subs/to-do])]
    [:div
      [:ul (map render-to-do @to-do)]]))
