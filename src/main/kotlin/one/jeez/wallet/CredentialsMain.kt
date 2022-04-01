package one.jeez.wallet

import org.web3j.crypto.Bip44WalletUtils
import org.web3j.crypto.MnemonicUtils
import java.io.IOException
import java.security.SecureRandom
import java.sql.DriverManager

object CredentialsMain {
    val secureRandom = SecureRandom()

    init {
        println(System.getProperty("java.runtime.name"))

        Class.forName("org.sqlite.JDBC")
    }

    val conn = DriverManager.getConnection("jdbc:sqlite:credentials.db")

    val runnable = Runnable{
        val initialEntropy = ByteArray(16)
        while (true) {
            try {
                secureRandom.nextBytes(initialEntropy)
                val mnemonic = MnemonicUtils.generateMnemonic(initialEntropy)
                val credentials = Bip44WalletUtils.loadBip44Credentials("", mnemonic)
                val statment = conn.prepareStatement(
                    "INSERT INTO credentials (ADDRESS, MNEMONIC_WORK) VALUES (?, ?)"
                )
                statment.setString(1, credentials.address)
                statment.setString(2, mnemonic)
//                val walletFile = Wallet.createStandard(password, credentials.ecKeyPair)
//                statment.setString(3, objectMapper.writeValueAsString(walletFile))
//                statment.setString(4, credentials.ecKeyPair.privateKey.toString(16))
                statment.execute()
                statment.close()
            } catch (e:IOException) {
                e.printStackTrace()
            }
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
//        val statment = conn.createStatement()
//        statment.execute("CREATE TABLE credentials(ID INTEGER PRIMARY KEY AUTOINCREMENT, ADDRESS VARCHAR(50), MNEMONIC_WORK VARCHAR(255) NOT NULL)")
//        statment.close()

        Thread(runnable).start()
        Thread(runnable).start()
        Thread(runnable).start()
        Thread(runnable).start()
        Thread(runnable).start()
        Thread(runnable).start()
        Thread(runnable).start()
        Thread(runnable).start()
        Thread(runnable).start()
        Thread(runnable).start()
        Thread(runnable).start()
        Thread(runnable).start()
        Thread(runnable).start()
        Thread(runnable).start()
        Thread(runnable).start()
        Thread(runnable).start()

        Thread(runnable).start()
        Thread(runnable).start()
        Thread(runnable).start()
        Thread(runnable).start()
        Thread(runnable).start()
        Thread(runnable).start()
        Thread(runnable).start()
        Thread(runnable).start()
        Thread(runnable).start()
        Thread(runnable).start()
        Thread(runnable).start()
        Thread(runnable).start()
        Thread(runnable).start()
        Thread(runnable).start()
        Thread(runnable).start()
        Thread(runnable).start()
    }
}