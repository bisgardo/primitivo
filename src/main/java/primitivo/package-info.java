/**
 * Base package for the Primitivo micro library:
 * Nicely packaged trivialities that solve a simple
 * but annoying problem.
 * <p>
 * The purpose of this library is to provide
 * intuitive, consistent, and well-polished
 * utilities for working with
 * {@link primitivo.array arrays},
 * {@link primitivo.iterate iterators},
 * and {@link primitivo.mutable mutable wrappers}
 * with both primitive and-nonprimitive types.
 * <p>
 * The scope of the library is very limited by design:
 * Only features that lower the friction of
 * working with the "lower-level" language features
 * mentioned above are included.
 * <p>
 * Most of the code in the library is borderline trivial,
 * but may significantly reduce the amount of boilerplate and
 * duplication in consuming code.
 * This means that readability doesn't need to be sacrificed
 * in order to get rid of the performance
 * overhead of e.g. autoboxing that higher-level constructs
 * often imply.
 * <p>
 * The rationale for the design choices outlines above is
 * that accepting this library to be a dependency of
 * even the smallest project should be a no-brainer:
 * All parts of the library are expected to be
 * useful in most reasonably sized projects.
 * <p>
 * The only dependency of this library is JDK 1.5+.
 *
 * @author Michael Bisgaard Olesen
 *
 * @see primitivo.array
 * @see primitivo.iterate
 * @see primitivo.mutable
 */
package primitivo;
