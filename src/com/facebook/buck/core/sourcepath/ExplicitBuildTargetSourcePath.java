/*
 * Copyright (c) Facebook, Inc. and its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.facebook.buck.core.sourcepath;

import com.facebook.buck.core.model.BuildTarget;
import com.facebook.buck.core.util.immutables.BuckStylePrehashedValue;
import com.facebook.buck.util.types.Pair;
import com.google.common.collect.ComparisonChain;
import com.google.common.hash.HashCode;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Optional;

/**
 * A {@link BuildTargetSourcePath} which resolves to a specific (possibly non-default) output of the
 * {@link com.facebook.buck.core.rules.BuildRule} referred to by its target.
 */
@BuckStylePrehashedValue
public abstract class ExplicitBuildTargetSourcePath implements BuildTargetSourcePath {

  /**
   * Construct a new immutable {@code ExplicitBuildTargetSourcePath} instance.
   *
   * @param target The value for the {@code target} attribute
   * @param resolvedPath The value for the {@code resolvedPath} attribute
   * @return An immutable ExplicitBuildTargetSourcePath instance
   */
  public static ExplicitBuildTargetSourcePath of(BuildTarget target, Path resolvedPath) {
    return of(target, resolvedPath, Optional.empty());
  }

  public static ExplicitBuildTargetSourcePath of(
      BuildTarget target, Path resolvedPath, Optional<? extends HashCode> precomputedHash) {
    return ImmutableExplicitBuildTargetSourcePath.of(target, resolvedPath, precomputedHash);
  }

  @Override
  public abstract BuildTarget getTarget();

  public abstract Path getResolvedPath();

  @Override
  public abstract Optional<HashCode> getPrecomputedHash();

  @Override
  public int hashCode() {
    return Objects.hash(getTarget(), getResolvedPath());
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }

    if (!(other instanceof ExplicitBuildTargetSourcePath)) {
      return false;
    }

    ExplicitBuildTargetSourcePath that = (ExplicitBuildTargetSourcePath) other;
    return getTarget().equals(that.getTarget()) && getResolvedPath().equals(that.getResolvedPath());
  }

  @Override
  public String toString() {
    return String.valueOf(new Pair<>(getTarget(), getResolvedPath()));
  }

  @Override
  public int compareTo(SourcePath other) {
    if (other == this) {
      return 0;
    }

    int classComparison = compareClasses(other);
    if (classComparison != 0) {
      return classComparison;
    }

    ExplicitBuildTargetSourcePath that = (ExplicitBuildTargetSourcePath) other;

    return ComparisonChain.start()
        .compare(getTarget(), that.getTarget())
        .compare(getResolvedPath(), that.getResolvedPath())
        .result();
  }
}
