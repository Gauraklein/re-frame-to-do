(ns simple-re-frame-app.db)

; Initial state
(def default-db
  {:name "re-frame to-do app"
   :to-do {:clean-car {:task "clean car"
                       :completed? false}
           :pay-bills {:task "pay bills"
                       :completed? false}
           :practice-re-frame {:task "practice re-frame"
                               :completed? true}}})
