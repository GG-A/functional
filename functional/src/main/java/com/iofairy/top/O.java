/*
 * Copyright (C) 2021 iofairy, <https://github.com/io-fairy/functional>
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
package com.iofairy.top;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.DoubleAccumulator;
import java.util.concurrent.atomic.DoubleAdder;

/**
 * Global Variables And Methods for {@link Object} Operations. <br>
 * {@link Object} 相关操作的常用变量与函数。<br>
 * &gt;&gt;&gt;&gt;&gt;&gt; <br>
 * 采用简单类名 <b>O (Object / Other)</b> 模拟类似 Kotlin 的 <b>Top-level function</b>（顶级函数、全局函数）
 *
 * @since 0.3.0
 */
public final class O {

    /**
     * Creates a new <b>empty array</b> with the specified array class type. <br>
     * 根据传入的数组类型，创建一个该类型的<b>空数组</b>。
     *
     * @param tsClass array type
     * @param <T>     array type
     * @return empty array
     * @since 0.2.2
     */
    public static <T> T[] array0(Class<T[]> tsClass) {
        return arrayM(tsClass, 0);
    }

    /**
     * Creates a new <b>empty array</b> with the specified class type. <br>
     * 根据传入的类型，创建一个该类型的<b>空数组</b>。
     *
     * @param tClass array type
     * @param <T>    array type
     * @return empty array
     * @since 0.2.2
     */
    public static <T> T[] arrayO(Class<T> tClass) {
        return arrayN(tClass, 0);
    }

    /**
     * Creates a new <b>array</b> with the specified array class type and length. <br>
     *
     * @param tsClass array type
     * @param length  array length
     * @param <T>     array type
     * @return new array with length
     * @since 0.3.1
     */
    public static <T> T[] arrayM(Class<T[]> tsClass, int length) {
        @SuppressWarnings("unchecked")
        T[] ts = (T[]) Array.newInstance(tsClass.getComponentType(), length);
        return ts;
    }

    /**
     * Creates a new <b>array</b> with the specified class type and length. <br>
     *
     * @param tClass array type
     * @param length array length
     * @param <T>    array type
     * @return new array with length
     * @since 0.3.1
     */
    public static <T> T[] arrayN(Class<T> tClass, int length) {
        @SuppressWarnings("unchecked")
        T[] ts = (T[]) Array.newInstance(tClass, length);
        return ts;
    }

    /**
     * Creates a new <b>array</b> with the specified array class type and length,
     * and assigns the <b>t</b> object reference to each element of array. <br>
     *
     * @param tsClass array type
     * @param length  array length
     * @param t       t object
     * @param <T>     array type
     * @return new array with length and fill <b>t</b> elements
     * @since 0.3.1
     */
    public static <T> T[] arrayFillM(Class<T[]> tsClass, int length, T t) {
        T[] ts = arrayM(tsClass, length);
        Arrays.fill(ts, t);
        return ts;
    }

    /**
     * Creates a new <b>array</b> with the specified class type and length,
     * and assigns the <b>t</b> object reference to each element of array. <br>
     *
     * @param tClass array type
     * @param length array length
     * @param t      t object
     * @param <T>    array type
     * @return new array with length and fill <b>t</b> elements
     * @since 0.3.1
     */
    public static <T> T[] arrayFillN(Class<T> tClass, int length, T t) {
        T[] ts = arrayN(tClass, length);
        Arrays.fill(ts, t);
        return ts;
    }

    /**
     * Get {@link Throwable}'s all causes order by the shallow and deep <br>
     * 获取所有 {@link Throwable} 的 causes，由浅至深排序
     *
     * @param throwable Throwable
     * @return current {@code throwable} and throwable's all causes
     * @since 0.3.4
     */
    public static List<Throwable> causeTrace(Throwable throwable) {
        if (throwable == null) return null;

        List<Throwable> causes = new ArrayList<>();
        causes.add(throwable);
        Throwable cause = throwable;
        while ((cause = cause.getCause()) != null) {
            causes.add(cause);
        }
        return causes;
    }

    /**
     * Gets the first object that is not {@code null}. <br>
     * 获取第一个不为 {@code null} 的值
     *
     * @param rs  object array
     * @param <R> return type
     * @return first non {@code null} object
     * @since 0.0.7
     */
    @SafeVarargs
    public static <R> R firstNonNull(R... rs) {
        if (G.isEmpty(rs)) return null;
        for (R r : rs) {
            if (r != null) return r;
        }
        return null;
    }

    /*###################################################################################
     ************************************************************************************
     ------------------------------------------------------------------------------------
     ***********************   index of maximum value in arrays   ***********************
     ------------------------------------------------------------------------------------
     ************************************************************************************
     ###################################################################################*/

    /**
     * Getting index of maximum value in {@code byte[]}
     *
     * @param bs {@code byte[]}
     * @return index of maximum value, {@code -1} if not found.
     * @since 0.3.4
     */
    public static int indexOfMax(byte[] bs) {
        if (G.isEmpty(bs)) return -1;
        int index = 0;
        byte max = bs[0];
        for (int i = 1; i < bs.length; i++) {
            byte iByte = bs[i];
            if (iByte > max) {
                max = iByte;
                index = i;
            }
        }
        return index;
    }

    /**
     * Getting index of maximum value in {@code short[]}
     *
     * @param ss {@code short[]}
     * @return index of maximum value, {@code -1} if not found.
     * @since 0.3.4
     */
    public static int indexOfMax(short[] ss) {
        if (G.isEmpty(ss)) return -1;
        int index = 0;
        short max = ss[0];
        for (int i = 1; i < ss.length; i++) {
            short iShort = ss[i];
            if (iShort > max) {
                max = iShort;
                index = i;
            }
        }
        return index;
    }

    /**
     * Getting index of maximum value in {@code char[]}
     *
     * @param cs {@code char[]}
     * @return index of maximum value, {@code -1} if not found.
     * @since 0.3.4
     */
    public static int indexOfMax(char[] cs) {
        if (G.isEmpty(cs)) return -1;
        int index = 0;
        char max = cs[0];
        for (int i = 1; i < cs.length; i++) {
            char iChar = cs[i];
            if (iChar > max) {
                max = iChar;
                index = i;
            }
        }
        return index;
    }

    /**
     * Getting index of maximum value in {@code int[]}
     *
     * @param is {@code int[]}
     * @return index of maximum value, {@code -1} if not found.
     * @since 0.3.4
     */
    public static int indexOfMax(int[] is) {
        if (G.isEmpty(is)) return -1;
        int index = 0;
        int max = is[0];
        for (int i = 1; i < is.length; i++) {
            int iInt = is[i];
            if (iInt > max) {
                max = iInt;
                index = i;
            }
        }
        return index;
    }

    /**
     * Getting index of maximum value in {@code long[]}
     *
     * @param ls {@code long[]}
     * @return index of maximum value, {@code -1} if not found.
     * @since 0.3.4
     */
    public static int indexOfMax(long[] ls) {
        if (G.isEmpty(ls)) return -1;
        int index = 0;
        long max = ls[0];
        for (int i = 1; i < ls.length; i++) {
            long iLong = ls[i];
            if (iLong > max) {
                max = iLong;
                index = i;
            }
        }
        return index;
    }

    /**
     * Getting index of maximum value in {@code float[]} ({@link Float#NaN} will be ignored)
     *
     * @param fs {@code float[]}
     * @return index of maximum value, {@code -1} if not found.
     * @since 0.3.4
     */
    public static int indexOfMax(float[] fs) {
        if (G.isEmpty(fs)) return -1;
        int index = -1;
        float max = Float.NaN;
        for (int i = 0; i < fs.length; i++) {
            float iFloat = fs[i];
            if (!Float.isNaN(iFloat)) {
                if (Float.isNaN(max)) {
                    max = iFloat;
                    index = i;
                } else {
                    if (iFloat > max) {
                        max = iFloat;
                        index = i;
                    }
                }
            }
        }
        return index;
    }

    /**
     * Getting index of maximum value in {@code double[]} ({@link Double#NaN} will be ignored)
     *
     * @param ds {@code double[]}
     * @return index of maximum value, {@code -1} if not found.
     * @since 0.3.4
     */
    public static int indexOfMax(double[] ds) {
        if (G.isEmpty(ds)) return -1;
        int index = -1;
        double max = Double.NaN;
        for (int i = 0; i < ds.length; i++) {
            double iDouble = ds[i];
            if (!Double.isNaN(iDouble)) {
                if (Double.isNaN(max)) {
                    max = iDouble;
                    index = i;
                } else {
                    if (iDouble > max) {
                        max = iDouble;
                        index = i;
                    }
                }
            }
        }
        return index;
    }

    /*###################################################################################
     ************************************************************************************
     ------------------------------------------------------------------------------------
     ***********************   index of minimum value in arrays   ***********************
     ------------------------------------------------------------------------------------
     ************************************************************************************
     ###################################################################################*/

    /**
     * Getting index of minimum value in {@code byte[]}
     *
     * @param bs {@code byte[]}
     * @return index of minimum value, {@code -1} if not found.
     * @since 0.3.4
     */
    public static int indexOfMin(byte[] bs) {
        if (G.isEmpty(bs)) return -1;
        int index = 0;
        byte min = bs[0];
        for (int i = 1; i < bs.length; i++) {
            byte iByte = bs[i];
            if (iByte < min) {
                min = iByte;
                index = i;
            }
        }
        return index;
    }

    /**
     * Getting index of minimum value in {@code short[]}
     *
     * @param ss {@code short[]}
     * @return index of minimum value, {@code -1} if not found.
     * @since 0.3.4
     */
    public static int indexOfMin(short[] ss) {
        if (G.isEmpty(ss)) return -1;
        int index = 0;
        short min = ss[0];
        for (int i = 1; i < ss.length; i++) {
            short iShort = ss[i];
            if (iShort < min) {
                min = iShort;
                index = i;
            }
        }
        return index;
    }

    /**
     * Getting index of minimum value in {@code char[]}
     *
     * @param cs {@code char[]}
     * @return index of minimum value, {@code -1} if not found.
     * @since 0.3.4
     */
    public static int indexOfMin(char[] cs) {
        if (G.isEmpty(cs)) return -1;
        int index = 0;
        char min = cs[0];
        for (int i = 1; i < cs.length; i++) {
            char iChar = cs[i];
            if (iChar < min) {
                min = iChar;
                index = i;
            }
        }
        return index;
    }

    /**
     * Getting index of minimum value in {@code int[]}
     *
     * @param is {@code int[]}
     * @return index of minimum value, {@code -1} if not found.
     * @since 0.3.4
     */
    public static int indexOfMin(int[] is) {
        if (G.isEmpty(is)) return -1;
        int index = 0;
        int min = is[0];
        for (int i = 1; i < is.length; i++) {
            int iInt = is[i];
            if (iInt < min) {
                min = iInt;
                index = i;
            }
        }
        return index;
    }

    /**
     * Getting index of minimum value in {@code long[]}
     *
     * @param ls {@code long[]}
     * @return index of minimum value, {@code -1} if not found.
     * @since 0.3.4
     */
    public static int indexOfMin(long[] ls) {
        if (G.isEmpty(ls)) return -1;
        int index = 0;
        long min = ls[0];
        for (int i = 1; i < ls.length; i++) {
            long iLong = ls[i];
            if (iLong < min) {
                min = iLong;
                index = i;
            }
        }
        return index;
    }

    /**
     * Getting index of minimum value in {@code float[]} ({@link Float#NaN} will be ignored)
     *
     * @param fs {@code float[]}
     * @return index of minimum value, {@code -1} if not found.
     * @since 0.3.4
     */
    public static int indexOfMin(float[] fs) {
        if (G.isEmpty(fs)) return -1;
        int index = -1;
        float min = Float.NaN;
        for (int i = 0; i < fs.length; i++) {
            float iFloat = fs[i];
            if (!Float.isNaN(iFloat)) {
                if (Float.isNaN(min)) {
                    min = iFloat;
                    index = i;
                } else {
                    if (iFloat < min) {
                        min = iFloat;
                        index = i;
                    }
                }
            }
        }
        return index;
    }

    /**
     * Getting index of minimum value in {@code double[]} ({@link Double#NaN} will be ignored)
     *
     * @param ds {@code double[]}
     * @return index of minimum value, {@code -1} if not found.
     * @since 0.3.4
     */
    public static int indexOfMin(double[] ds) {
        if (G.isEmpty(ds)) return -1;
        int index = -1;
        double min = Double.NaN;
        for (int i = 0; i < ds.length; i++) {
            double iDouble = ds[i];
            if (!Double.isNaN(iDouble)) {
                if (Double.isNaN(min)) {
                    min = iDouble;
                    index = i;
                } else {
                    if (iDouble < min) {
                        min = iDouble;
                        index = i;
                    }
                }
            }
        }
        return index;
    }

    /**
     * Returns {@code true} if this {@code Number} value is {@link Double} or {@link DoubleAdder} or {@link DoubleAccumulator}, {@code false} otherwise.
     *
     * @param number number
     * @return Returns {@code true} if this {@code Number} value is {@link Double} or {@link DoubleAdder} or {@link DoubleAccumulator}, {@code false} otherwise.
     * @since 0.3.4
     */
    public static boolean isDouble(Number number) {
        return number instanceof Double
                || number instanceof DoubleAdder
                || number instanceof DoubleAccumulator;
    }

    /**
     * Returns {@code true} if this {@code Number} value is
     * a {@code Not-a-Number (NaN)} or {@code Infinite}, {@code false} otherwise.
     *
     * @param number number
     * @return Returns {@code true} if this {@code Number} value is
     * a {@code Not-a-Number (NaN)} or {@code Infinite}, {@code false} otherwise.
     * @since 0.3.4
     */
    public static boolean isInfinityOrNaN(Number number) {
        if (number == null) return false;
        if (number instanceof Float || isDouble(number)) {
            double d = number.doubleValue();
            return Double.isNaN(d) || Double.isInfinite(d);
        }
        return false;
    }

    /**
     * Convert {@code Number} to {@code BigDecimal}
     *
     * @param number number
     * @return BigDecimal
     * @since 0.3.4
     */
    public static BigDecimal toBigDecimal(Number number) {
        if (number == null) return null;
        if (isInfinityOrNaN(number))
            throw new NumberFormatException("The `number` is NaN or Infinity, can't convert to BigDecimal");

        return number instanceof BigDecimal
                ? (BigDecimal) number
                : (isDouble(number) ? BigDecimal.valueOf(number.doubleValue()) : new BigDecimal(number.toString())); // float 使用字符串更准确
    }

    /**
     * Compares two Numbers
     *
     * @param n1 number1
     * @param n2 number2
     * @return <ul>
     * <li>{@code -2}: one of the two numbers is {@code null};
     * <li>{@code -1}: number1 less than number2;
     * <li>&nbsp;{@code 0}: number1 equal number2;
     * <li>&nbsp;{@code 1}: number1 greater than number2.
     * </ul>
     * @since 0.3.0
     */
    public static int compare(Number n1, Number n2) {
        if (G.hasNull(n1, n2)) return -2;

        if (n1 == n2) return 0;
        boolean infinityOrNaN1 = isInfinityOrNaN(n1);
        boolean infinityOrNaN2 = isInfinityOrNaN(n2);
        if (infinityOrNaN1 || infinityOrNaN2) {
            if (infinityOrNaN1) {
                double d1 = n1.doubleValue();
                if (infinityOrNaN2) {   // infinityOrNaN1 为 true 且 infinityOrNaN2 为 true
                    return Double.compare(d1, n2.doubleValue());
                } else {     // infinityOrNaN1 为 true，但 infinityOrNaN2 为 false
                    if (Double.isNaN(d1) || d1 == Double.POSITIVE_INFINITY) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            } else {     // infinityOrNaN1 为 false，但 infinityOrNaN2 为 true
                double d2 = n2.doubleValue();
                if (Double.isNaN(d2) || d2 == Double.POSITIVE_INFINITY) {
                    return -1;
                } else {
                    return 1;
                }
            }
        }

        return toBigDecimal(n1).compareTo(toBigDecimal(n2));
    }

    /**
     * Getting index of maximum value in {@link Number} array.
     *
     * @param numbers {@link Number} array
     * @return index of maximum value, {@code -1} if not found.
     * @since 0.3.0
     */
    public static int indexOfMax(Number[] numbers) {
        if (G.isEmpty(numbers)) return -1;
        int index = -1;
        Number max = null;
        for (int i = 0; i < numbers.length; i++) {
            Number number = numbers[i];
            if (number != null) {
                if (max == null) {
                    max = number;
                    index = i;
                } else {
                    if (compare(number, max) == 1) {
                        max = number;
                        index = i;
                    }
                }
            }
        }
        return index;
    }

    /**
     * Getting index of minimum value in {@link Number} array.
     *
     * @param numbers {@link Number} array
     * @return index of minimum value, {@code -1} if not found.
     * @since 0.3.0
     */
    public static int indexOfMin(Number[] numbers) {
        if (G.isEmpty(numbers)) return -1;
        int index = -1;
        Number min = null;
        for (int i = 0; i < numbers.length; i++) {
            Number number = numbers[i];
            if (number != null) {
                if (min == null) {
                    min = number;
                    index = i;
                } else {
                    if (compare(number, min) == -1) {
                        min = number;
                        index = i;
                    }
                }
            }
        }
        return index;
    }

}
