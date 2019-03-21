# Android App Survival Guide

This repo contains sample apps and slides for my talks and workshops about Android development.

## AndroidVersionDemo

This app deliberately uses a feature being present only in Android P and later. Switch to branch androidversiondemo_api26 to see one way of supporting different versions.

## UnitTestDemo

This app demonstrates how a lot of current apps might look like (caution: not how they should ;-)).
For example, the version on master mixes core business logic and ui code. Also, there are no tests.
Branch unittestdemo_improved has, as the name suggests, some improvements. The aim of this branch is
not to be perfect but to provide a start.

## DebugDemo

This app shows various aspects of logging, debugging and profiling.

## SluggishAppDemo

As the name suggests, this app behaves badly. ;-)

## ServiceDemo

Shows a started service. Note that the version on master is not optimized for Android 8 and later. Switch to branch servicedemo_improved to see how a foreground service is implemented.

## JobSchedulerDemo

Shows how to implement periodic background jobs.