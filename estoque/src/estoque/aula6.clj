(ns estoque.aula6)

(def pedido {:mochila  {:quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}})

(defn imprime-e-15 [valor]
  (println "valor" valor)
  15)

(println (map imprime-e-15 pedido))

(defn imprime-e-15 [[chave valor]]
  (println chave "e" valor)
  15)

(println (map imprime-e-15 pedido))

(defn preco-dos-produto [[chave valor]]
  (* (:quantidade valor) (:preco valor)))

(println (map preco-dos-produto pedido))
(println (reduce +(map preco-dos-produto pedido)))

(defn preco-dos-produto [[_ valor]]
  (* (:quantidade valor) (:preco valor)))

(defn total-pedido
  [pedido]
  (reduce + (map preco-dos-produto pedido)))

(println (total-pedido pedido))

;THREAD LAST
(defn total-pedido
  [pedido]
  (->> pedido
      (map preco-dos-produto)
      (reduce +)))

(println (total-pedido pedido))


(defn preco-total-do-produto [produto]
  (* (:quantidade produto) (:preco produto)))

;THREAD LAST
(defn total-pedio
  [pedido]
  (->> vals
       (map preco-total-do-produto)
       (reduce +)))

(println (total-pedido pedido))

(def pedido {:mochila  {:quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}
             :chaveiro {:quantidade 1}})

(defn gratuito?
  [[chave item]]
  (<= (get item :preco 0 ) 0))

(println (filter gratuito? pedido))
(filter gratuito? pedido)

(defn gratuito?
  [item]
  (<= (get item :preco 0 ) 0))

(println "Filtrando gratuitos")
(println (filter (fn [[chave item]] (gratuito? item)) pedido))
(println (filter #(gratuito? (second %)) pedido))

(defn pago?
  [item]
  (not (gratuito? item)))

(println (pago? {:preco 50}))
(println (pago? {:preco 0}))

(println ((comp not gratuito?) {:preco 50}))

(def pago? (comp not gratuito?))
(println (pago? {:preco 20}))

