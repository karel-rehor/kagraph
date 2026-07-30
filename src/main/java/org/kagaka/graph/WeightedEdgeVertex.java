package org.kagaka.graph;

import java.util.Hashtable;

/**
 * <p>WeightedEdgeVertex interface.</p>
 *
 * @author karl
 * @version $Id: $Id
 * @param <T> - any type
 */
public interface WeightedEdgeVertex<T> extends Vertex<T> {

    /**
     * <p>getMaxWeight.</p>
     *
     * @return a {@link java.lang.Double} object
     */
    Double getMaxWeight();

    /**
     * <p>getMinWeight.</p>
     *
     * @return a {@link java.lang.Double} object
     */
    Double getMinWeight();

    /**
     * <p>getWeights.</p>
     *
     * @return a {@link java.util.Hashtable} object
     */
    Hashtable<WeightedEdgeVertex<T>, Double> getWeights();

    /**
     * <p>getWeight.</p>
     *
     * @param key a {@link org.kagaka.graph.WeightedEdgeVertex} object
     * @return a {@link java.lang.Double} object
     */
    Double getWeight(WeightedEdgeVertex<T> key);

    /**
     * <p>setWeight.</p>
     *
     * @param key a {@link org.kagaka.graph.WeightedEdgeVertex} object
     * @param val a {@link java.lang.Double} object
     */
    void setWeight(WeightedEdgeVertex<T> key, Double val);

    /**
     * <p>addEdge.</p>
     *
     * @param vertex a {@link org.kagaka.graph.WeightedEdgeVertex} object
     * @param weight a {@link java.lang.Double} object
     */
    void addEdge(WeightedEdgeVertex<T> vertex, Double weight);

    /**
     * <p>addMutualEdge.</p>
     *
     * @param vertex a {@link org.kagaka.graph.WeightedEdgeVertex} object
     * @param weight a {@link java.lang.Double} object
     * @param myWeight a {@link java.lang.Double} object
     */
    void addMutualEdge(WeightedEdgeVertex<T> vertex, Double weight, Double myWeight);

    /**
     * <p>removeWeightedEdge.</p>
     *
     * @param vertex a {@link org.kagaka.graph.WeightedEdgeVertex} object
     */
    void removeWeightedEdge(WeightedEdgeVertex<T> vertex);

    /**
     * <p>removeAllWeightedEdges.</p>
     */
    void removeAllWeightedEdges();

}
