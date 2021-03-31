/**
 * Classes for wrapping mutable values and references.
 * <p>
 * The class {@link primitivo.mutable.MutableObject} wraps a nullable object
 * reference of a generic type.
 * <p>
 * The following classes furthermore provide mutable alternatives to
 * the built-in boxing types of the primitive types:
 * <ul>
 *     <li>{@link primitivo.mutable.MutableBoolean}</li>
 *     <li>{@link primitivo.mutable.MutableByte}</li>
 *     <li>{@link primitivo.mutable.MutableShort}</li>
 *     <li>{@link primitivo.mutable.MutableChar}</li>
 *     <li>{@link primitivo.mutable.MutableInt}</li>
 *     <li>{@link primitivo.mutable.MutableLong}</li>
 *     <li>{@link primitivo.mutable.MutableFloat}</li>
 *     <li>{@link primitivo.mutable.MutableDouble}</li>
 * </ul>
 *
 * <p>
 * The classes have getter and setter methods and methods for performing arithmetic
 * and bitwise transformations of the wrapped value.
 * They also correctly implement
 * {@link java.lang.Comparable#compareTo(java.lang.Object) compareTo} and
 * {@link java.lang.Object#equals(java.lang.Object) equals}/
 * {@link java.lang.Object#hashCode() hashCode}.
 * {@link java.lang.Object#toString() toString} delegates to the appropriate
 * {@code valueOf} function on {@link java.lang.String}.
 *
 * <p>
 * The classes are intended to be used in place of plain variables
 * or built-in boxed types in the following use cases:
 * <ul>
 *     <li>A non-constant variable must be final because
 *     an inner class is referring to it.</li>
 *     <li>The elements of a collection must be mutable,
 *     but the collection itself should not be mutated
 *     (be careful not to violate the collection's preconditions).</li>
 *     <li>A variable of boxed type is updated while
 *     preventing unnecessary boxings.</li>
 * </ul>
 *
 * @author Michael Bisgaard Olesen
 *
 * @see primitivo
 */
package primitivo.mutable;
