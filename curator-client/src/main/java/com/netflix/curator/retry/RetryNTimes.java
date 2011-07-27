/*
 Copyright 2011 Netflix, Inc.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
 */
package com.netflix.curator.retry;

import com.google.common.base.Preconditions;

/**
 * Retry policy that retries a max number of times
 */
public class RetryNTimes extends SleepingRetry
{
    private final int sleepMsBetweenRetries;

    public RetryNTimes(int n, int sleepMsBetweenRetries)
    {
        super(n);
        this.sleepMsBetweenRetries = sleepMsBetweenRetries;
        Preconditions.checkArgument(n > 0);
    }

    @Override
    protected int getSleepTimeMs(int retryCount, long elapsedTimeMs)
    {
        return sleepMsBetweenRetries;
    }
}