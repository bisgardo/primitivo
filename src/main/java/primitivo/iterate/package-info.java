/**
 * Implementations of the {@link java.util.Iterator} interface
 * that produce unboxed primitive values.
 * <p>
 * The class {@link primitivo.iterate.ObjectIterator} defines a
 * static factory for creating a generic iterator from an array.
 * <p>
 * The following classes contain a set of
 * static factory functions for creating an iterator of
 * the containing type from arrays, ranges,
 * iterators of narrower types, and
 * the type's boxed counterpart:
 * <ul>
 *     <li>{@link primitivo.iterate.BooleanIterator}</li>
 *     <li>{@link primitivo.iterate.ByteIterator}</li>
 *     <li>{@link primitivo.iterate.ShortIterator}</li>
 *     <li>{@link primitivo.iterate.CharIterator}</li>
 *     <li>{@link primitivo.iterate.IntIterator}</li>
 *     <li>{@link primitivo.iterate.LongIterator}</li>
 *     <li>{@link primitivo.iterate.FloatIterator}</li>
 *     <li>{@link primitivo.iterate.DoubleIterator}</li>
 * </ul>
 * All these classes naturally implement
 * {@link java.util.Iterator Iterator&lt;T&gt;},
 * where {@code T} is the appropriate boxed type.
 *
 * @author Michael Bisgaard Olesen
 *
 * @see primitivo
 */
package primitivo.iterate;
