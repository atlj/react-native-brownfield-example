import React from 'react'
import { View, Text, SafeAreaView, useColorScheme } from 'react-native'

function App() {
  const colorScheme = useColorScheme();

  return (
    <View style={{
      flex: 1,
      backgroundColor: colorScheme === 'dark' ? '#000' : '#fff',
    }}>
      <SafeAreaView style={{
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center',
      }}>
        <Text
          style={{
            color: colorScheme === 'dark' ? '#fff' : '#000',
          }}
        >Hi mom from React Native!</Text>
      </SafeAreaView>
    </View>
  )
}

export default App
