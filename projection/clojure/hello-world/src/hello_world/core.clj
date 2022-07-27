(ns hello-world.core)

; Comment

(defn example[] (println [+ 1 2 3]) )

(defn -main [& args]
  (example)
  (let [x 1 y 2] 
    (def z (+ x y 2))
    (println z))
  (println "Hello, World!"))